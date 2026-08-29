package com.example.tutorialmod.item.custom;

import com.example.tutorialmod.sound.ModSoundEvents;
import com.example.tutorialmod.tags.ModBlockTags;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Prospector extends Item {

    public Prospector(Settings settings) {
        super(settings);
    }

    private static final int SEARCH_RADIUS = 2;
    public static final String KEY_PRECISE = "message.tutorialmod.prospector.keyprecise";
    public static final String KEY_ROUGH = "message.tutorialmod.prospector.keyrough";//创建翻译key方便转文字

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockPos pos = context.getBlockPos();
        PlayerEntity player = context.getPlayer();
        World world = context.getWorld();

        if (!world.isClient()) {//一般来说物品的功能在服务端运行而不是客户端
            boolean isFound = false;
            if (Screen.hasShiftDown()) {//screen类是读取键盘输入的
                //实行精确搜索
                for (int z = 0; z < pos.getY() + 64; z++) {
                    BlockPos TargetPos = pos.down(z);
                    BlockState blockState = isRightBlock(TargetPos, world);
                    if (blockState != null) {
                        String name = blockState.getBlock().getTranslationKey();
                        player.sendMessage(Text.translatable(KEY_PRECISE).append(Text.translatable(name)));
                        world.playSound(null, TargetPos, ModSoundEvents.PROSPECTOR_FOUND_ORE, SoundCategory.BLOCKS, 1.0F, 1.0F);
                        isFound = true;
                        break;
                    }
                }
            } else {
                //实行模糊搜索
                for (int z = 0; z < pos.getY() + 64; z++) {
                    for (int x = -SEARCH_RADIUS; x < SEARCH_RADIUS; x++) {
                        for (int y = -SEARCH_RADIUS; y < SEARCH_RADIUS; y++) {
                            BlockPos TargetPos = pos.down(z).north(x).east(y);
                            BlockState blockState = isRightBlock(TargetPos, world);
                            if (blockState != null) {
                                String name = blockState.getBlock().getTranslationKey();
                                player.sendMessage(Text.translatable(name).append(Text.translatable(KEY_ROUGH)));
                                world.playSound(null, TargetPos, ModSoundEvents.PROSPECTOR_FOUND_ORE, SoundCategory.BLOCKS, 1.0F, 1.0F);
                                isFound = true;
                                break;
                            }
                        }
                        if (isFound){
                            break;
                        }
                    }
                    if (isFound){
                        break;
                    }
                }
            }
            if (!isFound) {
                player.sendMessage(Text.of("Sorry"));
            }
            context.getStack().damage(1, player, EquipmentSlot.MAINHAND);
            return ActionResult.SUCCESS;
        }
        return super.useOnBlock(context);
    }

    private @Nullable BlockState isRightBlock(BlockPos targetPos, World world) {
        BlockState TargetBlockState = world.getBlockState(targetPos);
        if (TargetBlockState.isIn(ModBlockTags.PROSPECTOR_ORE_LIST)){
            return TargetBlockState;//返回BlockState方便后续获取名字
        }
        else {
            return null;//如果使用@Nullable，必须带上if判断条件
        }
    }
    //添加工具信息
    public static final String SPACE = "tooltip.tutorialmod.space";
    public static final String Tooltip = "tooltip.tutorialmod.prospector_tooltip";
    public static final String Basic_tooltip = "tooltip.tutorialmod.prospector_basictooltip";
    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        tooltip.add(Text.translatable(SPACE));
        if (Screen.hasControlDown()){
            tooltip.add(Text.translatable(Tooltip));
        }
        else {
            tooltip.add(Text.translatable(Basic_tooltip));
        }
    }
}


