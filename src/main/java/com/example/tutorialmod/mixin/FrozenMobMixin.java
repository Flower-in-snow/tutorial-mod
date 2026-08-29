package com.example.tutorialmod.mixin;

import com.example.tutorialmod.effect.ModStatusEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class FrozenMobMixin {
    @Inject(method = "tick", at = @At("TAIL"))
    private void restoreFrozenMobAi(CallbackInfo ci){
        if ((Object) this instanceof MobEntity mobEntity && mobEntity.isAiDisabled() && !mobEntity.hasStatusEffect(ModStatusEffects.FROZEN)){
            mobEntity.setAiDisabled(false);
        }
    }
}
