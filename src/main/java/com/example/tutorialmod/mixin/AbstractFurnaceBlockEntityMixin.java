package com.example.tutorialmod.mixin;

import com.example.tutorialmod.item.ModItems;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.item.Item;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(AbstractFurnaceBlockEntity.class)
//执行mixin的文件
public abstract class AbstractFurnaceBlockEntityMixin {
    @Shadow
    private static volatile @Nullable Map<Item, Integer> fuelTimes;

    @Inject(method = "createFuelTimeMap", at = @At("TAIL"))
    //注入到createFuelTimeMap方法的尾部
    private static void addModFuel(CallbackInfoReturnable<Map<Item, Integer>> cir) {
        //这个形参cir是必须要的，这是inject的要求，若目标方法有返回值，就写CallbackInfoReturnable<返回值类型> cir
        //若没有，就写CallbackInfo ci
        fuelTimes.put(ModItems.FIRE_GEMSTONE, 1200);
        //这里的fueltimes不是源文件的fueltimes，这里的是个影子变量，后续注入到fueltimes里去
    }

    //还有fabric api提供的写法，本质上也是mixin


}
