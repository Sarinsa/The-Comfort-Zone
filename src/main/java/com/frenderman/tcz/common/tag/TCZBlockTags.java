package com.frenderman.tcz.common.tag;

import com.frenderman.tcz.common.core.TheComfortZone;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class TCZBlockTags {

    public static final TagKey<Block> SITTABLES = modTag("sittables");

    public static final TagKey<Block> PILLOWS = modTag("pillows");
    //public static final Tag.Named<Block> STOOLS = modTag("stools");

    private static TagKey<Block> modTag(String name) {
        return BlockTags.create(TheComfortZone.resourceLoc(name));
    }

    public static void init() {
        TCZItemTags.init();
    }
}
