package com.example.tutorialmod.block;

import com.example.tutorialmod.TutorialMod;
import com.example.tutorialmod.block.custom.BoxBlock;
import com.example.tutorialmod.block.custom.PolishingMachine;
import com.example.tutorialmod.block.entity.ModBlockEntities;
import com.example.tutorialmod.sound.ModSoundEvents;
import com.example.tutorialmod.world.tree.ModTreeGenerator;
import com.terraformersmc.terraform.sign.api.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallSignBlock;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block ICE_SPRAY_ORE = register("ice_spray_ore", new Block(AbstractBlock.Settings.create()
            .instrument(NoteBlockInstrument.BASS)
            .requiresTool()
            .strength(4.5f, 6.0f)));
    public static final Block ICE_SPRAY_BLOCK = register("ice_spray_block", new Block(AbstractBlock.Settings.create()
            .instrument(NoteBlockInstrument.BASEDRUM)
            .requiresTool()
            .strength(3.0f, 3.0f)
            .sounds(ModSoundEvents.GEMSTONE_BLOCK)));

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

    public static final Block POLISHING_MACHINE = register("polishing_machine",
            new PolishingMachine(AbstractBlock.Settings.create().mapColor(MapColor.STONE_GRAY).instrument(NoteBlockInstrument.BASS)
                    .strength(2.5F).sounds(BlockSoundGroup.STONE)));

    public static final Block MENRIL_LOG = register("menril_log", new PillarBlock(AbstractBlock.Settings.copy(Blocks.CHERRY_LOG)));

    public static final Block MENRIL_PLANKS = register("menril_planks", new Block(AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS)));

    public static final Block STRIPPED_MENRIL_LOG = register("stripped_menril_log", new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_CHERRY_LOG)));

    public static final Block MENRIL_LEAVES = register("menril_leaves", new LeavesBlock(AbstractBlock.Settings.copy(Blocks.CHERRY_LEAVES)));

    public static final Block MENRIL_SAPLING = register("menril_sapling", new SaplingBlock(ModTreeGenerator.MENRIL, AbstractBlock.Settings.copy(Blocks.CHERRY_SAPLING)));

    public static final Block BOX = register("box", new BoxBlock(AbstractBlock.Settings.create().mapColor(MapColor.OAK_TAN).instrument(NoteBlockInstrument.BASS).strength(2.5F).sounds(BlockSoundGroup.METAL).nonOpaque(), () -> ModBlockEntities.BOX));

    public static final Identifier MENRIL_SIGN_TEXTURE = Identifier.of(TutorialMod.MOD_ID, "entity/signs/menril");

    public static final Identifier MENRIL_HANGING_SIGH_TEXTURE = Identifier.of(TutorialMod.MOD_ID, "entity/signs/hanging/menril");

    public static final Identifier MENRIL_HANGING_SIGN_GUI = Identifier.of(TutorialMod.MOD_ID, "textures/gui/hanging_signs/menril_hanging_sign");

    public static final Block MENRIL_SIGN = Registry.register(Registries.BLOCK, Identifier.of(TutorialMod.MOD_ID, "menril_sign"),
            new TerraformSignBlock(MENRIL_SIGN_TEXTURE, AbstractBlock.Settings.copy(Blocks.CHERRY_SIGN)));

    public static final Block MENRIL_HANGING_SIGN = Registry.register(Registries.BLOCK, Identifier.of(TutorialMod.MOD_ID, "menril_hanging_sign"),
            new TerraformHangingSignBlock(MENRIL_HANGING_SIGH_TEXTURE, MENRIL_HANGING_SIGN_GUI, AbstractBlock.Settings.copy(Blocks.CHERRY_HANGING_SIGN)));

    public static final Block MENRIL_WALL_SIGN = Registry.register(Registries.BLOCK, Identifier.of(TutorialMod.MOD_ID, "menril_wall_sign"),
            new TerraformWallSignBlock(MENRIL_SIGN_TEXTURE, AbstractBlock.Settings.copy(Blocks.CHERRY_WALL_SIGN)));

    public static final Block MENRIL_WALL_HANGING_SIGN = Registry.register(Registries.BLOCK, Identifier.of(TutorialMod.MOD_ID, "menril_wall_hanging_sign"),
            new TerraformWallHangingSignBlock(MENRIL_HANGING_SIGH_TEXTURE, MENRIL_HANGING_SIGN_GUI, AbstractBlock.Settings.copy(Blocks.CHERRY_WALL_HANGING_SIGN)));

    public static final Block IRIS = register("iris", new FlowerBlock(StatusEffects.NIGHT_VISION, 0.4F, AbstractBlock.Settings.copy(Blocks.DANDELION).mapColor(MapColor.DARK_DULL_PINK)));

    public static final Block POTTED_IRIS = Registry.register(Registries.BLOCK, Identifier.of(TutorialMod.MOD_ID, "potted_iris"),
            new FlowerPotBlock(IRIS, AbstractBlock.Settings.create().breakInstantly().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
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

    public static void registerModBlocks() {
        TutorialMod.LOGGER.info("Registering Blocks");
    }
}
