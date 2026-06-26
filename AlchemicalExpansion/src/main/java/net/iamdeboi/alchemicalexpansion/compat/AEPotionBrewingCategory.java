package net.iamdeboi.alchemicalexpansion.compat;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.iamdeboi.alchemicalexpansion.AlchemicalExpansion;
import net.iamdeboi.alchemicalexpansion.item.ModItems;
import net.iamdeboi.alchemicalexpansion.recipe.AEPotionBrewingRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class AEPotionBrewingCategory implements IRecipeCategory<AEPotionBrewingRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(AlchemicalExpansion.MODID,"ae_potion_brewing");
    public static final ResourceLocation TEXTURE = new ResourceLocation("textures/gui/container/brewing_stand.png");

    public static final RecipeType<AEPotionBrewingRecipe> AE_POTION_BREWING_RECIPES_TYPE =
            new RecipeType<>(UID, AEPotionBrewingRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public AEPotionBrewingCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 83);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModItems.ESSENCE_CONTAINER.get()));
    }

    @Override
    public RecipeType<AEPotionBrewingRecipe> getRecipeType() {
        return AE_POTION_BREWING_RECIPES_TYPE;
    }
    @Override
    public Component getTitle() {
        return Component.literal("Alchemical Expansion Potion Brewing");
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public @Nullable IDrawable getBackground() {
        return this.background;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, AEPotionBrewingRecipe recipe, IFocusGroup focus) {

    }
}
