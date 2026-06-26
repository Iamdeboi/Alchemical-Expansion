package net.iamdeboi.alchemicalexpansion;

import net.iamdeboi.alchemicalexpansion.block.ModBlocks;
import net.iamdeboi.alchemicalexpansion.block.entity.ModBlockEntities;
import net.iamdeboi.alchemicalexpansion.effect.ModEffects;
import net.iamdeboi.alchemicalexpansion.item.ModCreativeModeTabs;
import net.iamdeboi.alchemicalexpansion.item.ModItems;
import com.mojang.logging.LogUtils;
import net.iamdeboi.alchemicalexpansion.potion.ModPotions;
import net.iamdeboi.alchemicalexpansion.recipe.AEPotionBrewingRecipe;
import net.iamdeboi.alchemicalexpansion.recipe.ModRecipes;
import net.iamdeboi.alchemicalexpansion.screen.ModMenuTypes;
import net.iamdeboi.alchemicalexpansion.screen.MortarAndPestleScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(AlchemicalExpansion.MODID)
public class AlchemicalExpansion {
    public static final String MODID = "alchemicalexpansion";
    public static final Logger LOGGER = LogUtils.getLogger();

    public AlchemicalExpansion(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        //Register Creative Mode Tab for the mod
        ModCreativeModeTabs.register(modEventBus);

        // Register ModItem Registry
        ModItems.register(modEventBus);
        // Register ModBlocks Registry
        ModBlocks.register(modEventBus);

        // Register ModBlockEntities Registry
        ModBlockEntities.register(modEventBus);

        // Register ModMenu Registry
        ModMenuTypes.register(modEventBus);

        // Register ModRecipes Registry
        ModRecipes.register(modEventBus);

        // Register ModEffects Registry
        ModEffects.register(modEventBus);

        // Register ModPotions Registry
        ModPotions.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);

    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.BELLADONNA_PLANT.getId(), ModBlocks.POTTED_BELLADONNA);

            BrewingRecipeRegistry.addRecipe(new AEPotionBrewingRecipe(Potions.AWKWARD, ModItems.ARTHROPOD_POWDER.get(), ModPotions.SPIDERS_CLIMB_POTION.get()));

        });
    }

    // Add the example block item to the building blocks tab
    private void addCreative (BuildCreativeModeTabContentsEvent event) {

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            MenuScreens.register(ModMenuTypes.MORTAR_AND_PESTLE_MENU.get(), MortarAndPestleScreen::new);
        }
    }

}

