package aspirin.volitionmod.screen;

import net.minecraft.screen.ScreenHandlerType;

public class ModScreenHandlers {
    public static ScreenHandlerType<VolitionExtractorScreenHandler> VOLITION_EXTRACTOR_SCREEN_HANDLER;

    public static void registerAllScreenHandlers() {
        VOLITION_EXTRACTOR_SCREEN_HANDLER = new ScreenHandlerType<>(VolitionExtractorScreenHandler::new);
    }
}
