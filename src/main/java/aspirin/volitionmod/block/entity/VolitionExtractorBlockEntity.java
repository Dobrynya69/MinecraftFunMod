package aspirin.volitionmod.block.entity;

import aspirin.volitionmod.VolitionMod;
import aspirin.volitionmod.block.ModBlocks;
import aspirin.volitionmod.block.custom.VolitionExtractorBlock;
import aspirin.volitionmod.item.ModItems;
import aspirin.volitionmod.screen.VolitionExtractorScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class VolitionExtractorBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3, ItemStack.EMPTY);
    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 1000;

    public VolitionExtractorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.VOLITION_EXTRACTOR, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                switch (index) {
                    case 0: return VolitionExtractorBlockEntity.this.progress;
                    case 1: return VolitionExtractorBlockEntity.this.maxProgress;
                    default: return 0;
                }
            }

            @Override
            public void set(int index, int value) {
                switch(index) {
                    case 0: VolitionExtractorBlockEntity.this.progress = value; break;
                    case 1: VolitionExtractorBlockEntity.this.maxProgress = value; break;
                }
            }

            @Override
            public int size() {
                return 2;
            }
        };
    }
    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }
    @Override
    public Text getDisplayName() {
        return Text.literal("Volition Extractor");
    }
    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new VolitionExtractorScreenHandler(syncId, inv, this, this.propertyDelegate);
    }
    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("volition_extractor.progress", progress);
    }
    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
        progress = nbt.getInt("volition_extractor.progress");
    }
    private void resetProgress(VolitionExtractorBlockEntity entity, BlockState state) {
        if (!state.get(VolitionExtractorBlock.REST)){
            state = state.cycle(VolitionExtractorBlock.REST);
            Objects.requireNonNull(entity.getWorld()).setBlockState(entity.getPos(), state);
        }
        this.progress = 0;
    }
    public static void tick(World world, BlockPos blockPos, BlockState state, VolitionExtractorBlockEntity entity) {
        if(world.isClient()) {
            return;
        }
        if (entity.getStack(2).getItem() != ModItems.VOLITION_EXTRACT && !state.get(VolitionExtractorBlock.NOT_FINISHED)){
            state = state.cycle(VolitionExtractorBlock.NOT_FINISHED);
            Objects.requireNonNull(entity.getWorld()).setBlockState(entity.getPos(), state);
        }
        if(hasRecipe(entity)) {
            if (state.get(VolitionExtractorBlock.REST)){
                state = state.cycle(VolitionExtractorBlock.REST);
                Objects.requireNonNull(entity.getWorld()).setBlockState(entity.getPos(), state);
            }
            entity.progress++;
            markDirty(world, blockPos, state);
            if(entity.progress >= entity.maxProgress) {
                craftItem(entity, state);
            }
        } else {
            entity.resetProgress(entity, state);
            markDirty(world, blockPos, state);
        }
    }
    private static void craftItem(VolitionExtractorBlockEntity entity, BlockState state) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }
        if(hasRecipe(entity)) {
            if (state.get(VolitionExtractorBlock.NOT_FINISHED)){
                state = state.cycle(VolitionExtractorBlock.NOT_FINISHED);
                Objects.requireNonNull(entity.getWorld()).setBlockState(entity.getPos(), state);
            }
            entity.removeStack(1, 64);
            entity.removeStack(0, 1);
            entity.setStack(2, new ItemStack(ModItems.VOLITION_EXTRACT,
                    entity.getStack(2).getCount() + 1));
            entity.resetProgress(entity, state);
        }
    }
    private static boolean hasRecipe(VolitionExtractorBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        boolean hasPhysicallyVolitionStack = entity.getStack(1).getItem() == ModItems.PHYSICALLY_VOLITION && entity.getStack(1).getCount() == 64;
        boolean hasBigJar = entity.getStack(0).getItem() == ModItems.BIG_JAR;
        return hasPhysicallyVolitionStack && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, ModItems.VOLITION_EXTRACT) && hasBigJar;
    }
    private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory, Item output) {
        return inventory.getStack(2).getItem() == output || inventory.getStack(2).isEmpty();
    }
    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory inventory) {
        return inventory.getStack(2).getMaxCount() > inventory.getStack(2).getCount();
    }
}
