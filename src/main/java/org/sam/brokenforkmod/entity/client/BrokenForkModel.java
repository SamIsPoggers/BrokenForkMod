package org.sam.brokenforkmod.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;

public class BrokenForkModel extends Model {
    private final ModelPart root;

    public BrokenForkModel(ModelPart root) {
        super(RenderLayer::getEntitySolid);
        this.root = root;
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, 5.0F, -0.5F, 1.0F, 22.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 12).cuboid(-1.5F, 17.0F, -0.5F, 1.0F, 10.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 12).cuboid(0.5F, 17.0F, -0.5F, 1.0F, 10.0F, 1.0F, new Dilation(0.0F))
                .uv(4, 2).cuboid(1.5F, -1.0F, 0.5F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F))
                .uv(3, 1).cuboid(1.5F, 1.0F, -0.5F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F))
                .uv(3, 1).cuboid(-0.5F, 1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(3, 1).cuboid(-2.5F, 1.0F, -0.5F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F))
                .uv(4, 2).cuboid(-0.5F, -3.0F, 0.5F, 1.0F, 4.0F, 0.0F, new Dilation(0.0F))
                .uv(4, 0).cuboid(-1.5F, 2.0F, -0.5F, 3.0F, 3.0F, 1.0F, new Dilation(0.0F))
                .uv(4, 2).cuboid(-2.5F, -3.0F, 0.5F, 1.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -3.0F, 0.0F));
        return TexturedModelData.of(modelData, 32, 32);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }
}