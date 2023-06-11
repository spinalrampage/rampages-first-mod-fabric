/*
Written by SpinalRampage

Hopefully adds new items to the game. Maybe. We'll see ig.
 */
package rampage.firstmod;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Items {

    // Item Instances
    public static final Item GamerSword = registerItem("gamer_sword",
            new Item(new FabricItemSettings()));//new Item(new FabricItemSettings());
    public static final Item GamerShovel = registerItem("gamer_shovel",
            new Item(new FabricItemSettings()));//new Item(new FabricItemSettings());

	// Registry.register(Registries.ITEM, new Identifier(FirstMod.MOD_ID, "gamersword"), GamerSword);

    // Method for Registering New Items
    private static Item registerItem(String name, Item item)
    {
        return Registry.register(Registries.ITEM, new Identifier(FirstMod.MOD_ID, name), item);
    }

    // Method for our main class to grab so we initialize new items on game load POG
    public static void registerModItems()
    {
        FirstMod.LOGGER.info("Registering Mod Items for " + FirstMod.MOD_ID);

    }
}
