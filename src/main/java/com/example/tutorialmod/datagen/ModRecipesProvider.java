package com.example.tutorialmod.datagen;

import com.example.tutorialmod.TutorialMod;
import com.example.tutorialmod.block.ModBlocks;
import com.example.tutorialmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.CampfireCookingRecipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipesProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> RAW_ICE_SPRAY_GEMSTONE = List.of(ModBlocks.ICE_SPRAY_ORE);
    private static final List<ItemConvertible> LEATHER = List.of(Items.ROTTEN_FLESH);

    public ModRecipesProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.ICE_SPRAY_GEMSTONE,
                RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_SPRAY_BLOCK);
        //这个函数的功能是提供可逆合成。合成gemstone时，其配方属于MISC，合成block时，其配方属于BUILDING_BLOCKS

        offerSmelting(exporter, RAW_ICE_SPRAY_GEMSTONE, RecipeCategory.MISC, ModItems.RAW_ICE_SPRAY_GEMSTONE,
                0.7f, 200, "gemstone");
        offerSmelting(exporter, LEATHER, RecipeCategory.MISC, Items.LEATHER,
                0.7f, 200, "enhancedVanilla");
        //这个函数的功能是提供熔炼配方。第二个参数是烧成第四个参数的原料列表，然后配方是第三个参数

        offerBlasting(exporter, RAW_ICE_SPRAY_GEMSTONE, RecipeCategory.MISC, ModItems.RAW_ICE_SPRAY_GEMSTONE,
                0.7f, 200, "gemstone");
        //同理

        offerFoodCookingRecipe(exporter, "campfire_cooking", RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new,
                60, ModBlocks.ICE_SPRAY_ORE, ModItems.RAW_ICE_SPRAY_GEMSTONE, 0.35f);
        //这个函数的功能是提供食物配方，第二第三个参数是厨具和方式，第六个是原材料，第七个是成品

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ICE_SPRAY_WAND, 1)
                .input('B', ModBlocks.ICE_SPRAY_BLOCK)
                .input('G', ModItems.ICE_SPRAY_GEMSTONE)
                .input('S', Items.STICK)
                .pattern(" B ")
                .pattern("GSG")
                .pattern(" S ")
                .criterion("has_item", RecipeProvider.conditionsFromItem(ModItems.ICE_SPRAY_WAND))
                .offerTo(exporter, Identifier.of(TutorialMod.MOD_ID, "ice_spray_wand"));


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ICE_SPRAY_GEMSTONE, 1)
                .input('R', ModItems.RAW_ICE_SPRAY_GEMSTONE)
                .pattern(" R ")
                .pattern("RRR")
                .pattern(" R ")
                .criterion("has_item", RecipeProvider.conditionsFromItem(ModItems.RAW_ICE_SPRAY_GEMSTONE))
                .offerTo(exporter, Identifier.of(TutorialMod.MOD_ID, "raw_gemstone_to_ice_spray_gemstone"));
        //提供有序合成，倒数第二行是匹配成就系统，合成成功后解锁快速配方，最后给配方路径归类

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ICE_SPRAY_ORE, 1)
                .input(Items.STONE)
                .input(ModItems.RAW_ICE_SPRAY_GEMSTONE)
                .criterion("has_item", RecipeProvider.conditionsFromItem(ModItems.RAW_ICE_SPRAY_GEMSTONE))
                .offerTo(exporter, Identifier.of(TutorialMod.MOD_ID, "raw_gemstone_to_ore"));
        //提供无序合成，当有RAW_ICE_SPRAY_GEMSTONE时解锁快速配方，其他类似


    }
}
