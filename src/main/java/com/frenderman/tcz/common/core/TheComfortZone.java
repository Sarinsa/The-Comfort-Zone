package com.frenderman.tcz.common.core;

import com.frenderman.tcz.common.core.config.TCZCommonConfig;
import com.frenderman.tcz.common.core.register.*;
import com.frenderman.tcz.common.event.ConfigEvents;
import com.frenderman.tcz.common.event.EntityEvents;
import com.frenderman.tcz.common.item.PillowBlockItem;
import com.frenderman.tcz.common.tag.TCZBlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingKnockBackEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
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
        eventBus.register(new ConfigEvents());

        MinecraftForge.EVENT_BUS.register(new EntityEvents());

        TCZBlocks.BLOCKS.register(eventBus);
        TCZItems.ITEMS.register(eventBus);
        TCZEntities.ENTITIES.register(eventBus);
        TCZParticles.PARTICLES.register(eventBus);
        TCZBlockEntities.BLOCK_ENTITIES.register(eventBus);

        ModLoadingContext context = ModLoadingContext.get();
        context.registerConfig(ModConfig.Type.COMMON, TCZCommonConfig.COMMON_SPEC);
    }

    private void onCommonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(PillowBlockItem::refreshAttributeMod);
    }

    public static ResourceLocation resourceLoc(String path) {
        return new ResourceLocation(MODID, path);
    }
}
