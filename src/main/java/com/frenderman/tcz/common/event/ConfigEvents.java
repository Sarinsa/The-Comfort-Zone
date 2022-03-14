package com.frenderman.tcz.common.event;

import com.frenderman.tcz.common.item.PillowBlockItem;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.config.ModConfigEvent;

public class ConfigEvents {

    @SubscribeEvent
    public void onConfigReload(ModConfigEvent.Reloading event) {
        final ModConfig config = event.getConfig();

        if (config.getType() == ModConfig.Type.COMMON) {
            refreshReferences();
        }
    }

    private static void refreshReferences() {
        PillowBlockItem.refreshAttributeMod();
    }
}
