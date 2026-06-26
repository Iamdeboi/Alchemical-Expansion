package net.iamdeboi.alchemicalexpansion.potion;

import net.iamdeboi.alchemicalexpansion.AlchemicalExpansion;
import net.iamdeboi.alchemicalexpansion.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(ForgeRegistries.POTIONS, AlchemicalExpansion.MODID);

    public static final RegistryObject<Potion> SPIDERS_CLIMB_POTION = POTIONS.register("spiders_climb_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.SPIDERS_CLIMB_EFFECT.getHolder().get().get(), 600, 0)));
    public static final RegistryObject<Potion> FORTUNATE_POTION = POTIONS.register("fortunate_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.FORTUNATE_EFFECT.getHolder().get().get(), 600, 0)));

    public static void register(IEventBus modEventBus) {
        POTIONS.register(modEventBus);
    }
}
