package aspirin.volitionmod;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VolitionMod implements ModInitializer {
    public static final String MOD_ID = "volitionmod";
    public static final Logger LOGGER = LoggerFactory.getLogger("volitionmod");

    @Override
    public void onInitialize() {
        LOGGER.info("Hello Fabric world!");
    }
}