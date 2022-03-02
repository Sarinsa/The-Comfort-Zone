package com.frenderman.tcz.common.tag;

import com.frenderman.tcz.common.core.TheComfortZone;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.level.block.Block;

public class TCZBlockTags {

    public static final Tag.Named<Block> SITTABLES = modTag("sittables");

    public static final Tag.Named<Block> PILLOWS = modTag("pillows");
    public static final Tag.Named<Block> STOOLS = modTag("stools");

    private static Tag.Named<Block> modTag(String name) {
        return BlockTags.bind(TheComfortZone.resourceLoc(name).toString());
    }

    public static void init() {
        TCZItemTags.init();
    }
}
