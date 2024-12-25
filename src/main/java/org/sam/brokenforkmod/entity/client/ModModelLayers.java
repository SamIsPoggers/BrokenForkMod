package org.sam.brokenforkmod.entity.client;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import org.sam.brokenforkmod.BrokenForkMod;

public class ModModelLayers {
    public static final EntityModelLayer BROKEN_FORK =
            new EntityModelLayer(new Identifier(BrokenForkMod.MOD_ID, "broken_fork"), "main");
}
