package com.example.tutorialmod.block;

import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.registry.Registries;

import java.util.Map;
import java.util.stream.Stream;

public class ModBlockFamilies {
    private static final Map<Block, BlockFamily> BASE_BLOCKS_TO_FAMILIES = Maps.newHashMap();

    public static BlockFamily.Builder register(Block baseBlock) {
        BlockFamily.Builder builder = new BlockFamily.Builder(baseBlock);
        BlockFamily blockFamily = BASE_BLOCKS_TO_FAMILIES.put(baseBlock, builder.build());
        if (blockFamily != null) {
            throw new IllegalStateException("Duplicate family definition for " + Registries.BLOCK.getId(baseBlock));
        } else {
            return builder;
        }
    }
    public static Stream<BlockFamily> getFamilies() {
        return BASE_BLOCKS_TO_FAMILIES.values().stream();
    }

    public static final BlockFamily ICE_SPRAY_BLOCK = register(ModBlocks.ICE_SPRAY_BLOCK)
            .button(ModBlocks.ICE_SPRAY_BUTTON)
            .fence(ModBlocks.ICE_SPRAY_FENCE)
            .fenceGate(ModBlocks.ICE_SPRAY_FENCE_GATE)
            .wall(ModBlocks.ICE_SPRAY_WALL)
            .door(ModBlocks.ICE_SPRAY_DOOR)
            .trapdoor(ModBlocks.ICE_SPRAY_TRAPDOOR)
            .stairs(ModBlocks.ICE_SPRAY_STAIRS)
            .slab(ModBlocks.ICE_SPRAY_SLAB)
            .pressurePlate(ModBlocks.ICE_SPRAY_PRESSURE_PLATE)
            .unlockCriterionName("has_blocks")
            .build();

    public static final BlockFamily MENRIL = register(ModBlocks.MENRIL_PLANKS)
            .sign(ModBlocks.MENRIL_SIGN, ModBlocks.MENRIL_WALL_SIGN)
            .unlockCriterionName("has_planks")
            .build();

}
