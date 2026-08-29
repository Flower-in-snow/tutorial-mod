package com.example.tutorialmod.datagen;

import com.example.tutorialmod.block.ModBlocks;
import com.example.tutorialmod.item.ModItemGroups;
import com.example.tutorialmod.item.ModItems;
import com.example.tutorialmod.item.custom.Bingonimbus;
import com.example.tutorialmod.item.custom.Prospector;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

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
        translationBuilder.add(ModItems.SORROW, "悲伤");

        translationBuilder.add(ModItems.ICE_SPRAY_WAND, "冰霜法杖");
        translationBuilder.add(ModItems.PROSPECTOR, "§4探矿器§r");
        translationBuilder.add(ModItems.BINGONIMBUS_2000, "§5Bingonimbus 2000§r镐");
        translationBuilder.add(ModItems.SORROW_HELMET, "悲伤头盔");
        translationBuilder.add(ModItems.SORROW_CHESTPLATE, "悲伤胸甲");
        translationBuilder.add(ModItems.SORROW_LEGGINGS, "悲伤护腿");
        translationBuilder.add(ModItems.SORROW_BOOTS, "悲伤靴子");


        translationBuilder.add(ModBlocks.ICE_SPRAY_BUTTON, "冰霜按钮");
        translationBuilder.add(ModBlocks.ICE_SPRAY_PRESSURE_PLATE, "冰霜压力板");
        translationBuilder.add(ModBlocks.ICE_SPRAY_FENCE, "冰霜栅栏");
        translationBuilder.add(ModBlocks.ICE_SPRAY_FENCE_GATE, "冰霜栅栏门");
        translationBuilder.add(ModBlocks.ICE_SPRAY_WALL, "冰霜砖块");
        translationBuilder.add(ModBlocks.ICE_SPRAY_DOOR, "冰霜门");
        translationBuilder.add(ModBlocks.ICE_SPRAY_TRAPDOOR, "冰霜活版门");
        translationBuilder.add(ModBlocks.ICE_SPRAY_STAIRS, "冰霜楼梯");
        translationBuilder.add(ModBlocks.ICE_SPRAY_SLAB, "冰霜台阶");
        translationBuilder.add(ModItems.PLATE, "盘子");
        translationBuilder.add(ModItems.HAT, "帽子");
        translationBuilder.add(ModItems.MUSIC_DISC_LOVE_2000, "音乐唱片 - 遠野ひかる - LOVE 2000_H");
        translationBuilder.add(ModBlocks.BOX, "箱子");
        translationBuilder.add(ModItemGroups.TUTORIAL_GROUP, "教程组");

        translationBuilder.add("entity.minecraft.villager.magician", "魔术师");
        translationBuilder.add("sounds.tutorialmod.prospector_found_ore", "探矿器找到了矿石");
        translationBuilder.add("sounds.tutorialmod.gemstone_block_break", "宝石方块破坏");
        translationBuilder.add("sounds.tutorialmod.gemstone_block_step", "宝石方块步履");
        translationBuilder.add("sounds.tutorialmod.gemstone_block_place", "宝石方块放置");
        translationBuilder.add("sounds.tutorialmod.gemstone_block_hit", "宝石方块击中");
        translationBuilder.add("sounds.tutorialmod.gemstone_block_fall", "宝石方块坠落");
        translationBuilder.add("jukebox_song.tutorialmod.love_2000", "音乐唱片 - 遠野ひかる - LOVE 2000_H");
        translationBuilder.add("sounds.tutorialmod.music_disc_love_2000", "音乐唱片 - 遠野ひかる - LOVE 2000_H");
        translationBuilder.add("container.box", "箱子");
        translationBuilder.add("sounds.tutorialmod.ice_spray", "冰霜喷射");

        translationBuilder.add(Prospector.KEY_PRECISE, "成功找到 ");
        translationBuilder.add(Prospector.KEY_ROUGH,  " 就在那！");

        translationBuilder.add(Prospector.Prospector_Line2, "一种用于查找稀缺矿物的工具 按住§5shift§r来精确查找");

        translationBuilder.add(Prospector.Prospector_Line1, "按住§5CTRL§r查看更多信息");
        translationBuilder.add(Bingonimbus.Bingoimbus_Tooltip_Line1, "一种强大的镐子似乎§6不会§r损坏");

    }
}
