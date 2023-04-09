package com.frenderman.tcz.client;

import com.frenderman.tcz.client.particle.PillowFeatherExplosionParticle;
import com.frenderman.tcz.client.particle.PillowFeatherImpactParticle;
import com.frenderman.tcz.client.particle.PillowFeatherParticle;
import com.frenderman.tcz.client.renderer.misc.NoRenderer;
import com.frenderman.tcz.common.core.TheComfortZone;
import com.frenderman.tcz.common.core.register.TCZEntities;
import com.frenderman.tcz.common.core.register.TCZParticles;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = TheComfortZone.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientRegister {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {

    }

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(TCZEntities.RIDEABLE_DUMMY_ENTITY.get(), NoRenderer::new);
    }

    @SubscribeEvent
    public static void registerParticleFactories(RegisterParticleProvidersEvent event) {
        event.register(TCZParticles.PILLOW_FEATHER.get(), PillowFeatherParticle.Provider::new);
        event.register(TCZParticles.PILLOW_FEATHER_POOF.get(), new PillowFeatherExplosionParticle.Provider());
        event.register(TCZParticles.PILLOW_FEATHER_IMPACT.get(), new PillowFeatherImpactParticle.Provider());
    }
}
