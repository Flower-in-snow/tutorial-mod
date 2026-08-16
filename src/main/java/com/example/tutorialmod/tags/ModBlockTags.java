package com.example.tutorialmod.tags;

import com.example.tutorialmod.TutorialMod;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModBlockTags {
    public static final TagKey<Block> PROSPECTOR_ORE_LIST = of("prospector_ore_list");

    private static TagKey<Block> of(String id) {
        return TagKey.of(RegistryKeys.BLOCK, Identifier.of(TutorialMod.MOD_ID, id));
    }

    public static void registeredModBlockTags(){
        TutorialMod.LOGGER.info("Registered ModBlockTags!");
    }
}
