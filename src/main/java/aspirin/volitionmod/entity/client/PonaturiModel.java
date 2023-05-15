package aspirin.volitionmod.entity.client;

import aspirin.volitionmod.VolitionMod;
import aspirin.volitionmod.entity.custom.GhostCarpEntity;
import aspirin.volitionmod.entity.custom.PonaturiEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PonaturiModel extends AnimatedGeoModel<PonaturiEntity> {
    @Override
    public Identifier getModelResource(PonaturiEntity object) {
        return new Identifier(VolitionMod.MOD_ID, "geo/ponaturi.geo.json");
    }

    @Override
    public Identifier getTextureResource(PonaturiEntity object) {
        return new Identifier(VolitionMod.MOD_ID, "textures/entity/ponaturi.png");
    }

    @Override
    public Identifier getAnimationResource(PonaturiEntity animatable) {
        return new Identifier(VolitionMod.MOD_ID, "animations/ponaturi.animation.json");
    }
}
