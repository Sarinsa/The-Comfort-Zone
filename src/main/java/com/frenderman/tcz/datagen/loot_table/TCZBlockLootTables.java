package com.frenderman.tcz.datagen.loot_table;

import net.minecraft.block.Block;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.loot.LootTable;

import java.util.HashSet;
import java.util.Set;

import static com.frenderman.tcz.common.core.register.TCZBlocks.*;

public class TCZBlockLootTables extends BlockLootTables {

    private final Set<Block> knownBlocks = new HashSet<>();

    @Override
    protected void add(Block block, LootTable.Builder table) {
        super.add(block, table);
        this.knownBlocks.add(block);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return this.knownBlocks;
    }

    @Override
    public void addTables() {
        this.dropSelf(BLACK_PILLOW.get());
        this.dropSelf(BLUE_PILLOW.get());
        this.dropSelf(BROWN_PILLOW.get());
        this.dropSelf(CYAN_PILLOW.get());
        this.dropSelf(GRAY_PILLOW.get());
        this.dropSelf(GREEN_PILLOW.get());
        this.dropSelf(LIGHT_BLUE_PILLOW.get());
        this.dropSelf(LIGHT_GRAY_PILLOW.get());
        this.dropSelf(LIME_PILLOW.get());
        this.dropSelf(MAGENTA_PILLOW.get());
        this.dropSelf(ORANGE_PILLOW.get());
        this.dropSelf(PINK_PILLOW.get());
        this.dropSelf(PURPLE_PILLOW.get());
        this.dropSelf(RED_PILLOW.get());
        this.dropSelf(WHITE_PILLOW.get());
        this.dropSelf(YELLOW_PILLOW.get());

        this.dropSelf(BLACK_OAK_STOOL.get());
        this.dropSelf(BLUE_OAK_STOOL.get());
        this.dropSelf(BROWN_OAK_STOOL.get());
        this.dropSelf(CYAN_OAK_STOOL.get());
        this.dropSelf(GRAY_OAK_STOOL.get());
        this.dropSelf(GREEN_OAK_STOOL.get());
        this.dropSelf(LIGHT_BLUE_OAK_STOOL.get());
        this.dropSelf(LIGHT_GRAY_OAK_STOOL.get());
        this.dropSelf(LIME_OAK_STOOL.get());
        this.dropSelf(MAGENTA_OAK_STOOL.get());
        this.dropSelf(ORANGE_OAK_STOOL.get());
        this.dropSelf(PINK_OAK_STOOL.get());
        this.dropSelf(PURPLE_OAK_STOOL.get());
        this.dropSelf(RED_OAK_STOOL.get());
        this.dropSelf(WHITE_OAK_STOOL.get());
        this.dropSelf(YELLOW_OAK_STOOL.get());
    }
}
