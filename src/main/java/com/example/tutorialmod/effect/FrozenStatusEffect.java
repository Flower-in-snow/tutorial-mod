package com.example.tutorialmod.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.mob.MobEntity;

public class FrozenStatusEffect extends StatusEffect {

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        entity.setVelocity(0, Math.min(entity.getVelocity().y, 0), 0);
        if (entity instanceof MobEntity mobEntity){
            mobEntity.setAiDisabled(true);
        }
        return true;
    }

    protected FrozenStatusEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }
}
