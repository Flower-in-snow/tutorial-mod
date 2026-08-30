package com.example.tutorialmod.datagen;

import com.example.tutorialmod.block.ModBlocks;
import com.example.tutorialmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.ICE_SPRAY_BLOCK);
        addDrop(ModBlocks.ICE_SPRAY_ORE, oreDrops(ModBlocks.ICE_SPRAY_ORE, ModItems.RAW_ICE_SPRAY_GEMSTONE));
        addDrop(ModBlocks.ICE_SPRAY_STAIRS);
        addDrop(ModBlocks.ICE_SPRAY_SLAB, slabDrops(ModBlocks.ICE_SPRAY_SLAB));
        addDrop(ModBlocks.ICE_SPRAY_BUTTON);
        addDrop(ModBlocks.ICE_SPRAY_PRESSURE_PLATE);
        addDrop(ModBlocks.ICE_SPRAY_FENCE);
        addDrop(ModBlocks.ICE_SPRAY_FENCE_GATE);
        addDrop(ModBlocks.ICE_SPRAY_WALL);
        addDrop(ModBlocks.ICE_SPRAY_DOOR, doorDrops(ModBlocks.ICE_SPRAY_DOOR));
        addDrop(ModBlocks.ICE_SPRAY_TRAPDOOR);
        addDrop(ModBlocks.POLISHING_MACHINE);
    }
}
