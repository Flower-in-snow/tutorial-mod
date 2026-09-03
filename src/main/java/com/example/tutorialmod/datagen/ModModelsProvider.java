package com.example.tutorialmod.datagen;

import com.example.tutorialmod.block.ModBlockFamilies;
import com.example.tutorialmod.block.ModBlocks;
import com.example.tutorialmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.ArmorItem;

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
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.POLISHING_MACHINE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.BOX);

        blockStateModelGenerator.registerLog(ModBlocks.MENRIL_LOG).log(ModBlocks.MENRIL_LOG);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_MENRIL_LOG).log(ModBlocks.STRIPPED_MENRIL_LOG);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MENRIL_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MENRIL_LEAVES);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        // GENERATED是一个用于生成物品模型的预定义模型类型。它适用于像物品这样的简单物体，通常是平面的。
        itemModelGenerator.register(ModItems.RAW_ICE_SPRAY_GEMSTONE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ICE_SPRAY_GEMSTONE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ICE_SPRAY_WAND, Models.GENERATED);
        itemModelGenerator.register(ModItems.ICE_ESSENCE, Models.GENERATED);
        itemModelGenerator.register(ModItems.FIRE_GEMSTONE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SORROW, Models.GENERATED);

        //工具为手持物品形式
        itemModelGenerator.register(ModItems.BINGONIMBUS_2000, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PROSPECTOR, Models.HANDHELD);
        itemModelGenerator.register(ModItems.HYPERION, Models.HANDHELD);

        itemModelGenerator.register(ModItems.MUSIC_DISC_LOVE_2000, Models.TEMPLATE_MUSIC_DISC);

        //盔甲也不一样
        itemModelGenerator.registerArmor((ArmorItem) ModItems.SORROW_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.SORROW_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.SORROW_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.SORROW_BOOTS);

    }

}
