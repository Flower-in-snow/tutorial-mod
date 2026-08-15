package com.example.tutorialmod.item;

import com.example.tutorialmod.TutorialMod;
import com.example.tutorialmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
//    下面代码的意思是创造了一个全局物品引入方法，他的名字是registeredItems，返回类型是Item,这样方便赋值后变量调取，后面是两个形参
//    后面想引用只需registeredItems()
    private static Item registeredItems(String id, Item item){
//        return Registry.register(Registries.ITEM, RegistryKey.of(Registries.ITEM.getKey(), Identifier.of(TutorialMod.MOD_ID, id)), item)
//        查看Items类代码我们发现，注册物品的本质是用Registry类里的register方法
//        上述这样写也可以，但是我们查看Registry类里的register方法，发现register方法可以简化
        return Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, id), item);
    }
    public static final Item ICE_SPRAY_WAND = registeredItems("ice_spray_wand", new Item(new Item.Settings()));//  创造新物品
    public static final Item RAW_ICE_SPRAY_GEMSTONE = registeredItems("raw_ice_spray_gemstone", new Item(new Item.Settings()));
    public static final Item ICE_SPRAY_GEMSTONE = registeredItems("ice_spray_gemstone", new Item(new Item.Settings()));
    public static final Item FIRE_GEMSTONE = registeredItems("fire_gemstone", new Item(new Item.Settings()));

    public static final Item ICE_ESSENCE = registeredItems("ice_essence", new ModFoodComponentsItem(new Item.Settings().food(ModFoodComponentsItem.ICE_ESSENCE)));
    //    这里的ModFoodComponentsItem是我自己写的一个类，继承了Item类，重写了getMaxUseTime方法
    public static void addItemtoIngredients(FabricItemGroupEntries fabricItemGroupEntries){
        //创建一个方法，参数是当前指定的物品栏栏目里面物品集合，这取决于我们在下面注册的物品栏栏目
        fabricItemGroupEntries.add(ICE_SPRAY_GEMSTONE);
        fabricItemGroupEntries.add(RAW_ICE_SPRAY_GEMSTONE);
    }

    public static void addItemtoNatural(FabricItemGroupEntries fabricItemGroupEntries){
        //创建一个方法，参数是当前指定的物品栏栏目里面物品集合，这取决于我们在下面注册的物品栏栏目
        fabricItemGroupEntries.add(ModBlocks.ICE_SPRAY_ORE);
    }

    public static void addItemtoCombat(FabricItemGroupEntries fabricItemGroupEntries){
        //创建一个方法，参数是当前指定的物品栏栏目里面物品集合，这取决于我们在下面注册的物品栏栏目
        fabricItemGroupEntries.add(ICE_SPRAY_WAND);
    }

    public static void addItemtoBuildingBlocks(FabricItemGroupEntries fabricItemGroupEntries){
        //创建一个方法，参数是当前指定的物品栏栏目里面物品集合，这取决于我们在下面注册的物品栏栏目
        fabricItemGroupEntries.add(ModBlocks.ICE_SPRAY_BLOCK);
    }

    public static void addItemtoFoodAndDrink(FabricItemGroupEntries fabricItemGroupEntries){
        //创建一个方法，参数是当前指定的物品栏栏目里面物品集合，这取决于我们在下面注册的物品栏栏目
        fabricItemGroupEntries.add(ICE_ESSENCE);
    }

    public static void registeredModItems(){
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemtoIngredients);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(ModItems::addItemtoNatural);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemtoCombat);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(ModItems::addItemtoBuildingBlocks);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemtoFoodAndDrink);
        //在 ItemGroupEvents 里，监听 ‘修改 X 物品栏条目’ 这个事件，并在事件发生时执行 addItemtoX 这个方法
        TutorialMod.LOGGER.info("Registering Items");//无意义的代码，方便主程序内调用加载
    }
}
