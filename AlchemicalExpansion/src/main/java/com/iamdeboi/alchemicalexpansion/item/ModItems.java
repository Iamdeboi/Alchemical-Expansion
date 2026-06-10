package com.iamdeboi.alchemicalexpansion.item;

import com.iamdeboi.alchemicalexpansion.AlchemicalExpansion;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, AlchemicalExpansion.MODID);

    public static final RegistryObject<Item> ALCHEMICAL_BOLUS = ITEMS.register("alchemical_bolus",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ESSENCE_CONTAINER = ITEMS.register("essence_container",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
