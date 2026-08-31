package com.example.tutorialmod.recipe;

import com.example.tutorialmod.TutorialMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipeTypes {
    public static void registerRecipeTypes() {
        Registry.register(Registries.RECIPE_SERIALIZER, Identifier.of(TutorialMod.MOD_ID, PolishingMachineRecipe.Serializer.ID)
                , PolishingMachineRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, Identifier.of(TutorialMod.MOD_ID, PolishingMachineRecipe.Type.ID)
                , PolishingMachineRecipe.Type.INSTANCE);
    }
}
