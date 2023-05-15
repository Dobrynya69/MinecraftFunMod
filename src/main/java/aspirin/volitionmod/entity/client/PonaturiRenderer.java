package aspirin.volitionmod.entity.client;

import aspirin.volitionmod.VolitionMod;
import aspirin.volitionmod.entity.custom.GhostCarpEntity;
import aspirin.volitionmod.entity.custom.PonaturiEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class PonaturiRenderer extends GeoEntityRenderer<PonaturiEntity> {
    public PonaturiRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new PonaturiModel());
        this.shadowRadius = 0.5f;
    }

    @Override
    public Identifier getTextureResource(PonaturiEntity instance) {
        return new Identifier(VolitionMod.MOD_ID, "textures/entity/ponaturi.png");
    }

    @Override
    public RenderLayer getRenderType(PonaturiEntity animatable, float partialTicks, MatrixStack stack, VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, Identifier textureLocation) {
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
