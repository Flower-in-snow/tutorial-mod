package com.example.tutorialmod;

import com.example.tutorialmod.block.ModBlocks;
import com.example.tutorialmod.block.entity.ModBlockEntities;
import com.example.tutorialmod.effect.ModStatusEffects;
import com.example.tutorialmod.item.ModItemGroups;
import com.example.tutorialmod.item.ModItems;
import com.example.tutorialmod.screen.ModScreenHandlers;
import com.example.tutorialmod.sound.ModSoundEvents;
import com.example.tutorialmod.tags.ModBlockTags;
import com.example.tutorialmod.util.ModCustomTrades;
import com.example.tutorialmod.util.ModLootTableModifiers;
import com.example.tutorialmod.villager.ModCustomVillagers;
import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");

		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		ModBlocks.registerModBlocks();
		ModBlockTags.registerModBlockTags();
		ModLootTableModifiers.ModifyLootTable();
		ModCustomTrades.registerModCustomTrades();
		ModCustomVillagers.registerCustomVillagers();
		ModSoundEvents.registerModSoundEvents();
		ModBlockEntities.registerModBlockEntities();
		ModStatusEffects.registerModStatusEffects();
		ModScreenHandlers.registerScreenHandlers();

		//api的写法
		//FuelRegistry.INSTANCE.add(ModItems.FIRE_GEMSTONE, 1600);

//		初始化调用
	}
	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}
