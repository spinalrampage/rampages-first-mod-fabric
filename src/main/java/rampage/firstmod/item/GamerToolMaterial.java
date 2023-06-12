/*
Written by SpinalRampage

Adds a Tool Material for the Gamer tier
 */
package rampage.firstmod.item;

import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class GamerToolMaterial implements ToolMaterial {

    // Instance
    public static final GamerToolMaterial INSTANCE = new GamerToolMaterial();

    // Tool Material Properties
    @Override
    public int getDurability() {
        return 3000;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 30.0f;
    }

    @Override
    public float getAttackDamage() {
        return 6.0f;
    }

    @Override
    public int getMiningLevel() {
        return MiningLevels.NETHERITE;
    }

    @Override
    public int getEnchantability() {
        return 30;
    }

    // TODO: Add Gamer Ingot here after the Ingot Item is made
    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }
}
