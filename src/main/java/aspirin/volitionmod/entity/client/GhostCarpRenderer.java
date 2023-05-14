package aspirin.volitionmod.entity.client;

import aspirin.volitionmod.VolitionMod;
import aspirin.volitionmod.entity.custom.GhostCarpEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class GhostCarpRenderer extends GeoEntityRenderer<GhostCarpEntity> {
    public GhostCarpRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new GhostCarpModel());
        this.shadowRadius = 0.2f;
    }

    @Override
    public Identifier getTextureResource(GhostCarpEntity instance) {
        return new Identifier(VolitionMod.MOD_ID, "textures/entity/ghost_carp.png");
    }

    @Override
    public RenderLayer getRenderType(GhostCarpEntity animatable, float partialTicks, MatrixStack stack, VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, Identifier textureLocation) {
        return RenderLayer.getEntityTranslucent(getTextureLocation(animatable));
    }
}
