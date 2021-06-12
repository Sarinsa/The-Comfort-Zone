package com.frenderman.tcz.common.core;

import com.frenderman.tcz.common.core.register.TCZBlocks;
import com.frenderman.tcz.common.core.register.TCZItems;
import com.frenderman.tcz.common.tag.TCZBlockTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(TheComfortZone.MODID)
public class TheComfortZone {

    public static final String MODID = "thecomfortzone";
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    public TheComfortZone() {
        // Class loading
        TCZBlockTags.init();

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        eventBus.addListener(this::onCommonSetup);

        TCZBlocks.BLOCKS.register(eventBus);
        TCZItems.ITEMS.register(eventBus);
    }

    private void onCommonSetup(FMLCommonSetupEvent event) {

    }

    public static ResourceLocation resourceLoc(String path) {
        return new ResourceLocation(MODID, path);
    }
}
