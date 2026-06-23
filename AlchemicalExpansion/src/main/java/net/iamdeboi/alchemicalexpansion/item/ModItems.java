package net.iamdeboi.alchemicalexpansion.item;

import net.iamdeboi.alchemicalexpansion.AlchemicalExpansion;
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
    public static final RegistryObject<Item> BELLADONNA = ITEMS.register("belladonna",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> AQUATIC_POWDER = ITEMS.register("aquatic_powder",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ARTHROPOD_POWDER = ITEMS.register("arthropod_powder",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BOTANICAL_POWDER = ITEMS.register("botanical_powder",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ENDER_POWDER = ITEMS.register("ender_powder",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FLESHY_POWDER = ITEMS.register("fleshy_powder",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GLITTERING_POWDER = ITEMS.register("glittering_powder",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NETHERBOUND_POWDER = ITEMS.register("netherbound_powder",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SPORE_POWDER = ITEMS.register("spore_powder",
            () -> new Item(new Item.Properties()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
