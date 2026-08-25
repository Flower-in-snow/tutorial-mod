package com.example.tutorialmod.util;

import com.example.tutorialmod.item.ModItems;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;


public class ModLootTableModifiers {
    private static final Identifier VILLAGE_WEAPONSMITH = Identifier.ofVanilla("chests/village/village_weaponsmith");
    private static final Identifier CREEPER_ID = Identifier.ofVanilla("entities/creeper");

    public static void ModifyLootTable(){
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (VILLAGE_WEAPONSMITH.equals(key.getValue())){
                LootPool.Builder pool1 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .with(ItemEntry.builder(ModItems.PROSPECTOR))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));
                tableBuilder.pool(pool1);
            }

            if (CREEPER_ID.equals(key.getValue())){
                LootPool.Builder pool2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.01f))
                        .with(ItemEntry.builder(ModItems.PROSPECTOR))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));
                tableBuilder.pool(pool2);
            }
        });
    }
}
