package com.example.tutorialmod.item.custom;

import com.example.tutorialmod.item.ModArmorMaterials;
import com.google.common.collect.ImmutableMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ModArmorItem extends ArmorItem {

    public static int count = 0;
    //要用MAP来存储盔甲材料和对应的效果
    private static final Map<ArmorMaterial, List<StatusEffectInstance>> MAP = new ImmutableMap.Builder<ArmorMaterial, List<StatusEffectInstance>>()
            .put(ModArmorMaterials.SORROW.value(), Arrays.asList(
                    new StatusEffectInstance(StatusEffects.INVISIBILITY, 240, 0, false, false, true),
                    new StatusEffectInstance(StatusEffects.RESISTANCE, 240, 1, false, false, true),
                    new StatusEffectInstance(StatusEffects.REGENERATION, 240, 1, false, false, true))).build();

    public ModArmorItem(RegistryEntry<ArmorMaterial> material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        //这个方法会实时检查玩家物品栏
        if (!world.isClient() && entity instanceof PlayerEntity player && hasFullSuitOfArmor(player)) {
            playerAddEffects(player);
        }
        if (!world.isClient() && entity instanceof PlayerEntity player){
            count = getMatchingArmorCount(player);//实时检查穿戴的盔甲数量
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private int getMatchingArmorCount(PlayerEntity player) {
        int matchingCount = 0;
        for (ItemStack armorStack : player.getInventory().armor) {
            if (armorStack.getItem() instanceof ArmorItem armorItem
                    && armorItem.getMaterial().value() == this.getMaterial().value()) {
                matchingCount++;
            }
        }
        return matchingCount;
    }

    private boolean hasFullSuitOfArmor(PlayerEntity player) {
        //判断是否穿着四件装备
        ItemStack helmet = player.getInventory().getArmorStack(3);
        ItemStack chestplate = player.getInventory().getArmorStack(2);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack boots = player.getInventory().getArmorStack(0);
        return !helmet.isEmpty() && !chestplate.isEmpty() && !leggings.isEmpty() && !boots.isEmpty();
    }

    private void playerAddEffects(PlayerEntity player) {
        for (Map.Entry<ArmorMaterial, List<StatusEffectInstance>> entry : MAP.entrySet()) {
            ArmorMaterial material = entry.getKey();
            List<StatusEffectInstance> effects = entry.getValue();
            if (hasRightMaterialOfArmor(player, material)){
                executeAndAddEffects(player, effects);
            }
        }
    }

    private void executeAndAddEffects(PlayerEntity player, List<StatusEffectInstance> effects) {
        //检测玩家当前状态，并给予效果
        for (StatusEffectInstance effect : effects){
            boolean addEffect = false;
            int StandardTime = 220;
            StatusEffectInstance existingEffect = player.getStatusEffect(effect.getEffectType());
            if (existingEffect == null){
                addEffect = true;
            } else if (existingEffect.getDuration() < StandardTime) {
                addEffect = true;
            }
            if (addEffect){
                //这里每次都要创建新的药水实例，不然只有一个导致药水只会添加一次
                player.addStatusEffect(new StatusEffectInstance(effect));
            }
        }
    }

    private boolean hasRightMaterialOfArmor(PlayerEntity player, ArmorMaterial material) {
        //若穿戴的装备中包含非盔甲物品，则返回false，不然会报错(鞘翅)
        for (ItemStack stack : player.getInventory().armor){
            if (!(stack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }
        //判断装备材料
        ArmorItem helmet = (ArmorItem) player.getInventory().getArmorStack(3).getItem();
        ArmorItem chestplate = (ArmorItem) player.getInventory().getArmorStack(2).getItem();
        ArmorItem leggings = (ArmorItem) player.getInventory().getArmorStack(1).getItem();
        ArmorItem boots = (ArmorItem) player.getInventory().getArmorStack(0).getItem();
        return helmet.getMaterial().value() == material &&
                chestplate.getMaterial().value() == material &&
                leggings.getMaterial().value() == material &&
                boots.getMaterial().value() == material;
    }
    public static final String Sorrow_ArmorTip_1 = "tooltip.tutorialmod.sorrow_armor_1";
    public static final String Sorrow_ArmorTip_2 = "tooltip.tutorialmod.sorrow_armor_2";
    public static final String Sorrow_ArmorTip_3 = "tooltip.tutorialmod.sorrow_armor_3";
    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable(Prospector.SPACE));
        tooltip.add(Text.translatable(Sorrow_ArmorTip_1, count));
        tooltip.add(Text.translatable(Sorrow_ArmorTip_2));
        tooltip.add(Text.translatable(Sorrow_ArmorTip_3));
        super.appendTooltip(stack, context, tooltip, type);
    }
}