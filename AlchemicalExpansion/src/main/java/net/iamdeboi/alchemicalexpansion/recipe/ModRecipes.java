package net.iamdeboi.alchemicalexpansion.recipe;

import net.iamdeboi.alchemicalexpansion.AlchemicalExpansion;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, AlchemicalExpansion.MODID);

    public static final RegistryObject<RecipeSerializer<MortarAndPestleGrindingRecipe>> MORTAR_AND_PESTLE_GRINDING_SERIALIZER =
            SERIALIZERS.register("mortar_and_pestle_grinding", () -> MortarAndPestleGrindingRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
