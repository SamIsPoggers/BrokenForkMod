package org.sam.brokenforkmod.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import org.sam.brokenforkmod.entity.ModEntities;
import org.sam.brokenforkmod.entity.client.BrokenForkModel;
import org.sam.brokenforkmod.entity.client.BrokenForkRenderer;
import org.sam.brokenforkmod.entity.client.ModModelLayers;

public class BrokenForkModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.BROKEN_FORK, BrokenForkRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.BROKEN_FORK, BrokenForkModel::getTexturedModelData);
    }
}
