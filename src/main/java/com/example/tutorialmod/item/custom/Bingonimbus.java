package com.example.tutorialmod.item.custom;

import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;

import java.util.List;

public class Bingonimbus extends PickaxeItem {

    public Bingonimbus(ToolMaterial material, Settings settings) {
        super(material, settings);
    }

    public static final String Tooltip = "item.tutorialmod.pickonimbus.tooltip";
    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        tooltip.add(Text.translatable(Tooltip));
    }
}

