package com.example.tutorialmod.mixin;

import com.example.tutorialmod.TutorialMod;
import com.example.tutorialmod.item.ModItems;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemRenderer.class)
public class ItemRendererMixin {
    @Unique
    private static final ModelIdentifier PLATE_3D = ModelIdentifier.ofInventoryVariant(Identifier.of(TutorialMod.MOD_ID, "plate_3d"));

    @ModifyVariable(method = "renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformationMode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/client/render/model/BakedModel;)V", at = @At("HEAD"), argsOnly = true)
    public BakedModel usePlateModel(BakedModel model,//创建这个方法是硬性要求，第一个参数是要修改的参数，后面接收原数据来判断条件的
                                    ItemStack stack,//返回类型是BakedModel，后面传回原方法体进行渲染
                                    ModelTransformationMode renderMode,
                                    boolean leftHanded,
                                    MatrixStack matrices,
                                    VertexConsumerProvider vertexConsumers,
                                    int light,
                                    int overlay){
        if (!stack.isEmpty()){
            boolean bl = renderMode == ModelTransformationMode.GUI || renderMode == ModelTransformationMode.GROUND || renderMode == ModelTransformationMode.FIXED;
            //bl=true时替换成PLATE_3D模型，=false时返回model
            if (!bl){
                if (stack.isOf(ModItems.PLATE)){
                    return ((ItemRendererAccessor) this) // 【转型】把当前的 this（即 ItemRenderer 实例）强转成我们自定义的接口类型
                            // 这一步是为了让编译器闭嘴。因为在编译时，this 是 ItemRenderer 类型，它没有 GetModels() 方法
                            // 强制转型后，编译器就允许我们调用 ItemRendererAccessor 里定义的方法了
                            .GetModels() // 【拿模型注册表】调用 Accessor 接口里的 GetModels() 方法
                            // 这个方法实际上是由 Mixin 框架在运行时自动生成的
                            // 它会直接穿透访问并返回 ItemRenderer 类里的私有字段 "models"
                            .getModelManager().getModel(
                            PLATE_3D);
                }
            }
        }
        return model;//原版调用的是2D的plate.json 3D的是在我们指定写了代码的情况下才调用
    }
}
