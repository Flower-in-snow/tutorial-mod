package com.example.tutorialmod;

import com.example.tutorialmod.datagen.*;
import com.example.tutorialmod.sound.ModJukeboxSongs;
import com.example.tutorialmod.world.ModConfiguredFeatures;
import com.example.tutorialmod.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class TutorialModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(ModBlockTagsProvider::new);
		pack.addProvider(ModENUSLanguageProvider::new);
		pack.addProvider(ModItemTagsProvider::new);
		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModModelsProvider::new);
		pack.addProvider(ModRecipesProvider::new);
		pack.addProvider(ModZHCNLanguageProvider::new);
		pack.addProvider(ModPOITagProvider::new);
		pack.addProvider(ModWorldGen::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.JUKEBOX_SONG, ModJukeboxSongs::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
	}
}
