package aspirin.volitionmod.item;

import aspirin.volitionmod.VolitionMod;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup VOLITION = FabricItemGroupBuilder.build(
            new Identifier(VolitionMod.MOD_ID, "volition"), () -> new ItemStack(ModItems.PHYSICALLY_VOLITION));
}
