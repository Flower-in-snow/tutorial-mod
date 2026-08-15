package com.example.tutorialmod.datagen;

import com.example.tutorialmod.block.ModBlocks;
import com.example.tutorialmod.item.ModItemGroups;
import com.example.tutorialmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModENUSLanguageProvider extends FabricLanguageProvider {
    public ModENUSLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModBlocks.ICE_SPRAY_BLOCK, "Ice Spray Block");
        translationBuilder.add(ModBlocks.ICE_SPRAY_ORE, "Ice Spray Ore");
        translationBuilder.add(ModItems.ICE_ESSENCE, "Ice Essence");

        translationBuilder.add(ModItems.RAW_ICE_SPRAY_GEMSTONE, "Raw Ice Spray Gemstone");
        translationBuilder.add(ModItems.ICE_SPRAY_GEMSTONE, "Ice Spray Gemstone");
        translationBuilder.add(ModItems.FIRE_GEMSTONE, "Fire Gemstone");
        translationBuilder.add(ModItems.ICE_SPRAY_WAND, "Ice Spray Wand");

        translationBuilder.add(ModItemGroups.TUTORIAL_GROUP, "Tutorial Group");
    }
}
