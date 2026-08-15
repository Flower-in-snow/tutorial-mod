package com.example.tutorialmod.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ModFoodComponentsItem extends Item {

    public ModFoodComponentsItem(Settings settings) {
        super(settings);
    }

    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user){
        int ComsumeTime = 1;
        return ComsumeTime;
    }
    //上面是一次更改固定字段值的尝试
    //我写的ModFoodComponentsItem类继承(extends)了Item类，因为我不处理Item类里需要的其他参数，所以我传回去(super)我们不需要的settings交给Item处理
    //之后我就可以重写(@0verride)Item里的getMaxUseTime方法，把我手动设置的时间覆盖要读取的FoodComponent.Builder()中的时间
    public static final FoodComponent ICE_ESSENCE = new FoodComponent.Builder()
            .nutrition(4)
            .saturationModifier(2.5f)
            //saturationModifier 默认建立在‘外部已经用 new 创建了一个 FoodComponent.Builder 对象’的基础上。
            // 这个对象没有在代码里写出来，而是通过调用时的点号（.）悄悄传了进来，并在方法内部被命名为 this。
            // 我通过 this 来操作这个‘没写出来’的对象，最后再把它 return 出去。这样就可以继续用点号（.）来调用下一个方法了。
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200, 2), 1.0f)
            .alwaysEdible()
            .build();
}
