package com.example.tutorialmod.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Prospector extends Item {

    public Prospector(Settings settings) {
        super(settings);
    }

    private static final int SEARCH_RADIS = 2;

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
                    if (isRightBlock(TargetPos, world)) {
                        player.sendMessage(Text.of("Successfully Found"));
                        isFound = true;
                        break;
                    }
                }
            } else {
                //实行模糊搜索
                for (int z = 0; z < pos.getY() + 64; z++) {
                    for (int x = -SEARCH_RADIS; x < SEARCH_RADIS; x++) {
                        for (int y = -SEARCH_RADIS; y < SEARCH_RADIS; y++) {
                            BlockPos TargetPos = pos.down(z).north(x).east(y);
                            if (isRightBlock(TargetPos, world)) {
                                player.sendMessage(Text.of("is over there!"));
                                isFound = true;
                                break;
                            }
                        }
                    }
                }
            }
            if (!isFound) {
                player.sendMessage(Text.of("Sorry"));
            }
        }

        return super.useOnBlock(context);
    }
    private static final String TargetOre = "diamond";
    private boolean isRightBlock(BlockPos targetPos,World world) {
        BlockState TargetBlockState = world.getBlockState(targetPos);
        String TargetBlockName = TargetBlockState.getBlock().getTranslationKey();
        return TargetBlockName.contains(TargetOre);
    }
}


