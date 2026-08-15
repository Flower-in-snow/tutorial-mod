package com.example.tutorialmod.datagen;

import com.example.tutorialmod.block.ModBlocks;
import com.example.tutorialmod.item.ModItemGroups;
import com.example.tutorialmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModZHCNLanguageProvider extends FabricLanguageProvider {
    public ModZHCNLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "zh_cn", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModBlocks.ICE_SPRAY_BLOCK, "冰霜方块");
        translationBuilder.add(ModBlocks.ICE_SPRAY_ORE, "冰霜矿石");
        translationBuilder.add(ModItems.ICE_ESSENCE, "冰霜精华");

        translationBuilder.add(ModItems.RAW_ICE_SPRAY_GEMSTONE, "原始冰霜宝石");
        translationBuilder.add(ModItems.ICE_SPRAY_GEMSTONE, "冰霜宝石");
        translationBuilder.add(ModItems.FIRE_GEMSTONE, "火焰宝石");
        translationBuilder.add(ModItems.ICE_SPRAY_WAND, "冰霜法杖");
        translationBuilder.add(ModItems.PROSPECTOR, "探矿器");

        translationBuilder.add(ModItemGroups.TUTORIAL_GROUP, "教程组");
    }
}
