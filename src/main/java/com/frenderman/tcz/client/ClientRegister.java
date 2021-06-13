package com.frenderman.tcz.client;

import com.frenderman.tcz.client.renderer.misc.NoRenderer;
import com.frenderman.tcz.common.core.TheComfortZone;
import com.frenderman.tcz.common.core.register.TCZEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = TheComfortZone.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientRegister {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        registerEntityRenderers();
    }

    private static void registerEntityRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(TCZEntities.RIDEABLE_DUMMY_ENTITY.get(), NoRenderer::new);
    }
}
