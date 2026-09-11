package com.example.tutorialmod.tags;

import com.example.tutorialmod.TutorialMod;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModItemTags {

    public static final TagKey<Item> MENRIL = of("menril");

    private static TagKey<Item> of(String id) {
        return TagKey.of(RegistryKeys.ITEM, Identifier.of(TutorialMod.MOD_ID, id));
    }
}
