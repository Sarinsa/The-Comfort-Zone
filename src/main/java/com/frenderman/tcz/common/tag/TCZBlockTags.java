package com.frenderman.tcz.common.tag;

import com.frenderman.tcz.common.core.TheComfortZone;
import net.minecraft.block.Block;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;

public class TCZBlockTags {

    public static final ITag.INamedTag<Block> SITTABLES = modTag("sittables");

    public static final ITag.INamedTag<Block> PILLOWS = modTag("pillows");
    public static final ITag.INamedTag<Block> STOOLS = modTag("stools");

    private static ITag.INamedTag<Block> modTag(String name) {
        return BlockTags.bind(TheComfortZone.resourceLoc(name).toString());
    }

    public static void init() {
        TCZItemTags.init();
    }
}
