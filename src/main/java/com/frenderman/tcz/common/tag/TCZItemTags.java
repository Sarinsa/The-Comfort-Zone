package com.frenderman.tcz.common.tag;

import com.frenderman.tcz.common.core.TheComfortZone;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;

public class TCZItemTags {

    public static final ITag.INamedTag<Item> PILLOWS = modTag("pillows");
    public static final ITag.INamedTag<Item> STOOLS = modTag("stools");

    private static ITag.INamedTag<Item> modTag(String name) {
        return ItemTags.bind(TheComfortZone.resourceLoc(name).toString());
    }

    public static void init() {}
}

