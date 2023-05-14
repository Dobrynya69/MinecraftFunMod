package aspirin.volitionmod.item;

import aspirin.volitionmod.VolitionMod;
import aspirin.volitionmod.entity.ModEntities;
import aspirin.volitionmod.entity.custom.GhostCarpEntity;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static Item PHYSICALLY_VOLITION = registerItem("physically_volition",
            new Item(new FabricItemSettings().group(ModItemGroup.VOLITION)));
    public static Item BIG_JAR = registerItem("big_jar",
            new Item(new FabricItemSettings().group(ModItemGroup.VOLITION)));
    public static Item VOLITION_EXTRACT = registerItem("volition_extract",
            new Item(new FabricItemSettings().group(ModItemGroup.VOLITION)));

    public static Item GHOST_CARP_SPAWN_EGG = registerItem("ghost_carp_spawn_egg",
            new SpawnEggItem(ModEntities.GHOST_CARP, 0x21688f, 0x2b84b5, new FabricItemSettings().group(ModItemGroup.VOLITION)));
    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(VolitionMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        VolitionMod.LOGGER.debug("Registering item. Mod - " + VolitionMod.MOD_ID);
    }
}
