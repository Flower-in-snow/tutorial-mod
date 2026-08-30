package com.example.tutorialmod.block.entity;

import com.example.tutorialmod.TutorialMod;
import com.example.tutorialmod.block.ModBlocks;
import com.mojang.datafixers.types.Type;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.datafixer.TypeReferences;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

public class ModBlockEntities {
    public static final BlockEntityType<BoxBlockEntity> BOX = create("box", BlockEntityType.Builder.create(BoxBlockEntity::new, ModBlocks.BOX));

    public static final BlockEntityType<PolishingMachineBlockEntity> POLISHING_MACHINE = create("polishing_machine", BlockEntityType.Builder.create(PolishingMachineBlockEntity::new, ModBlocks.POLISHING_MACHINE));
    private static <T extends BlockEntity> BlockEntityType<T> create(String id, BlockEntityType.Builder<T> builder) {
        Type<?> type = Util.getChoiceType(TypeReferences.BLOCK_ENTITY, id);
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(TutorialMod.MOD_ID, id), builder.build(type));
    }

    public static void registerModBlockEntities() {
    }
}
