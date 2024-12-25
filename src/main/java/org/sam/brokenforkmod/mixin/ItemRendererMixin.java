/*
Change Model if not in GUI
 */

package org.sam.brokenforkmod.mixin;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import org.sam.brokenforkmod.BrokenForkMod;
import org.sam.brokenforkmod.item.ModItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemRenderer.class)
public class ItemRendererMixin {
    @ModifyVariable(method = "renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformationMode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/client/render/model/BakedModel;)V",
    at = @At(value = "HEAD"), argsOnly = true)
    public BakedModel useBrokenForkModel(BakedModel value, ItemStack stack, ModelTransformationMode renderMode,
                                         boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers,
                                         int light, int overlay) {
        if (stack.isOf(ModItems.BROKEN_FORK) && renderMode != ModelTransformationMode.GUI && renderMode != ModelTransformationMode.GROUND) {
            return((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(
                    new ModelIdentifier(BrokenForkMod.MOD_ID, "broken_fork_3d", "inventory")
            );
        }
        return value;
    }
}
