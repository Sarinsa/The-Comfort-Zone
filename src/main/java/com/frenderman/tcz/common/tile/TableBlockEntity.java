package com.frenderman.tcz.common.tile;

import com.frenderman.tcz.common.core.register.TCZBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;


public class TableBlockEntity extends BlockEntity {

    /** The ItemStack the table currently holds **/
    private ItemStack stack = ItemStack.EMPTY;

    public TableBlockEntity(BlockPos pos, BlockState state) {
        super(TCZBlockEntities.TABLE.get(), pos, state);
    }


    public static void tick(Level level, BlockPos pos, BlockState state, TableBlockEntity tableBlockEntity) {

    }

    public ItemStack getStack() {
        return this.stack;
    }

    public void setStack(ItemStack itemStack) {
        this.stack = itemStack;
    }

    @Override
    public void saveAdditional(CompoundTag compoundNBT) {
        super.saveAdditional(compoundNBT);

        CompoundTag tableStack = new CompoundTag();
        this.stack.save(tableStack);
        compoundNBT.put("TableStack", tableStack);
    }

    @Override
    public void load(CompoundTag compoundTag) {
        super.load(compoundTag);

        this.stack = ItemStack.of(compoundTag.getCompound("TableStack"));
    }
}
