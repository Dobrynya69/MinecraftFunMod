package aspirin.volitionmod.block.entity;

import aspirin.volitionmod.VolitionMod;
import aspirin.volitionmod.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlockEntities {
    public static BlockEntityType<VolitionExtractorBlockEntity> VOLITION_EXTRACTOR;

    public static void registerBlockEntities() {
        VOLITION_EXTRACTOR = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(VolitionMod.MOD_ID, "volition_extractor"),
                FabricBlockEntityTypeBuilder.create(VolitionExtractorBlockEntity::new,
                        ModBlocks.VOLITION_EXTRACTOR).build(null));
    }
}
