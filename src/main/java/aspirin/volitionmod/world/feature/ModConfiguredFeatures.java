package aspirin.volitionmod.world.feature;

import aspirin.volitionmod.VolitionMod;
import aspirin.volitionmod.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryEntryList;
import net.minecraft.util.registry.RegistryEntryList.Direct;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.AcaciaFoliagePlacer;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.BushFoliagePlacer;
import net.minecraft.world.gen.foliage.RandomSpreadFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.*;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> GODWOOD_TREE =
            ConfiguredFeatures.register("godwood_tree", Feature.TREE, new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(ModBlocks.GODWOOD_LOG),
                    new UpwardsBranchingTrunkPlacer(8, 7, 12, ConstantIntProvider.create(3), 0.4f, ConstantIntProvider.create(4), RegistryEntryList.of()),
                    BlockStateProvider.of(ModBlocks.GODWOOD_LEAVES),
                    new AcaciaFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(2)),
                    new TwoLayersFeatureSize(1, 0, 2)).build());

    public static void registerConfiguredFeatures() {
        VolitionMod.LOGGER.debug("Registering the ModConfiguredFeatures. Mod - " + VolitionMod.MOD_ID);
    }

}
