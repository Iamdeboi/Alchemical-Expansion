package net.iamdeboi.alchemicalexpansion.item;

import net.iamdeboi.alchemicalexpansion.AlchemicalExpansion;
import net.iamdeboi.alchemicalexpansion.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AlchemicalExpansion.MODID);

    public static final RegistryObject<CreativeModeTab> ALCHEMICAL_EXPANSION_TAB = CREATIVE_MODE_TABS.register("alchemical_expansion_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ESSENCE_CONTAINER.get()))
                    .title(Component.translatable("creativetab.alchemical_expansion_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.ALCHEMICAL_BOLUS.get());
                        pOutput.accept(ModItems.ESSENCE_CONTAINER.get());
                        pOutput.accept(ModItems.BELLADONNA.get());

                        pOutput.accept(ModItems.AQUATIC_POWDER.get());
                        pOutput.accept(ModItems.ARTHROPOD_POWDER.get());
                        pOutput.accept(ModItems.BOTANICAL_POWDER.get());
                        pOutput.accept(ModItems.ENDER_POWDER.get());
                        pOutput.accept(ModItems.FLESHY_POWDER.get());
                        pOutput.accept(ModItems.GLITTERING_POWDER.get());
                        pOutput.accept(ModItems.NETHERBOUND_POWDER.get());

                        pOutput.accept(ModBlocks.BELLADONNA_PLANT.get());

                        pOutput.accept(ModBlocks.ALEMBIC_BLOCK.get());
                        pOutput.accept(ModBlocks.MORTAR_AND_PESTLE_BLOCK.get());

                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
