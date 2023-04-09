package com.frenderman.tcz.common.tag;

import com.frenderman.tcz.common.core.TheComfortZone;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class TCZItemTags {

    public static final TagKey<Item> PILLOWS = modTag("pillows");
    //public static final Tag.Named<Item> STOOLS = modTag("stools");

    private static TagKey<Item> modTag(String name) {
        return ItemTags.create(TheComfortZone.resourceLoc(name));
    }

    public static void init() {}
}

