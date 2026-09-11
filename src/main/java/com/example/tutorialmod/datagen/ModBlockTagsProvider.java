package com.example.tutorialmod.datagen;

import com.example.tutorialmod.block.ModBlocks;
import com.example.tutorialmod.tags.ModBlockTags;
import com.example.tutorialmod.tags.ModItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagsProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.ICE_SPRAY_BLOCK)
                .add(ModBlocks.ICE_SPRAY_ORE)
                .add(ModBlocks.POLISHING_MACHINE)
                .add(ModBlocks.BOX);

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.MENRIL_LOG)
                .add(ModBlocks.STRIPPED_MENRIL_LOG)
                .add(ModBlocks.MENRIL_PLANKS)
                .add(ModBlocks.MENRIL_SIGN)
                .add(ModBlocks.MENRIL_WALL_SIGN);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ICE_SPRAY_BLOCK)
                .add(ModBlocks.ICE_SPRAY_ORE)
                .add(ModBlocks.POLISHING_MACHINE)
                .add(ModBlocks.BOX);

        getOrCreateTagBuilder(ModBlockTags.PROSPECTOR_ORE_LIST)
                .forceAddTag(BlockTags.DIAMOND_ORES)
                .forceAddTag(BlockTags.EMERALD_ORES);

        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.ICE_SPRAY_FENCE);

        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.ICE_SPRAY_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.ICE_SPRAY_WALL);

        getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS)
                .add(ModBlocks.ICE_SPRAY_BUTTON);

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.MENRIL_LOG)
                .add(ModBlocks.STRIPPED_MENRIL_LOG);

        getOrCreateTagBuilder(BlockTags.PLANKS)
                .add(ModBlocks.MENRIL_PLANKS);

        getOrCreateTagBuilder(BlockTags.LEAVES)
                .add(ModBlocks.MENRIL_LEAVES);

    }
}
