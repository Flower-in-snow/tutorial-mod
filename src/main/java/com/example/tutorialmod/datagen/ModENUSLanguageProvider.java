package com.example.tutorialmod.datagen;

import com.example.tutorialmod.block.ModBlocks;
import com.example.tutorialmod.item.ModItemGroups;
import com.example.tutorialmod.item.ModItems;
import com.example.tutorialmod.item.custom.*;
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
        translationBuilder.add(ModItems.HYPERION, "§5Hyperion§r");
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
        translationBuilder.add(ModBlocks.BOX, "Box");
        translationBuilder.add(ModItems.PLATE, "Plate");
        translationBuilder.add(ModItems.HAT, "Hat");
        translationBuilder.add(ModItems.MUSIC_DISC_LOVE_2000, "Music Disc");
        translationBuilder.add(ModBlocks.POLISHING_MACHINE, "Polishing Machine");
        translationBuilder.add(ModBlocks.MENRIL_LEAVES, "Menril Leaves");
        translationBuilder.add(ModBlocks.MENRIL_LOG, "Menril Log");
        translationBuilder.add(ModBlocks.MENRIL_PLANKS, "Menril Planks");
        translationBuilder.add(ModBlocks.STRIPPED_MENRIL_LOG, "Stripped Menril Log");

        translationBuilder.add(ModItemGroups.TUTORIAL_GROUP, "Tutorial Group");

        translationBuilder.add("entity.minecraft.villager.magician", "Magician");
        translationBuilder.add("sounds.tutorialmod.prospector_found_ore", "Prospector Found Ore");
        translationBuilder.add("sounds.tutorialmod.gemstone_block_break", "Gemstone Block Break");
        translationBuilder.add("sounds.tutorialmod.gemstone_block_step", "Gemstone Block Step");
        translationBuilder.add("sounds.tutorialmod.gemstone_block_place", "Gemstone Block Place");
        translationBuilder.add("sounds.tutorialmod.gemstone_block_hit", "Gemstone Block Hit");
        translationBuilder.add("sounds.tutorialmod.gemstone_block_fall", "Gemstone Block Fall");
        translationBuilder.add("jukebox_song.tutorialmod.love_2000", "Music Disc - 遠野ひかる - LOVE 2000_H");
        translationBuilder.add("sounds.tutorialmod.misc_disc_love_2000", "Music Disc - 遠野ひかる - LOVE 2000_H");
        translationBuilder.add("container.box", "Box");
        translationBuilder.add("sounds.tutorialmod.ice_spray", "Ice Spray");
        translationBuilder.add("sounds.tutorialmod.teleport", "Teleport");
        translationBuilder.add("sounds.tutorialmod.explode", "Explode");
        translationBuilder.add("container.tutorialmod.polishing_machine", "Polishing Machine");


        translationBuilder.add(Prospector.KEY_PRECISE, "Successfully Found ");
        translationBuilder.add(Prospector.KEY_ROUGH, " is over there!");

        translationBuilder.add(Prospector.SPACE, " ");
        translationBuilder.add(Prospector.Prospector_Line1, "A Magic Wand for Precious Ores. Hold §5Shift§r for Precise Search");

        translationBuilder.add(Prospector.Prospector_Line2, "Hold §5CTRL§r for More Information");
        translationBuilder.add(Bingonimbus.Bingoimbus_Tooltip_Line1, "A powerful tool that §2doesn't§r seem to break");

        translationBuilder.add(ModArmorItem.Sorrow_ArmorTip_Line1, "§6 FULL SET BONUS: Mist Aura ( §r §e%d§r §6/4) §r");
        translationBuilder.add(ModArmorItem.Sorrow_ArmorTip_Line2, "§8 Hides the wearer in a guise of mist, §r");
        translationBuilder.add(ModArmorItem.Sorrow_ArmorTip_Line3, "§8 granting a strong mist aura. §r");

        translationBuilder.add(IceSprayWand.Ice_Spray_Wand_Tooltip_Line1, "§6Ability: Ice Spray§r §eRIGHT CLICK§r");
        translationBuilder.add(IceSprayWand.Ice_Spray_Wand_Tooltip_Line2, "§8Produces a cone of ice in front of the caster§r");
        translationBuilder.add(IceSprayWand.Ice_Spray_Wand_Tooltip_Line3, "§8that deals§r §c%s§r §8damage to mobs and freezes§r");
        translationBuilder.add(IceSprayWand.Ice_Spray_Wand_Tooltip_Line4, "§8them in place for §r§c%s§r §8seconds!§r");

        translationBuilder.add(Hyperion.Hyperion_Tooltip_Line1,"§6Ability: Wither Impact§r §eRIGHT CLICK§r");
        translationBuilder.add(Hyperion.Hyperion_Tooltip_Line2, "§8Teleports§r %s §ablocks§r §8ahead of you§8");
        translationBuilder.add(Hyperion.Hyperion_Tooltip_Line3, "§8dealing§r %s §8damage to nearby§r");
        translationBuilder.add(Hyperion.Hyperion_Tooltip_Line4, "§8enemies within a§r %s §8block radius.§r");
        translationBuilder.add(Hyperion.Hyperion_Tooltip_Line5, "§8Also reduces your Damage taken and§r");
        translationBuilder.add(Hyperion.Hyperion_Tooltip_Line6, "§8grants an absorption shield for§r %s §eseconds.§r");
    }
}
