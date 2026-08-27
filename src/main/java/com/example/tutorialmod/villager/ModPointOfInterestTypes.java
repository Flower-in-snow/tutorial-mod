package com.example.tutorialmod.villager;

import com.example.tutorialmod.TutorialMod;
import com.example.tutorialmod.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.poi.PointOfInterestType;

public class ModPointOfInterestTypes {
    public static final RegistryKey<PointOfInterestType> MAGICIAN = of("magician");

    public static final PointOfInterestType MAGICIAN_POI = registerPointOfInterestType("magician", ModBlocks.ICE_SPRAY_BLOCK);

    private static RegistryKey<PointOfInterestType> of(String id) {
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, Identifier.of(TutorialMod.MOD_ID, id));
    }

    private static PointOfInterestType registerPointOfInterestType(String id, Block block) {
        return PointOfInterestHelper.register(Identifier.of(TutorialMod.MOD_ID, id), 1, 1, block);
    }
}
