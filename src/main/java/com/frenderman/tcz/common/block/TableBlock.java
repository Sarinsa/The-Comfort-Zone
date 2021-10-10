package com.frenderman.tcz.common.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.IStringSerializable;
import net.minecraftforge.common.ToolType;

public class TableBlock extends Block {

    public static final EnumProperty<TableType> TABLE_TYPE = EnumProperty.create("table_type", TableType.class);

    public TableBlock() {
        super(AbstractBlock.Properties.of(Material.WOOD)
                .sound(SoundType.WOOD)
                .strength(2.0F, 3.0F)
                .noOcclusion()
                .harvestTool(ToolType.AXE));

        this.registerDefaultState(this.stateDefinition.any().setValue(TABLE_TYPE, TableType.SINGLE));
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> stateBuilder) {
        stateBuilder.add(TABLE_TYPE);
    }

    public enum TableType implements IStringSerializable {
        SINGLE("single"),
        LEFT("left"),
        RIGHT("right"),
        BOTTOM_LEFT("bottom_left"),
        BOTTOM_MIDDLE("bottom_middle"),
        BOTTOM_RIGHT("bottom_right"),
        MIDDLE_LEFT("middle_left"),
        MIDDLE_MIDDLE("middle_middle"),
        MIDDLE_RIGHT("middle_right"),
        TOP_LEFT("top_left"),
        TOP_MIDDLE("top_middle"),
        TOP_RIGHT("top_right");


        TableType(String name) {
            this.name = name;
        }
        private final String name;

        @Override
        public String getSerializedName() {
            return this.name;
        }
    }
}
