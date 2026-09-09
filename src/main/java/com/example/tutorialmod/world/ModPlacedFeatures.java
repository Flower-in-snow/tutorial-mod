package com.example.tutorialmod.world;

import com.example.tutorialmod.TutorialMod;
import com.example.tutorialmod.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {

    public static final RegistryKey<PlacedFeature> MENRIL_CHECKED = of("menril_checked");
    public static RegistryKey<PlacedFeature> of(String id) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(TutorialMod.MOD_ID, id));
    }

    public static void bootstrap(Registerable<PlacedFeature> featureRegisterable){
        RegistryEntryLookup<ConfiguredFeature<?, ?>> registryEntryLookup =featureRegisterable.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        register(featureRegisterable, MENRIL_CHECKED, registryEntryLookup.getOrThrow(ModConfiguredFeatures.MENRIL),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(2, 0.1f, 2),
                        ModBlocks.MENRIL_SAPLING
                ));
    }

    public static void register(
            Registerable<PlacedFeature> featureRegisterable,
            RegistryKey<PlacedFeature> key,
            RegistryEntry<ConfiguredFeature<?, ?>> feature,
            List<PlacementModifier> modifiers
    ) {
        featureRegisterable.register(key, new PlacedFeature(feature, List.copyOf(modifiers)));
    }

    public static void register(
            Registerable<PlacedFeature> featureRegisterable,
            RegistryKey<PlacedFeature> key,
            RegistryEntry<ConfiguredFeature<?, ?>> feature,
            PlacementModifier... modifiers
    ) {
        register(featureRegisterable, key, feature, List.of(modifiers));
    }
}
