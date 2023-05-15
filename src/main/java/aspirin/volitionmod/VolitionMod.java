package aspirin.volitionmod;

import aspirin.volitionmod.block.ModBlocks;
import aspirin.volitionmod.block.entity.ModBlockEntities;
import aspirin.volitionmod.entity.ModEntities;
import aspirin.volitionmod.entity.custom.GhostCarpEntity;
import aspirin.volitionmod.entity.custom.PonaturiEntity;
import aspirin.volitionmod.item.ModItems;
import aspirin.volitionmod.screen.ModScreenHandlers;
import aspirin.volitionmod.util.ModStrippableBlocks;
import aspirin.volitionmod.world.feature.ModConfiguredFeatures;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.client.render.RenderLayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib3.GeckoLib;

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

        ModBlockEntities.registerBlockEntities();
        ModScreenHandlers.registerAllScreenHandlers();

        GeckoLib.initialize();
        FabricDefaultAttributeRegistry.register(ModEntities.GHOST_CARP, GhostCarpEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.PONATURI, PonaturiEntity.setAttributes());
    }
}