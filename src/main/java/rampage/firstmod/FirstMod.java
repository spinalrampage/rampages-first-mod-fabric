/*
Kinda Written By SpinalRampage (based off template)

Main Class that does cool things
 */
package rampage.firstmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FirstMod implements ModInitializer {
	// Give the Mod an ID
	public static final String MOD_ID = "rampages-gamer-tools"; // Sorry for changing this after the fact lmao



	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger(FirstMod.MOD_ID);

	// Gamer Debris PlacedFeature RegistryKey
	public static final RegistryKey<PlacedFeature> CUSTOM_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier("rampages-gamer-tools","gamer_debris"));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		// Register Items and Blocks from our Mod (I think)
		Items.registerModItems();
		Blocks.registerModBlocks();

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

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> { content.add(Items.GamerScrap); });
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> { content.add(Items.GamerIngot); });

		//ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> { content.add(Blocks.GamerDebris); });

		// Gamer Debris Ore Spawning
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, CUSTOM_ORE_PLACED_KEY);

		// Logger Stuff? Idk
		LOGGER.info("Hello Fabric world!");
	}
}