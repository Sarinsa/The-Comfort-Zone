package com.frenderman.tcz.common.tag;

import com.frenderman.tcz.common.core.TheComfortZone;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;

public class TCZItemTags {

    public static final Tag.Named<Item> PILLOWS = modTag("pillows");
    public static final Tag.Named<Item> STOOLS = modTag("stools");

    private static Tag.Named<Item> modTag(String name) {
        return ItemTags.bind(TheComfortZone.resourceLoc(name).toString());
    }

    public static void init() {}
}

