package com.example.tutorialmod.item;

import com.example.tutorialmod.TutorialMod;
import com.example.tutorialmod.block.ModBlocks;
import com.example.tutorialmod.item.custom.*;
import com.example.tutorialmod.sound.ModJukeboxSongs;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.UnbreakableComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
//    下面代码的意思是创造了一个全局物品引入方法，他的名字是registeredItems，返回类型是Item,这样方便赋值后变量调取，后面是两个形参
//    后面想引用只需registeredItems()
    private static Item registeredItems(String id, Item item){
//        return Registry.register(Registries.ITEM, RegistryKey.of(Registries.ITEM.getKey(), Identifier.of(TutorialMod.MOD_ID, id)), item)
//        查看Items类代码我们发现，注册物品的本质是用Registry类里的register方法
//        上述这样写也可以，但是我们查看Registry类里的register方法，发现register方法可以简化
        return Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, id), item);
    }
    public static final Item ICE_SPRAY_WAND = registeredItems("ice_spray_wand", new IceSprayWand(new Item.Settings()
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(false)).rarity(Rarity.EPIC).maxCount(1)));//  创造新物品
    public static final Item RAW_ICE_SPRAY_GEMSTONE = registeredItems("raw_ice_spray_gemstone", new Item(new Item.Settings()));
    public static final Item ICE_SPRAY_GEMSTONE = registeredItems("ice_spray_gemstone", new Item(new Item.Settings()));
    public static final Item FIRE_GEMSTONE = registeredItems("fire_gemstone", new Item(new Item.Settings().fireproof()));
    public static final Item SORROW = registeredItems("sorrow", new Item(new Item.Settings().rarity(Rarity.RARE)));

    public static final Item MUSIC_DISC_LOVE_2000 = registeredItems("music_disc_love_2000", new Item(new Item.Settings().maxCount(1)
            .rarity(Rarity.RARE).jukeboxPlayable(ModJukeboxSongs.LOVE_2000)));
    public static final Item ICE_ESSENCE = registeredItems("ice_essence", new ModFoodComponentsItem(new Item.Settings().food(ModFoodComponentsItem.ICE_ESSENCE)));
    public static final Item PROSPECTOR = registeredItems("prospector", new Prospector(new Item.Settings().maxDamage(127)));
    public static final Item PLATE = registeredItems("plate", new Item(new Item.Settings()));

    public static final Item BINGONIMBUS_2000 = registeredItems("bingonimbus_2000",
            new Bingonimbus(ModToolMaterials.BINGONIMBUS_2000, new Item.Settings().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(false))
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.BINGONIMBUS_2000, 29.0f, -2.8f))));

    public static final Item SORROW_HELMET = registeredItems("sorrow_helmet",
            new ModArmorItem(ModArmorMaterials.SORROW, ArmorItem.Type.HELMET,
                    new Item.Settings().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(false)).fireproof().maxCount(1)));

    public static final Item SORROW_CHESTPLATE = registeredItems("sorrow_chestplate",
            new ModArmorItem(ModArmorMaterials.SORROW, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(false)).fireproof().maxCount(1)));

    public static final Item SORROW_LEGGINGS = registeredItems("sorrow_leggings",
            new ModArmorItem(ModArmorMaterials.SORROW, ArmorItem.Type.LEGGINGS,
                    new Item.Settings().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(false)).fireproof().maxCount(1)));

    public static final Item SORROW_BOOTS = registeredItems("sorrow_boots",
            new ModArmorItem(ModArmorMaterials.SORROW, ArmorItem.Type.BOOTS,
                    new Item.Settings().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(false)).fireproof().maxCount(1)));

    public static final Item HAT = registeredItems("hat",
            new HatItem(HatItem.Type.HAT, new Item.Settings().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(false)).maxCount(1)));

    public static final Item HYPERION = registeredItems("hyperion", new Hyperion(ModToolMaterials.HYPERION, new Item.Settings()
            .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.HYPERION, 14, -2.4F))
            .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(false)).fireproof()));

    //    这里的ModFoodComponentsItem是我自己写的一个类，继承了Item类，重写了getMaxUseTime方法
    public static void addItemtoIngredients(FabricItemGroupEntries fabricItemGroupEntries){
        //创建一个方法，参数是当前指定的物品栏栏目里面物品集合，这取决于我们在下面注册的物品栏栏目
        fabricItemGroupEntries.add(ICE_SPRAY_GEMSTONE);
        fabricItemGroupEntries.add(RAW_ICE_SPRAY_GEMSTONE);
        fabricItemGroupEntries.add(SORROW);
    }

    public static void addItemtoNatural(FabricItemGroupEntries fabricItemGroupEntries){
        //创建一个方法，参数是当前指定的物品栏栏目里面物品集合，这取决于我们在下面注册的物品栏栏目
        fabricItemGroupEntries.add(ModBlocks.ICE_SPRAY_ORE);
    }

    public static void addItemtoCombat(FabricItemGroupEntries fabricItemGroupEntries){
        //创建一个方法，参数是当前指定的物品栏栏目里面物品集合，这取决于我们在下面注册的物品栏栏目
        fabricItemGroupEntries.add(ICE_SPRAY_WAND);
        fabricItemGroupEntries.add(SORROW_HELMET);
        fabricItemGroupEntries.add(SORROW_CHESTPLATE);
        fabricItemGroupEntries.add(SORROW_LEGGINGS);
        fabricItemGroupEntries.add(SORROW_BOOTS);
    }

    public static void addItemtoBuildingBlocks(FabricItemGroupEntries fabricItemGroupEntries){
        //创建一个方法，参数是当前指定的物品栏栏目里面物品集合，这取决于我们在下面注册的物品栏栏目
        fabricItemGroupEntries.add(ModBlocks.ICE_SPRAY_BLOCK);
    }

    public static void addItemtoFoodAndDrink(FabricItemGroupEntries fabricItemGroupEntries){
        //创建一个方法，参数是当前指定的物品栏栏目里面物品集合，这取决于我们在下面注册的物品栏栏目
        fabricItemGroupEntries.add(ICE_ESSENCE);
    }

    public static void addItemtoTools(FabricItemGroupEntries fabricItemGroupEntries){
        //创建一个方法，参数是当前指定的物品栏栏目里面物品集合，这取决于我们在下面注册的物品栏栏目
        fabricItemGroupEntries.add(PROSPECTOR);
        fabricItemGroupEntries.add(BINGONIMBUS_2000);
    }

    public static void registerModItems(){
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemtoIngredients);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(ModItems::addItemtoNatural);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemtoCombat);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(ModItems::addItemtoBuildingBlocks);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemtoFoodAndDrink);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addItemtoTools);
        //在 ItemGroupEvents 里，监听 ‘修改 X 物品栏条目’ 这个事件，并在事件发生时执行 addItemtoX 这个方法
        TutorialMod.LOGGER.info("Registering Items");//无意义的代码，方便主程序内调用加载
    }
}
