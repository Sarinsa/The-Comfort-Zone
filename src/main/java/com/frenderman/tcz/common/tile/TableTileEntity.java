package com.frenderman.tcz.common.tile;

import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TableTileEntity extends TileEntity implements ITickableTileEntity {

    /** The ItemStack the table currently holds **/
    private ItemStack stack = ItemStack.EMPTY;

    public TableTileEntity() {
        super(/*TCZTileEntities.TABLE.get() */ null);
    }

    @Override
    public void tick() {

    }

    public ItemStack getStack() {
        return this.stack;
    }

    public void setStack(ItemStack itemStack) {
        this.stack = itemStack;
    }

    @Override
    public CompoundNBT save(CompoundNBT compoundNBT) {
        super.save(compoundNBT);

        CompoundNBT tableStack = new CompoundNBT();
        this.stack.save(tableStack);
        compoundNBT.put("TableStack", tableStack);

        return compoundNBT;
    }

    @Override
    public void load(BlockState state, CompoundNBT compoundNBT) {
        super.load(state, compoundNBT);

        this.stack = ItemStack.of(compoundNBT.getCompound("TableStack"));
    }
}
