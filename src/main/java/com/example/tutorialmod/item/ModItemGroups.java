package com.example.tutorialmod.item;

import com.example.tutorialmod.TutorialMod;
import com.example.tutorialmod.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final RegistryKey<ItemGroup> TUTORIAL_GROUP = register("tutorial_group");
    //创建物品栏的唯一Key并存起来，这个key可以自己决定

    private static RegistryKey<ItemGroup> register(String id) {//创建一个物品栏的唯一key的方法
        return RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(TutorialMod.MOD_ID,id));
    }
    public static void registeredItemGroups(){//注册物品栏的方法
        Registry.register(Registries.ITEM_GROUP, TUTORIAL_GROUP, ItemGroup.create(ItemGroup.Row.TOP,7)
                        //第二个参数有两种写法，可以是key可以是Identifier id
                .displayName(Text.translatable("itemGroup.tutorialmod.tutorial"))//这里的key可以在lang文件里定义，随便写
                .icon(() -> new ItemStack(ModItems.RAW_ICE_SPRAY_GEMSTONE))//这里是物品栏的图标
                .entries((displayContext, entries) -> {
                    entries.add(ModItems.RAW_ICE_SPRAY_GEMSTONE);//这里是物品栏的内容
                    entries.add(ModItems.ICE_SPRAY_GEMSTONE);
                    entries.add(ModBlocks.ICE_SPRAY_ORE);
                    entries.add(ModItems.ICE_SPRAY_WAND);
                    entries.add(ModBlocks.ICE_SPRAY_BLOCK);
                    entries.add(ModItems.ICE_ESSENCE);
                    entries.add(ModItems.FIRE_GEMSTONE);
                    entries.add(ModItems.PROSPECTOR);
                })
                        .build()
                );

    }
}
