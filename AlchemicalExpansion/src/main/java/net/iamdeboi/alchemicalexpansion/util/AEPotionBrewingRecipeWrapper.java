package net.iamdeboi.alchemicalexpansion.util;

import net.iamdeboi.alchemicalexpansion.recipe.AEPotionBrewingRecipe;

public class AEPotionBrewingRecipeWrapper {
    private final AEPotionBrewingRecipe recipe;

    public AEPotionBrewingRecipeWrapper(AEPotionBrewingRecipe recipe) {
        this.recipe = recipe;
    }

    public AEPotionBrewingRecipe getRecipe() {
        return recipe;
    }
}
