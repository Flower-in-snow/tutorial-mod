package com.example.tutorialmod.world;

import com.example.tutorialmod.TutorialMod;
import com.example.tutorialmod.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> MENRIL = of("menril");//Tree Configured Features

    public static final RegistryKey<ConfiguredFeature<?, ?>> IRIS = of("iris");//Vegetation Configured Features

    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_ICE_SPRAY = of("ore_ice_spray");//Ore Configured Features
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_ICE_SPRAY_NETHER = of("ore_ice_spray_nether");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_ICE_SPRAY_END = of("ore_ice_spray_end");

    private static TreeFeatureConfig.Builder builder(Block log, Block leaves, int baseHeight, int firstRandomHeight, int secondRandomHeight, int radius) {
        return new TreeFeatureConfig.Builder(
                BlockStateProvider.of(log),
                new StraightTrunkPlacer(baseHeight, firstRandomHeight, secondRandomHeight),
                BlockStateProvider.of(leaves),
                new BlobFoliagePlacer(ConstantIntProvider.create(radius), ConstantIntProvider.create(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)
        );
    }

    private static TreeFeatureConfig.Builder menril(){
        return builder(ModBlocks.MENRIL_LOG, ModBlocks.MENRIL_LEAVES, 5, 2, 2, 2).ignoreVines();
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> of(String id) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(TutorialMod.MOD_ID, id));
    }

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> featureRegisterable){
        ConfiguredFeatures.register(featureRegisterable, MENRIL, Feature.TREE, menril().build());
        ConfiguredFeatures.register(featureRegisterable, IRIS, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2,
                PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.IRIS)))));

        RuleTest stoneReplace = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepSlateReplace = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherRackReplace = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endStoneReplace = new BlockMatchRuleTest(Blocks.END_STONE);
        List<OreFeatureConfig.Target> overWorldList = List.of(
                OreFeatureConfig.createTarget(stoneReplace, ModBlocks.ICE_SPRAY_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(deepSlateReplace, ModBlocks.ICE_SPRAY_ORE.getDefaultState())
        );
        List<OreFeatureConfig.Target> netherList = List.of(
                OreFeatureConfig.createTarget(netherRackReplace, ModBlocks.ICE_SPRAY_ORE.getDefaultState())
        );
        List<OreFeatureConfig.Target> endList = List.of(
                OreFeatureConfig.createTarget(endStoneReplace, ModBlocks.ICE_SPRAY_ORE.getDefaultState())
        );

        ConfiguredFeatures.register(featureRegisterable, ORE_ICE_SPRAY, Feature.ORE, new OreFeatureConfig(overWorldList, 4));
        ConfiguredFeatures.register(featureRegisterable, ORE_ICE_SPRAY_NETHER, Feature.ORE, new OreFeatureConfig(netherList, 4));
        ConfiguredFeatures.register(featureRegisterable, ORE_ICE_SPRAY_END, Feature.ORE, new OreFeatureConfig(endList, 4));
    }
}
