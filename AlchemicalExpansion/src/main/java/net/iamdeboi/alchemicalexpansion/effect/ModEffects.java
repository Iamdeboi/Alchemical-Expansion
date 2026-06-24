package net.iamdeboi.alchemicalexpansion.effect;

import net.iamdeboi.alchemicalexpansion.AlchemicalExpansion;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.UUID;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, AlchemicalExpansion.MODID);


    public static final RegistryObject<MobEffect> SPIDERS_CLIMB_EFFECT = MOB_EFFECTS.register("spiders_climb",
            () -> new SpidersClimbEffect(MobEffectCategory.NEUTRAL, 0xff3737));
                    //.addAttributeModifier(Attributes.MOVEMENT_SPEED, String.valueOf(UUID.randomUUID()), -0.20F, AttributeModifier.Operation.MULTIPLY_TOTAL));




    public static void register (IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
