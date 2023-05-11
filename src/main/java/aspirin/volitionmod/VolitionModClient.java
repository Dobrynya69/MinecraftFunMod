package aspirin.volitionmod;

import aspirin.volitionmod.block.ModBlocks;
import aspirin.volitionmod.item.ModItems;
import aspirin.volitionmod.screen.ModScreenHandlers;
import aspirin.volitionmod.screen.VolitionExtractorScreen;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class VolitionModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreenHandlers.VOLITION_EXTRACTOR_SCREEN_HANDLER, VolitionExtractorScreen::new);
    }
}
