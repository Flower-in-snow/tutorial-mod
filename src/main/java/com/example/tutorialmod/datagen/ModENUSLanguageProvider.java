package com.example.tutorialmod.datagen;

import com.example.tutorialmod.block.ModBlocks;
import com.example.tutorialmod.item.ModItemGroups;
import com.example.tutorialmod.item.ModItems;
import com.example.tutorialmod.item.custom.Prospector;
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
        translationBuilder.add(ModItems.PROSPECTOR, "Prospector");
        translationBuilder.add(ModItems.PLATE, "Plate");

        translationBuilder.add(ModBlocks.ICE_SPRAY_BUTTON, "Ice Spray Button");
        translationBuilder.add(ModBlocks.ICE_SPRAY_PRESSURE_PLATE, "Ice Spray Pressure Plate");
        translationBuilder.add(ModBlocks.ICE_SPRAY_FENCE, "Ice Spray Fence");
        translationBuilder.add(ModBlocks.ICE_SPRAY_FENCE_GATE, "Ice Spray Fence Gate");
        translationBuilder.add(ModBlocks.ICE_SPRAY_WALL, "Ice Spray Wall");
        translationBuilder.add(ModBlocks.ICE_SPRAY_DOOR, "Ice Spray Door");
        translationBuilder.add(ModBlocks.ICE_SPRAY_TRAPDOOR, "Ice Spray Trapdoor");
        translationBuilder.add(ModBlocks.ICE_SPRAY_STAIRS, "Ice Spray Stairs");
        translationBuilder.add(ModBlocks.ICE_SPRAY_SLAB, "Ice Spray Slab");

        translationBuilder.add(ModItemGroups.TUTORIAL_GROUP, "Tutorial Group");

        translationBuilder.add(Prospector.KEY_PRECISE, "Successfully Found ");
        translationBuilder.add(Prospector.KEY_ROUGH, " is over there!");
        translationBuilder.add(Prospector.Tooltip, "A Magic Wand for Precious Ores.Hold Shift for Precise Search");
        translationBuilder.add(Prospector.Basic_tooltip, "Hold §5CTRL§r for More Information");
    }
}
