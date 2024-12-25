/*
Will register our custom Trident Like Entity here.
 */
package org.sam.brokenforkmod.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import org.sam.brokenforkmod.BrokenForkMod;
import org.sam.brokenforkmod.entity.custom.BrokenForkEntity;

public class ModEntities {
    public static final EntityType<BrokenForkEntity> BROKEN_FORK = register(
            "broken_fork",
            EntityType.Builder.<BrokenForkEntity>create(BrokenForkEntity::new, SpawnGroup.MISC).setDimensions(0.5F, 0.5F).maxTrackingRange(4).trackingTickInterval(20)
    );

    private static <T extends Entity> EntityType<T> register(String id, EntityType.Builder<T> type) {
        return Registry.register(Registries.ENTITY_TYPE, id, type.build(id));
    }

    public static void registerModEntities() {
        BrokenForkMod.LOGGER.info("Registering Entities for " + BrokenForkMod.MOD_ID);
    }
}