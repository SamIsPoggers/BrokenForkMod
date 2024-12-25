package org.sam.brokenforkmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.sam.brokenforkmod.BrokenForkMod;
import org.sam.brokenforkmod.item.custom.BrokenForkItem;

public class ModItems {
    //Register Broken Fork Item
    public static final Item BROKEN_FORK = registerItem("broken_fork",
            new BrokenForkItem(new FabricItemSettings().maxDamage(250)));

    private static void addItemsToCombatItemGroup(FabricItemGroupEntries fabricItemGroupEntries) {
        fabricItemGroupEntries.add(BROKEN_FORK);
    }

    //Helper method to register the Item(s)
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(BrokenForkMod.MOD_ID, name), item);
    }

    //Registers Items from this class
    public static void registerModItems() {
        BrokenForkMod.LOGGER.info("Registering Items for " + BrokenForkMod.MOD_ID);

        //Add Broken Fork item to Combat tab
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToCombatItemGroup);
    }
}