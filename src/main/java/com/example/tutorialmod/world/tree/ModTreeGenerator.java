package com.example.tutorialmod.world.tree;

import com.example.tutorialmod.TutorialMod;
import com.example.tutorialmod.world.ModConfiguredFeatures;
import net.minecraft.block.SaplingGenerator;

import java.util.Optional;

public class ModTreeGenerator {
    public static final SaplingGenerator MENRIL = new SaplingGenerator(TutorialMod.MOD_ID + ":menril_tree",
            Optional.empty(),
            Optional.of(ModConfiguredFeatures.MENRIL),
            Optional.empty()
    );


}
