/*
Written by SpinalRampage

Hopefully adds new items to the game. Maybe. We'll see ig.
 */
package rampage.firstmod;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import rampage.firstmod.item.CustomAxeItem;
import rampage.firstmod.item.CustomHoeItem;
import rampage.firstmod.item.CustomPickaxeItem;
import rampage.firstmod.item.GamerToolMaterial;

public class Items {

    // Gamer Blocks Instances

    // Gamer Tools Item Instances
    public static final Item GamerSword = registerItem("gamer_sword",
            new SwordItem(GamerToolMaterial.INSTANCE, 6, 1f, new Item.Settings()));
    public static final Item GamerShovel = registerItem("gamer_shovel",
            new ShovelItem(GamerToolMaterial.INSTANCE, 2.0f, -2.0f, new Item.Settings()));
    public static final Item GamerPickaxe = registerItem("gamer_pickaxe",
            new CustomPickaxeItem(GamerToolMaterial.INSTANCE, 1, -2.5f, new Item.Settings()));
    public static final Item GamerAxe = registerItem("gamer_axe",
            new CustomAxeItem(GamerToolMaterial.INSTANCE, 7, -2.5f, new Item.Settings()));
    public static final Item GamerHoe = registerItem("gamer_hoe",
            new CustomHoeItem(GamerToolMaterial.INSTANCE, 0, -2.5f, new Item.Settings()));

	// Registry.register(Registries.ITEM, new Identifier(FirstMod.MOD_ID, "gamersword"), GamerSword);

    // Method for Registering New Items
    private static Item registerItem(String name, Item item)
    {
        return Registry.register(Registries.ITEM, new Identifier(FirstMod.MOD_ID, name), item);
    }

    // Method for our main class to grab so that we initialize new items on game load POG
    public static void registerModItems()
    {
        FirstMod.LOGGER.info("Registering Mod Items for " + FirstMod.MOD_ID);

    }
}
