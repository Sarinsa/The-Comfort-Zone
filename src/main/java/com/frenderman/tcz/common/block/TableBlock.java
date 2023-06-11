package com.frenderman.tcz.common.block;

import com.frenderman.tcz.common.core.register.TCZBlockEntities;
import com.frenderman.tcz.common.tile.TableBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;

import javax.annotation.Nullable;

public class TableBlock extends BaseEntityBlock {

    public static final EnumProperty<TableType> TABLE_TYPE = EnumProperty.create("table_type", TableType.class);

    public TableBlock() {

        super(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)
                .sound(SoundType.WOOD)
                .strength(2.0F, 3.0F)
                .noOcclusion());

        this.registerDefaultState(this.stateDefinition.any().setValue(TABLE_TYPE, TableType.SINGLE));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new TableBlockEntity(pos, state);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        return createTableTicker(level, blockEntityType, TCZBlockEntities.TABLE.get());
    }

    @Nullable
    protected static <T extends BlockEntity> BlockEntityTicker<T> createTableTicker(Level level, BlockEntityType<T> blockEntityTypeA, BlockEntityType<? extends TableBlockEntity> blockEntityTypeB) {
        return level.isClientSide ? null : createTickerHelper(blockEntityTypeA, blockEntityTypeB, TableBlockEntity::tick);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateBuilder) {
        stateBuilder.add(TABLE_TYPE);
    }

    public enum TableType implements StringRepresentable {
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
