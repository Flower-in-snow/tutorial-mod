package com.example.tutorialmod.block.custom;

import com.example.tutorialmod.block.entity.BoxBlockEntity;
import com.example.tutorialmod.block.entity.ModBlockEntities;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class BoxBlock extends AbstractChestBlock<BoxBlockEntity> implements Waterloggable {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public static final MapCodec<BoxBlock> CODEC = createCodec(settings -> new BoxBlock(settings, () -> ModBlockEntities.BOX));

    public BoxBlock(Settings settings, Supplier<BlockEntityType<? extends BoxBlockEntity>> blockEntityTypeSupplier) {
        super(settings, blockEntityTypeSupplier);
        this.getDefaultState().with(FACING, Direction.NORTH);
    }

    @Override
    protected MapCodec<? extends AbstractChestBlock<BoxBlockEntity>> getCodec() {
        return CODEC;
    }

    @Override
    public DoubleBlockProperties.PropertySource<? extends ChestBlockEntity> getBlockEntitySource(BlockState state, World world, BlockPos pos, boolean ignoreBlocked) {
        return null;
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new BoxBlockEntity(pos, state);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (world.isClient) {
            return ActionResult.SUCCESS;
        }

        NamedScreenHandlerFactory namedScreenHandlerFactory = this.createScreenHandlerFactory(state, world, pos);
        if (namedScreenHandlerFactory != null) {
            player.openHandledScreen(namedScreenHandlerFactory);
        }

        return ActionResult.CONSUME;
    }

    @Override
    protected BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    protected BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
