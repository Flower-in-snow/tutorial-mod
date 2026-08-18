package com.example.tutorialmod.datagen;

import com.example.tutorialmod.block.ModBlockFamilies;
import com.example.tutorialmod.block.ModBlocks;
import com.example.tutorialmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.data.family.BlockFamily;

public class ModModelsProvider extends FabricModelProvider {
    public ModModelsProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        //CubeAll是一个简单的立方体模型，所有的面都使用相同的纹理。它适用于像方块这样的简单方形物体。
        ModBlockFamilies.getFamilies()
                .filter(BlockFamily::shouldGenerateModels)
                .forEach(blockFamily -> blockStateModelGenerator
                        .registerCubeAllModelTexturePool(blockFamily.getBaseBlock())
                        .family(blockFamily));

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ICE_SPRAY_ORE);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        // GENERATED是一个用于生成物品模型的预定义模型类型。它适用于像物品这样的简单物体，通常是平面的。
        itemModelGenerator.register(ModItems.RAW_ICE_SPRAY_GEMSTONE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ICE_SPRAY_GEMSTONE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ICE_SPRAY_WAND, Models.GENERATED);
        itemModelGenerator.register(ModItems.ICE_ESSENCE, Models.GENERATED);
        itemModelGenerator.register(ModItems.FIRE_GEMSTONE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PROSPECTOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.PLATE, Models.GENERATED);

    }

}
