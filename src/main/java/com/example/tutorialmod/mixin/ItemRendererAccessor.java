package com.example.tutorialmod.mixin;

import net.minecraft.client.render.item.ItemModels;
import net.minecraft.client.render.item.ItemRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ItemRenderer.class)
public interface ItemRendererAccessor {
    @Accessor("models")// 告诉Mixin：我要访问ItemRenderer里的私有字段 "models"
    ItemModels GetModels();//这是一个Accessor（访问器）方法，调用它会返回那个私有字段的值
}
