package com.example.tutorialmod.block.entity;

import com.example.tutorialmod.data.PolishingMachineData;
import com.example.tutorialmod.item.ModItems;
import com.example.tutorialmod.screen.PolishingMachineScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class PolishingMachineBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory<PolishingMachineData>, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(2, ItemStack.EMPTY);
    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT = 1;
    protected final PropertyDelegate propertyDelegate;//用于同步数据
    private int progress = 0;
    private int maxProgress = 72;

    public PolishingMachineBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.POLISHING_MACHINE, pos, state);
        this.propertyDelegate = new PropertyDelegate() {//匿名内部类

            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> PolishingMachineBlockEntity.this.progress;//这里的this是外部的PolishingMachineBlockEntity创建的对象，不能直接this是因为如果这样就代表是PropertyDelegate的实例了
                    case 1 -> PolishingMachineBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> PolishingMachineBlockEntity.this.progress = value;
                    case 1 -> PolishingMachineBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int size() {
                return 2;
            }
        };
    }

    @Override
    public PolishingMachineData getScreenOpeningData(ServerPlayerEntity player) {
        return new PolishingMachineData(pos);
        //这是客户端渲染的
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("container.tutorialmod.polishing_machine");
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new PolishingMachineScreenHandler(syncId, playerInventory, this.propertyDelegate, this);
        //这是给服务器看的
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        Inventories.writeNbt(nbt, this.inventory, false, registryLookup);
        nbt.putInt("polishing_machine", progress);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        Inventories.readNbt(nbt, this.inventory, registryLookup);
        progress = nbt.getInt("polishing_machine");
    }

    @Override
    public int getMaxCountPerStack() {
        return 64;
    }

    public void tick(World world, BlockPos pos, BlockState state){
        if (world.isClient()) {
            return;
        }
        if (!world.isRaining()) {
            resetProgress();
            return;
        }
        if (isOutputSlotAvailable()) {
            if (hasRecipe()){
                increaseProgress();
                markDirty(world, pos, state);
                if (finishedCrafting()){
                    craftItem();
                    resetProgress();
                }
            }
            else {
                resetProgress();
            }
        }
        else {
            resetProgress();
            markDirty(world, pos, state);
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private void craftItem() {
        ItemStack itemStack = new ItemStack(ModItems.ICE_ESSENCE);
        this.setStack(OUTPUT_SLOT, new ItemStack(ModItems.ICE_ESSENCE, getStack(OUTPUT_SLOT).getCount() + itemStack.getCount()));
        this.removeStack(INPUT_SLOT, 1);
    }

    private boolean finishedCrafting() {
        return this.progress >= this.maxProgress;
    }

    private void increaseProgress() {
        this.progress++;
    }

    private boolean hasRecipe() {
        ItemStack itemStack = new ItemStack((ModItems.ICE_ESSENCE));
        boolean hasInput = this.getStack(INPUT_SLOT).getItem() == Items.ICE;
        return hasInput && canInsertAmountIntoOutputSlot(itemStack) && canInsertItemIntoOutputSlot(itemStack);
    }

    private boolean canInsertItemIntoOutputSlot(ItemStack itemStack) {
        return this.getStack(OUTPUT_SLOT).isEmpty() || this.getStack(OUTPUT_SLOT).getItem() == itemStack.getItem();
    }

    private boolean canInsertAmountIntoOutputSlot(ItemStack itemStack) {
        return this.getStack(OUTPUT_SLOT).getCount() +itemStack.getCount() <= this.getMaxCountPerStack();
    }

    private boolean isOutputSlotAvailable() {
        return this.getStack(OUTPUT_SLOT).isEmpty() || this.getStack(OUTPUT_SLOT).getCount() < this.getMaxCountPerStack();
    }
}
