package org.sam.brokenforkmod.entity.client;

import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import org.sam.brokenforkmod.BrokenForkMod;
import org.sam.brokenforkmod.entity.custom.BrokenForkEntity;

public class BrokenForkRenderer extends EntityRenderer<BrokenForkEntity> {
    public static final Identifier TEXTURE = new Identifier(BrokenForkMod.MOD_ID, "textures/entity/broken_fork.png");
    private final BrokenForkModel model;

    public BrokenForkRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.model = new BrokenForkModel(context.getPart(ModModelLayers.BROKEN_FORK));
    }

    public void render(BrokenForkEntity brokenForkEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp(g, brokenForkEntity.prevYaw, brokenForkEntity.getYaw()) - 90.0F));
        matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(MathHelper.lerp(g, brokenForkEntity.prevPitch, brokenForkEntity.getPitch()) + 90.0F));
        VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumerProvider, this.model.getLayer(this.getTexture(brokenForkEntity)), false, brokenForkEntity.isEnchanted());
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStack.pop();
        super.render(brokenForkEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(BrokenForkEntity brokenForkEntity) {
        return TEXTURE;
    }
}