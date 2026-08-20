package com.example.tutorialmod.datagen;

import com.example.tutorialmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagsProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)//可锻造盔甲
                .add(ModItems.SORROW_HELMET)
                .add(ModItems.SORROW_CHESTPLATE)
                .add(ModItems.SORROW_LEGGINGS)
                .add(ModItems.SORROW_BOOTS);
    }
}
