/*
Kinda Written By SpinalRampage (based off template)

Main Class that does cool things
 */
package rampage.firstmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FirstMod implements ModInitializer {
	// Give the Mod an ID
	public static final String MOD_ID = "rampages-first-mod";



	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger(FirstMod.MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		// Register Items from our Mod (I think)
		Items.registerModItems();

		// Make Items Fuel
		FuelRegistry.INSTANCE.add(Items.GamerSword, 300);
		FuelRegistry.INSTANCE.add(Items.GamerShovel, 300);
		FuelRegistry.INSTANCE.add(Items.GamerPickaxe, 300);
		FuelRegistry.INSTANCE.add(Items.GamerHoe, 300);
		FuelRegistry.INSTANCE.add(Items.GamerAxe, 300);

		// Add Items to Groups
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> { content.add(Items.GamerSword); });
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> { content.add(Items.GamerShovel); });
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> { content.add(Items.GamerPickaxe); });
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> { content.add(Items.GamerHoe); });
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> { content.add(Items.GamerAxe); });

		// Logger Stuff? Idk
		LOGGER.info("Hello Fabric world!");
	}
}