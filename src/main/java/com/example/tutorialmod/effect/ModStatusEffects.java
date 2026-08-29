package com.example.tutorialmod.effect;

import com.example.tutorialmod.TutorialMod;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModStatusEffects {

    public static final RegistryEntry<StatusEffect> FROZEN = register("frozen", new FrozenStatusEffect(StatusEffectCategory.HARMFUL, 0x74C7EC));
    private static RegistryEntry<StatusEffect> register(String id, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(TutorialMod.MOD_ID, id), statusEffect);
    }

    public static void registerModStatusEffects() {

    }
}
