package aspirin.volitionmod;

import aspirin.volitionmod.block.ModBlocks;
import aspirin.volitionmod.item.ModItems;
import aspirin.volitionmod.screen.ModScreenHandlers;
import aspirin.volitionmod.screen.VolitionExtractorScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;

public class VolitionModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreenHandlers.VOLITION_EXTRACTOR_SCREEN_HANDLER, VolitionExtractorScreen::new);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.VOLITION_EXTRACTOR, RenderLayer.getTranslucent());
    }
}
