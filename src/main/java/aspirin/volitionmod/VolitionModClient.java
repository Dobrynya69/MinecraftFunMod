package aspirin.volitionmod;

import aspirin.volitionmod.item.ModItems;
import net.fabricmc.api.ClientModInitializer;

public class VolitionModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModItems.registerModItems();
    }
}
