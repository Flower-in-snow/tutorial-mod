package com.example.tutorialmod.recipe;

import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

import java.util.List;

public class PolishingMachineRecipe implements Recipe<SingleStackRecipeInput> {
    private final ItemStack output;
    private final List<Ingredient> recipeItems;

    public PolishingMachineRecipe(List<Ingredient> recipeItems, ItemStack output) {
        this.output = output;
        this.recipeItems = recipeItems;
    }

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.ofSize(this.recipeItems.size());
        list.addAll(this.recipeItems);
        return list;
    }

    @Override
    public boolean matches(SingleStackRecipeInput input, World world) {
        if (world.isClient()){
            return false;
        }
        return this.recipeItems.get(0).test(input.item());
    }

    @Override
    public ItemStack craft(SingleStackRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        return this.output.copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
        return this.output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<PolishingMachineRecipe>{
        public static final Type INSTANCE = new Type();
        public static final String ID = "polishing_machine";
    }
    /* ==================== 本文件知识点总结 ====================

    【final 字段与构造器】
    - final 字段没有默认值，必须在构造完成前被赋值一次，否则编译报错
    - 构造器 = new 创建对象那一刻的"装配流程"，核心任务是初始化
      （初始化 ≠ 只赋值，还包括 super(...)、校验、搭建等"让对象可用"的全部动作）
    - 本类字段全是 final → 构造后永不改变（不可变对象），matches/craft 用的
      output、recipeItems 全是构造时装进去的那一份

    【字段/方法属于类还是属于对象】
    - 属于对象：每个对象各自一份，值可以各不相同 → 用 对象.字段 访问
      如 100 个配方对象就有 100 个各自的 output
    - 属于类（static）：全游戏只有一份 → 用 类名.字段 访问，不用 new
      如 Type.INSTANCE、ModScreenHandlers.POLISHING_MACHINE_SCREEN_HANDLER
    - static 的初始化时机：类第一次被使用时（类加载），执行且仅执行一次

    【嵌套类（static class）】
    - 类里面可以再定义类；加 static 表示不依赖外部的任何对象
    - 本文件的 Type 和 Serializer 只服务于打磨机配方，就近放在类内部，
      表达"配套"关系（外部访问需全名：PolishingMachineRecipe.Type）

    【单例模式（static final INSTANCE）】
    - "配方类型/序列化器"这种分类标签，全游戏只需要一个对象
    - static final INSTANCE = new Type() 的含义：
      static  → 字段属于类，全局一个格位
      final   → 赋值一次后永不指向别的对象
      new     → 构造器全程只跑一次（类加载时）
    - 是"只有一个实例"因为全代码库只有这一处 new；
      若想彻底锁死，可补 private 构造器禁止外部 new
    - 注意：INSTANCE 字段属于类，但它"装的值"是一个对象，两者不矛盾

    【构造器与普通方法的关系】
    - 构造器：出生时装料，只跑一次
    - 普通方法：出生后被游戏反复调用（matches 判断匹配、craft 产出），
      干活用的料全部来自构造器装的那一份
    - @Override 方法是 Recipe 接口合同规定的必答题，缺一个都编译不过

    ============================================================ */

    public static class Serializer implements RecipeSerializer<PolishingMachineRecipe>{

        public static final Serializer INSTANCE = new Serializer();

        public static final String ID = "polishing_machine";

        public static final MapCodec<PolishingMachineRecipe> CODEC = RecordCodecBuilder.mapCodec(polishingMachineRecipeInstance -> polishingMachineRecipeInstance.group(
                Ingredient.DISALLOW_EMPTY_CODEC.listOf().fieldOf("ingredients").flatXmap(ingredients -> {
                    Ingredient[] ingredients1 = (Ingredient[]) ingredients.stream().filter(ingredient -> !ingredient.isEmpty()).toArray(Ingredient[]::new);
                    if (ingredients1.length == 0 ){
                        return DataResult.error(() -> "No Ingredients");
                    }
                    if (ingredients1.length > 9){
                        return DataResult.error(() -> "Too many ingredients");
                    }
                    return DataResult.success(DefaultedList.copyOf(Ingredient.empty(), ingredients1));
                }, DataResult::success).forGetter(recipe -> recipe.getIngredients()),
                (ItemStack.VALIDATED_CODEC.fieldOf("output")).forGetter(recipe -> recipe.output)).apply(polishingMachineRecipeInstance, PolishingMachineRecipe::new));

        public static final PacketCodec<RegistryByteBuf, PolishingMachineRecipe> PACKET_CODEC = PacketCodec.ofStatic(Serializer::write, Serializer::read);
        private static PolishingMachineRecipe read(RegistryByteBuf registryByteBuf) {
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(registryByteBuf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++){
                inputs.set(i, Ingredient.PACKET_CODEC.decode(registryByteBuf));
            }
            ItemStack output = ItemStack.PACKET_CODEC.decode(registryByteBuf);
            return new PolishingMachineRecipe(inputs, output);
        }

        private static void write(RegistryByteBuf registryByteBuf, PolishingMachineRecipe polishingMachineRecipe) {
            registryByteBuf.writeInt(polishingMachineRecipe.getIngredients().size());
            for (Ingredient ingredient : polishingMachineRecipe.getIngredients()){
                Ingredient.PACKET_CODEC.encode(registryByteBuf, ingredient);
            }
            ItemStack.PACKET_CODEC.encode(registryByteBuf, polishingMachineRecipe.getResult(null));
        }

        @Override
        public MapCodec<PolishingMachineRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, PolishingMachineRecipe> packetCodec() {
            return PACKET_CODEC;
        }
    }
}