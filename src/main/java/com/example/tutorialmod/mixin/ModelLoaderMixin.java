package com.example.tutorialmod.mixin;

import com.example.tutorialmod.TutorialMod;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.render.model.BlockStatesLoader;
import net.minecraft.client.render.model.ModelLoader;
import net.minecraft.client.render.model.json.JsonUnbakedModel;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.data.client.Model;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Map;

@Mixin(ModelLoader.class)
public abstract class ModelLoaderMixin {
    @Unique
    private static final ModelIdentifier PLATE_IN_HAND = ModelIdentifier.ofInventoryVariant(Identifier.of(TutorialMod.MOD_ID, "plate_3d"));

    @Shadow
    protected abstract void loadItemModel(ModelIdentifier id);

    @Inject(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/model/ModelLoader;loadItemModel(Lnet/minecraft/client/util/ModelIdentifier;)V", ordinal = 1, shift = At.Shift.AFTER))
    //“当游戏启动加载模型，执行到 ModelLoader（模型加载器）的构造函数时，在它第二次调用 loadItemModel 方法之后，立刻执行我自定义的代码。”
    public void addPlate(BlockColors blockColors, Profiler profiler, Map jsonUnbakedModels, Map blockStates, CallbackInfo ci){
        this.loadItemModel(PLATE_IN_HAND);
    }
}
