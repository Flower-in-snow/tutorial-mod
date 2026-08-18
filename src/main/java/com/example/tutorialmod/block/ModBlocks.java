package com.example.tutorialmod.block;

import com.example.tutorialmod.TutorialMod;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block ICE_SPRAY_ORE = register("ice_spray_ore", new Block(AbstractBlock.Settings.create().instrument(NoteBlockInstrument.BASS).requiresTool().strength(4.5f, 6.0f)));
    public static final Block ICE_SPRAY_BLOCK = register("ice_spray_block", new Block(AbstractBlock.Settings.create().instrument(NoteBlockInstrument.BASEDRUM).requiresTool().strength(3.0f, 3.0f)));

    public static final Block ICE_SPRAY_STAIRS = register("ice_spray_stairs",
            new StairsBlock(ICE_SPRAY_BLOCK.getDefaultState(), AbstractBlock.Settings.copy(ICE_SPRAY_BLOCK)));

    public static final Block ICE_SPRAY_SLAB = register("ice_spray_slab",
            new SlabBlock(AbstractBlock.Settings.copy(ICE_SPRAY_BLOCK)));

    public static final Block ICE_SPRAY_BUTTON = register("ice_spray_button",
            new ButtonBlock(BlockSetType.OAK, 10, AbstractBlock.Settings.copy(ICE_SPRAY_BLOCK)));

    public static final Block ICE_SPRAY_PRESSURE_PLATE = register("ice_spray_pressure_plate",
            new PressurePlateBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(ICE_SPRAY_BLOCK)));

    public static final Block ICE_SPRAY_FENCE = register("ice_spray_fence",
            new FenceBlock(AbstractBlock.Settings.copy(ICE_SPRAY_BLOCK)));

    public static final Block ICE_SPRAY_FENCE_GATE = register("ice_spray_fence_gate",
            new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.copy(ICE_SPRAY_BLOCK)));

    public static final Block ICE_SPRAY_WALL = register("ice_spray_wall",
            new WallBlock(AbstractBlock.Settings.copy(ICE_SPRAY_BLOCK)));

    public static final Block ICE_SPRAY_DOOR = register("ice_spray_door",
            new DoorBlock(BlockSetType.STONE, AbstractBlock.Settings.copy(ICE_SPRAY_BLOCK).nonOpaque()));

    public static final Block ICE_SPRAY_TRAPDOOR = register("ice_spray_trapdoor",
            new TrapdoorBlock(BlockSetType.IRON, AbstractBlock.Settings.copy(ICE_SPRAY_BLOCK).nonOpaque()));

    //调用方法注册
    //下方是注册的两个方法
    public static void registeredBlockItems(String id, Block block){
        Item item = Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, id), new BlockItem(block, new Item.Settings()));//注册成物品的方法
        if (item instanceof BlockItem) {
            ((BlockItem)item).appendBlocks(Item.BLOCK_ITEMS, item);
        }
    }

    public static Block register(String id, Block block) {
        registeredBlockItems(id, block);//注册成物品
        return Registry.register(Registries.BLOCK, Identifier.of(TutorialMod.MOD_ID, id), block);//注册成方块
    }

    public static void registeredModBlocks() {
        TutorialMod.LOGGER.info("Registering Blocks");
    }
}
