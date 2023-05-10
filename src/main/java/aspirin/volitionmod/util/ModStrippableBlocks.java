package aspirin.volitionmod.util;

import aspirin.volitionmod.block.ModBlocks;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;

public class ModStrippableBlocks {
    public static void registerStrippables() {
        StrippableBlockRegistry.register(ModBlocks.GODWOOD_LOG, ModBlocks.STRIPPED_GODWOOD_LOG);
        StrippableBlockRegistry.register(ModBlocks.GODWOOD_WOOD, ModBlocks.STRIPPED_GODWOOD_WOOD);
    }
}
