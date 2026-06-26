package net.iamdeboi.alchemicalexpansion.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.iamdeboi.alchemicalexpansion.AlchemicalExpansion;
import net.iamdeboi.alchemicalexpansion.item.ModItems;
import net.iamdeboi.alchemicalexpansion.potion.ModPotions;
import net.iamdeboi.alchemicalexpansion.recipe.AEPotionBrewingRecipe;
import net.iamdeboi.alchemicalexpansion.recipe.MortarAndPestleGrindingRecipe;
import net.iamdeboi.alchemicalexpansion.screen.MortarAndPestleScreen;
import net.iamdeboi.alchemicalexpansion.util.AEPotionBrewingRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.ArrayList;
import java.util.List;

@JeiPlugin
public class JEIAlchemicalExpansionPlugin implements IModPlugin {

    // Custom Crafted Potion wrapped recipes are put up here!
    public static final RecipeType<AEPotionBrewingRecipeWrapper> SPIDERS_CLIMB_POTION_RECIPE =
            new RecipeType<>(new ResourceLocation(AlchemicalExpansion.MODID, "spiders_climb_potion"),
                    AEPotionBrewingRecipeWrapper.class);

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(AlchemicalExpansion.MODID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new MPGrindingCategory(registration.getJeiHelpers().getGuiHelper()));

    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        List<MortarAndPestleGrindingRecipe> mpGrindingRecipes = recipeManager.getAllRecipesFor(MortarAndPestleGrindingRecipe.Type.INSTANCE);
        registration.addRecipes(MPGrindingCategory.MP_GRINDING_TYPE, mpGrindingRecipes);

        List recipes = new ArrayList<>();

        // Spider's Climb:
        recipes.add(new AEPotionBrewingRecipeWrapper(
                new AEPotionBrewingRecipe(Potions.AWKWARD, ModItems.ARTHROPOD_POWDER.get(), ModPotions.SPIDERS_CLIMB_POTION.get()
        )));

        // Add the list of recipes after iterating over all possible recipes above:
        registration.addRecipes(SPIDERS_CLIMB_POTION_RECIPE, recipes);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(MortarAndPestleScreen.class, 75, 35, 24, 17,
                MPGrindingCategory.MP_GRINDING_TYPE);
    }
}
