package com.example.tutorialmod.datagen;

import com.example.tutorialmod.block.ModBlocks;
import com.example.tutorialmod.item.ModItemGroups;
import com.example.tutorialmod.item.ModItems;
import com.example.tutorialmod.item.custom.ModArmorItem;
import com.example.tutorialmod.item.custom.Bingonimbus;
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
        translationBuilder.add(ModItems.SORROW, "Sorrow");
        translationBuilder.add(ModItems.FIRE_GEMSTONE, "Fire Gemstone");

        translationBuilder.add(ModItems.ICE_SPRAY_WAND, "§6Ice Spray Wand§r");
        translationBuilder.add(ModItems.PROSPECTOR, "§4Prospector§r");
        translationBuilder.add(ModItems.BINGONIMBUS_2000, "§5Bingonimbus 2000§r");
        translationBuilder.add(ModItems.SORROW_CHESTPLATE, "§6Sorrow Chestplate§r");
        translationBuilder.add(ModItems.SORROW_LEGGINGS, "§6Sorrow Leggings§r");
        translationBuilder.add(ModItems.SORROW_BOOTS, "§6Sorrow Boots§r");
        translationBuilder.add(ModItems.SORROW_HELMET, "§6Sorrow Helmet§r");

        translationBuilder.add(ModBlocks.ICE_SPRAY_BUTTON, "Ice Spray Button");
        translationBuilder.add(ModBlocks.ICE_SPRAY_PRESSURE_PLATE, "Ice Spray Pressure Plate");
        translationBuilder.add(ModBlocks.ICE_SPRAY_FENCE, "Ice Spray Fence");
        translationBuilder.add(ModBlocks.ICE_SPRAY_FENCE_GATE, "Ice Spray Fence Gate");
        translationBuilder.add(ModBlocks.ICE_SPRAY_WALL, "Ice Spray Wall");
        translationBuilder.add(ModBlocks.ICE_SPRAY_DOOR, "Ice Spray Door");
        translationBuilder.add(ModBlocks.ICE_SPRAY_TRAPDOOR, "Ice Spray Trapdoor");
        translationBuilder.add(ModBlocks.ICE_SPRAY_STAIRS, "Ice Spray Stairs");
        translationBuilder.add(ModBlocks.ICE_SPRAY_SLAB, "Ice Spray Slab");
        translationBuilder.add(ModItems.PLATE, "Plate");
        translationBuilder.add(ModItems.HAT, "Hat");

        translationBuilder.add(ModItemGroups.TUTORIAL_GROUP, "Tutorial Group");

        translationBuilder.add("entity.minecraft.villager.magician", "Magician");

        translationBuilder.add(Prospector.KEY_PRECISE, "Successfully Found ");
        translationBuilder.add(Prospector.KEY_ROUGH, " is over there!");
        translationBuilder.add(Prospector.Tooltip, "A Magic Wand for Precious Ores. Hold §5Shift§r for Precise Search");
        translationBuilder.add(Prospector.Basic_tooltip, "Hold §5CTRL§r for More Information");
        translationBuilder.add(Bingonimbus.Tooltip, "A powerful tool that §2doesn't§r seem to break");
        translationBuilder.add(ModArmorItem.Sorrow_ArmorTip_1, "§6FULL SET BONUS: Mist Aura (§r§e%d§r§6/4)§r");
        translationBuilder.add(ModArmorItem.Sorrow_ArmorTip_2, "§8Hides the wearer in a guise of mist,§r");
        translationBuilder.add(ModArmorItem.Sorrow_ArmorTip_3, "§8granting a strong mist aura.§r");
    }
}
