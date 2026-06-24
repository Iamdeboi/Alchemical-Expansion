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
import net.iamdeboi.alchemicalexpansion.block.ModBlocks;
import net.iamdeboi.alchemicalexpansion.recipe.MortarAndPestleGrindingRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.Nullable;

public class MPGrindingCategory implements IRecipeCategory<MortarAndPestleGrindingRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(AlchemicalExpansion.MODID,"mortar_and_pestle_grinding");
    public static final ResourceLocation TEXTURE = new ResourceLocation(AlchemicalExpansion.MODID, "textures/gui/mortar_and_pestle_block_gui.png");

    public static final RecipeType<MortarAndPestleGrindingRecipe> MP_GRINDING_TYPE =
            new RecipeType<>(UID, MortarAndPestleGrindingRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public MPGrindingCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE,0,0,176,85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.MORTAR_AND_PESTLE_BLOCK.get()));
    }

    @Override
    public RecipeType<MortarAndPestleGrindingRecipe> getRecipeType() {
        return MP_GRINDING_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.alchemicalexpansion.mortar_and_pestle_block");
    }

    @Override
    public @Nullable IDrawable getBackground() {
        return this.background;
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, MortarAndPestleGrindingRecipe recipe, IFocusGroup focuses) {
        // Input Ingredients
        builder.addSlot(RecipeIngredientRole.INPUT, 26, 35).addIngredients(recipe.getIngredients().get(0));
        // Output
        builder.addSlot(RecipeIngredientRole.OUTPUT, 134, 35).addItemStack(recipe.getResultItem(null));
    }
}
