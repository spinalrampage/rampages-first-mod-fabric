/*
Written by SpinalRampage

Hopefully adds new blocks to the game. Maybe. We'll see ig.
 */
package rampage.firstmod;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class Blocks {

    // Gamer Blocks Instances
    public static final Block GamerDebris = registerBlocks("gamer_debris",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(net.minecraft.block.Blocks.DIAMOND_ORE).strength(4.0f).hardness(30f).requiresTool(),
                    UniformIntProvider.create(8, 15)));

    // Method for Registering New Blocks
    public static Block registerBlocks(String name, Block block)
    {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(FirstMod.MOD_ID, name), block);
    }

    // Method for Registering New Block Items (for the blocks)
    public static Item registerBlockItem(String name, Block block)
    {
        return Registry.register(Registries.ITEM, new Identifier(FirstMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks()
    {
        FirstMod.LOGGER.info("Registering Mod Blocks for " + FirstMod.MOD_ID);
    }
}
