package com.example.tutorialmod.datagen;

import com.example.tutorialmod.block.ModBlocks;
import com.example.tutorialmod.item.ModItemGroups;
import com.example.tutorialmod.item.ModItems;
import com.example.tutorialmod.item.custom.Pickonimbus;
import com.example.tutorialmod.item.custom.Prospector;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.io.StringReader;
import java.util.concurrent.CompletableFuture;

public class ModZHCNLanguageProvider extends FabricLanguageProvider {
    public ModZHCNLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "zh_cn", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModBlocks.ICE_SPRAY_BLOCK, "冰霜方块");
        translationBuilder.add(ModBlocks.ICE_SPRAY_ORE, "冰霜矿石");
        translationBuilder.add(ModItems.ICE_ESSENCE, "冰霜精华");

        translationBuilder.add(ModItems.RAW_ICE_SPRAY_GEMSTONE, "原始冰霜宝石");
        translationBuilder.add(ModItems.ICE_SPRAY_GEMSTONE, "冰霜宝石");
        translationBuilder.add(ModItems.FIRE_GEMSTONE, "火焰宝石");
        translationBuilder.add(ModItems.ICE_SPRAY_WAND, "冰霜法杖");
        translationBuilder.add(ModItems.PROSPECTOR, "§4探矿器§r");
        translationBuilder.add(ModItems.PLATE, "盘子");
        translationBuilder.add(ModItems.PICKONIMBUS, "§5Pickonimbus§r镐");

        translationBuilder.add(ModBlocks.ICE_SPRAY_BUTTON, "冰霜按钮");
        translationBuilder.add(ModBlocks.ICE_SPRAY_PRESSURE_PLATE, "冰霜压力板");
        translationBuilder.add(ModBlocks.ICE_SPRAY_FENCE, "冰霜栅栏");
        translationBuilder.add(ModBlocks.ICE_SPRAY_FENCE_GATE, "冰霜栅栏门");
        translationBuilder.add(ModBlocks.ICE_SPRAY_WALL, "冰霜砖块");
        translationBuilder.add(ModBlocks.ICE_SPRAY_DOOR, "冰霜门");
        translationBuilder.add(ModBlocks.ICE_SPRAY_TRAPDOOR, "冰霜活版门");
        translationBuilder.add(ModBlocks.ICE_SPRAY_STAIRS, "冰霜楼梯");
        translationBuilder.add(ModBlocks.ICE_SPRAY_SLAB, "冰霜台阶");

        translationBuilder.add(ModItemGroups.TUTORIAL_GROUP, "教程组");
        translationBuilder.add(Prospector.KEY_PRECISE, "成功找到 ");
        translationBuilder.add(Prospector.KEY_ROUGH,  " 就在那！");
        translationBuilder.add(Prospector.Tooltip, "一种用于查找稀缺矿物的工具 按住shift来精确查找");
        translationBuilder.add(Prospector.Basic_tooltip, "按住§5CTRL§r查看更多信息");
        translationBuilder.add(Pickonimbus.Tooltip, "一种强大的稿子在使用§22,000§r次后损坏");
    }
}
