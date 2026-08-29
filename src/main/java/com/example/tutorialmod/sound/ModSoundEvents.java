package com.example.tutorialmod.sound;

import com.example.tutorialmod.TutorialMod;
import net.minecraft.client.sound.Sound;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSoundEvents {

    public static final SoundEvent PROSPECTOR_FOUND_ORE = register("prospector_found_ore");

    public static final SoundEvent GEMSTONE_BLOCK_BREAK = register("gemstone_block_break");

    public static final SoundEvent GEMSTONE_BLOCK_PLACE = register("gemstone_block_place");

    public static final SoundEvent GEMSTONE_BLOCK_HIT = register("gemstone_block_hit");

    public static final SoundEvent GEMSTONE_BLOCK_STEP = register("gemstone_block_step");

    public static final SoundEvent GEMSTONE_BLOCK_FALL = register("gemstone_block_fall");

    public static final SoundEvent ICE_SPRAY = register("ice_spray");

    public static final SoundEvent TELEPORT = register("teleport");

    public static final SoundEvent EXPLODE = register("explode");

    public static final RegistryEntry.Reference<SoundEvent> MUSIC_DISC_LOVE_2000 = registerReference("music_disc_love_2000");

    public static final BlockSoundGroup GEMSTONE_BLOCK = new BlockSoundGroup(1.0F, 1.0F,
            GEMSTONE_BLOCK_BREAK,
            GEMSTONE_BLOCK_STEP,
            GEMSTONE_BLOCK_PLACE,
            GEMSTONE_BLOCK_HIT,
            GEMSTONE_BLOCK_FALL
    );

    private static SoundEvent register(String id){
        Identifier identifier = Identifier.of(TutorialMod.MOD_ID, id);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }

    private static RegistryEntry.Reference<SoundEvent> registerReference(String id){
        Identifier identifier = Identifier.of(TutorialMod.MOD_ID, id);
        return Registry.registerReference(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }
    public static void registerModSoundEvents(){

    }
}
