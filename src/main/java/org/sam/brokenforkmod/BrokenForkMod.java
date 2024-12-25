package org.sam.brokenforkmod;

import net.fabricmc.api.ModInitializer;
import org.sam.brokenforkmod.entity.ModEntities;
import org.sam.brokenforkmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BrokenForkMod implements ModInitializer {
    public static String MOD_ID = "brokenfork";
    public static Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        //Calling Register ModItems
        ModItems.registerModItems();
        ModEntities.registerModEntities();
    }
}