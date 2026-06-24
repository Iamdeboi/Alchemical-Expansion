package net.iamdeboi.alchemicalexpansion.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.iamdeboi.alchemicalexpansion.AlchemicalExpansion;
import net.iamdeboi.alchemicalexpansion.recipe.MortarAndPestleGrindingRecipe;
import net.iamdeboi.alchemicalexpansion.screen.MortarAndPestleScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;

@JeiPlugin
public class JEIAlchemicalExpansionPlugin implements IModPlugin {

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
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(MortarAndPestleScreen.class, 75, 35, 24, 17,
                MPGrindingCategory.MP_GRINDING_TYPE);
    }
}
