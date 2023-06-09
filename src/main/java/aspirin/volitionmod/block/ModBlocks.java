package aspirin.volitionmod.block;

import aspirin.volitionmod.VolitionMod;
import aspirin.volitionmod.block.custom.VolitionExtractorBlock;
import aspirin.volitionmod.item.ModItemGroup;
import aspirin.volitionmod.world.feature.tree.GodwoodSaplingGenerator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    public static Block VOLITION_STONE = registerBlock("volition_stone",
            new Block(FabricBlockSettings.of(Material.STONE).luminance(8).strength(3f).requiresTool()),
            ModItemGroup.VOLITION);
    public static final Block GODWOOD_LOG = registerBlock("godwood_log",
            new PillarBlock(FabricBlockSettings.of(Material.WOOD).luminance(2).strength(6f).requiresTool()), ModItemGroup.VOLITION);
    public static final Block GODWOOD_WOOD = registerBlock("godwood_wood",
            new PillarBlock(FabricBlockSettings.of(Material.WOOD).luminance(2).strength(6f).requiresTool()), ModItemGroup.VOLITION);
    public static final Block STRIPPED_GODWOOD_LOG = registerBlock("stripped_godwood_log",
            new PillarBlock(FabricBlockSettings.of(Material.WOOD).luminance(2).strength(6f).requiresTool()), ModItemGroup.VOLITION);
    public static final Block STRIPPED_GODWOOD_WOOD = registerBlock("stripped_godwood_wood",
            new PillarBlock(FabricBlockSettings.of(Material.WOOD).luminance(2).strength(6f).requiresTool()), ModItemGroup.VOLITION);
    public static final Block GODWOOD_PLANKS = registerBlock("godwood_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)), ModItemGroup.VOLITION);
    public static final Block GODWOOD_LEAVES = registerBlock("godwood_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)), ModItemGroup.VOLITION);
    public static final Block GODWOOD_SAPLING = registerBlock("godwood_sapling",
            new SaplingBlock(new GodwoodSaplingGenerator(),
                    FabricBlockSettings.copy(Blocks.OAK_SAPLING)), ModItemGroup.VOLITION);
    public static final Block VOLITION_EXTRACTOR = registerBlock("volition_extractor",
            new VolitionExtractorBlock(FabricBlockSettings
                    .of(Material.STONE)
                    .strength(6f)
                    .requiresTool()
                    .luminance(state -> state.get(VolitionExtractorBlock.REST) ? 0 : 5)
                    .nonOpaque()),
            ModItemGroup.VOLITION);

    private static Block registerBlock(String name, Block block, ItemGroup tab){
        registerBlockItem(name, block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(VolitionMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup tab){
        return Registry.register(Registry.ITEM, new Identifier(VolitionMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(tab)));
    }

    public static void registerModBlocks(){
        VolitionMod.LOGGER.debug("Registering block. Mod - " + VolitionMod.MOD_ID);
    }
}
