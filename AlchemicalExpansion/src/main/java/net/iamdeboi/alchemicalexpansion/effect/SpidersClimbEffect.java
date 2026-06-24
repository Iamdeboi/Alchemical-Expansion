package net.iamdeboi.alchemicalexpansion.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class SpidersClimbEffect extends MobEffect {

    public SpidersClimbEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);

    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        // Slowing Effect [UNUSED TEMPORARY SOLUTION]
        if (!pLivingEntity.getPersistentData().getBoolean("SpidersClimbApplied")) {
            int slowDuration = 200/(1 + pAmplifier);
            pLivingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, slowDuration, 0, false, false, true));

            pLivingEntity.getPersistentData().putBoolean("SpidersClimbApplied", true);

        }

        // Climbing Effect which activates when in horizontal contact with a surface (wall climbing!)
        if (pLivingEntity.horizontalCollision) {
            Vec3 initialVec = pLivingEntity.getDeltaMovement();
            Vec3 climbVec = new Vec3(initialVec.x, 0.2D, initialVec.z);
            pLivingEntity.setDeltaMovement(climbVec.scale(0.97D));
        }

        super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }

    @Override
    public void removeAttributeModifiers(LivingEntity pLivingEntity, AttributeMap pAttributeMap, int pAmplifier) {
        super.removeAttributeModifiers(pLivingEntity, pAttributeMap, pAmplifier);
        // Reset the custom slowing effect when the potion effect expires
        pLivingEntity.getPersistentData().putBoolean("SpidersClimbApplied", false);
    }
}

