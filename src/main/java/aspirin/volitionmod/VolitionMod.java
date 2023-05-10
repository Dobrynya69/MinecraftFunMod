package aspirin.volitionmod;

import aspirin.volitionmod.block.ModBlocks;
import aspirin.volitionmod.item.ModItems;
import aspirin.volitionmod.util.ModStrippableBlocks;
import aspirin.volitionmod.world.feature.ModConfiguredFeatures;
import aspirin.volitionmod.world.gen.ModTreeGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VolitionMod implements ModInitializer {
    public static final String MOD_ID = "volitionmod";
    public static final Logger LOGGER = LoggerFactory.getLogger("volitionmod");

    @Override
    public void onInitialize() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GODWOOD_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GODWOOD_SAPLING, RenderLayer.getCutout());

        ModItems.registerModItems();
        ModBlocks.registerModBlocks();

        ModStrippableBlocks.registerStrippables();
        ModConfiguredFeatures.registerConfiguredFeatures();

        ModTreeGeneration.generateTrees();
    }
}