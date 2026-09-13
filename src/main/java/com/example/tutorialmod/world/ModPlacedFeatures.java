package com.example.tutorialmod.world;

import com.example.tutorialmod.TutorialMod;
import com.example.tutorialmod.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class  ModPlacedFeatures {

    public static final RegistryKey<PlacedFeature> MENRIL_CHECKED = of("menril_checked");//Tree Placed Features

    public static final RegistryKey<PlacedFeature> IRIS_KEY = of("iris");//Vegetation Placed Features

    public static final RegistryKey<PlacedFeature> ORE_ICE_SPRAY = of("ore_ice_spray");
    public static final RegistryKey<PlacedFeature> ORE_ICE_SPRAY_NETHER = of("ore_ice_spray_nether");
    public static final RegistryKey<PlacedFeature> ORE_ICE_SPRAY_END = of("ore_ice_spray_end");

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

        PlacedFeatures.register(featureRegisterable, IRIS_KEY, registryEntryLookup.getOrThrow(ModConfiguredFeatures.IRIS),
                RarityFilterPlacementModifier.of(4), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        PlacedFeatures.register(featureRegisterable, ORE_ICE_SPRAY, registryEntryLookup.getOrThrow(ModConfiguredFeatures.ORE_ICE_SPRAY),
                ModOrePlacements.modifiersWithCount(12, HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));

        PlacedFeatures.register(featureRegisterable, ORE_ICE_SPRAY_NETHER, registryEntryLookup.getOrThrow(ModConfiguredFeatures.ORE_ICE_SPRAY_NETHER),
                ModOrePlacements.modifiersWithCount(12, HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));

        PlacedFeatures.register(featureRegisterable, ORE_ICE_SPRAY_END, registryEntryLookup.getOrThrow(ModConfiguredFeatures.ORE_ICE_SPRAY_END),
                ModOrePlacements.modifiersWithCount(12, HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));
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
