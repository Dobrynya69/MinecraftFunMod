package aspirin.volitionmod.item;

import aspirin.volitionmod.VolitionMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static Item PHYSICALLY_VOLITION = registerItem("physically_volition",
            new Item(new FabricItemSettings().group(ModItemGroup.VOLITION)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(VolitionMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        VolitionMod.LOGGER.debug("Registering item. Mod - " + VolitionMod.MOD_ID);
    }
}
