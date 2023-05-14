package aspirin.volitionmod.entity.client;

import aspirin.volitionmod.VolitionMod;
import aspirin.volitionmod.entity.custom.GhostCarpEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GhostCarpModel extends AnimatedGeoModel<GhostCarpEntity>{
    @Override
    public Identifier getModelResource(GhostCarpEntity object) {
        return new Identifier(VolitionMod.MOD_ID, "geo/ghost_carp.geo.json");
    }

    @Override
    public Identifier getTextureResource(GhostCarpEntity object) {
        return new Identifier(VolitionMod.MOD_ID, "textures/entity/ghost_carp.png");
    }

    @Override
    public Identifier getAnimationResource(GhostCarpEntity animatable) {
        return new Identifier(VolitionMod.MOD_ID, "animations/ghost_carp.animation.json");
    }
}
