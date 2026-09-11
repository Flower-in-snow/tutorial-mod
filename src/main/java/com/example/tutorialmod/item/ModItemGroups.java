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
    public static void registerItemGroups(){//注册物品栏的方法
        Registry.register(Registries.ITEM_GROUP, TUTORIAL_GROUP, ItemGroup.create(ItemGroup.Row.TOP,7)
                        //第二个参数有两种写法，可以是key可以是Identifier id
                .displayName(Text.translatable("itemGroup.tutorialmod.tutorial"))//这里的key可以在lang文件里定义，随便写
                .icon(() -> new ItemStack(ModItems.RAW_ICE_SPRAY_GEMSTONE))//这里是物品栏的图标
                .entries((displayContext, entries) -> {
                    entries.add(ModItems.RAW_ICE_SPRAY_GEMSTONE);//这里是物品栏的内容
                    entries.add(ModItems.ICE_SPRAY_GEMSTONE);
                    entries.add(ModBlocks.ICE_SPRAY_ORE);
                    entries.add(ModItems.ICE_SPRAY_WAND);
                    entries.add(ModItems.HYPERION);
                    entries.add(ModBlocks.ICE_SPRAY_BLOCK);
                    entries.add(ModItems.ICE_ESSENCE);
                    entries.add(ModItems.FIRE_GEMSTONE);
                    entries.add(ModItems.PROSPECTOR);
                    entries.add(ModItems.PLATE);
                    entries.add(ModItems.BINGONIMBUS_2000);
                    entries.add(ModItems.SORROW);
                    entries.add(ModItems.SORROW_HELMET);
                    entries.add(ModItems.SORROW_CHESTPLATE);
                    entries.add(ModItems.SORROW_LEGGINGS);
                    entries.add(ModItems.SORROW_BOOTS);
                    entries.add(ModItems.MUSIC_DISC_LOVE_2000);
                    entries.add(ModBlocks.BOX);
                    entries.add(ModBlocks.POLISHING_MACHINE);
                    entries.add(ModBlocks.MENRIL_LEAVES);
                    entries.add(ModBlocks.MENRIL_LOG);
                    entries.add(ModBlocks.MENRIL_PLANKS);
                    entries.add(ModBlocks.STRIPPED_MENRIL_LOG);
                    entries.add(ModItems.MENRIL_SIGN);
                    entries.add(ModItems.MENRIL_HANGING_SIGN);
                    entries.add(ModBlocks.MENRIL_SAPLING);
                    entries.add(ModBlocks.IRIS);

                    entries.add(ModBlocks.ICE_SPRAY_STAIRS);
                    entries.add(ModBlocks.ICE_SPRAY_SLAB);
                    entries.add(ModBlocks.ICE_SPRAY_BUTTON);
                    entries.add(ModBlocks.ICE_SPRAY_PRESSURE_PLATE);
                    entries.add(ModBlocks.ICE_SPRAY_FENCE);
                    entries.add(ModBlocks.ICE_SPRAY_FENCE_GATE);
                    entries.add(ModBlocks.ICE_SPRAY_WALL);
                    entries.add(ModBlocks.ICE_SPRAY_DOOR);
                    entries.add(ModBlocks.ICE_SPRAY_TRAPDOOR);
                    entries.add(ModItems.HAT);
                })
                        .build()
                );

    }
}
