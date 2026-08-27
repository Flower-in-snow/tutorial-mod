package com.example.tutorialmod.villager;

import com.example.tutorialmod.TutorialMod;
import com.google.common.collect.ImmutableSet;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;
import org.jetbrains.annotations.Nullable;

public class ModCustomVillagers {
    public static final VillagerProfession MAGICIAN = register("magician", ModPointOfInterestTypes.MAGICIAN, SoundEvents.ENTITY_VILLAGER_WORK_LIBRARIAN);

    private static VillagerProfession register(String id, RegistryKey<PointOfInterestType> heldWorkstation, @Nullable SoundEvent workSound){
        return Registry.register(Registries.VILLAGER_PROFESSION, Identifier.of(TutorialMod.MOD_ID, id),
                new VillagerProfession(id, entry -> entry.matchesKey(heldWorkstation),
                        entry -> entry.matchesKey(heldWorkstation), ImmutableSet.of(), ImmutableSet.of(), workSound));
    }

    public static void  registerCustomVillagers(){

    }
}
