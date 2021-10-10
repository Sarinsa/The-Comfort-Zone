package com.frenderman.tcz.client;

import com.frenderman.tcz.client.particle.PillowFeatherExplosionParticle;
import com.frenderman.tcz.client.particle.PillowFeatherImpactParticle;
import com.frenderman.tcz.client.particle.PillowFeatherParticle;
import com.frenderman.tcz.client.renderer.misc.NoRenderer;
import com.frenderman.tcz.common.core.TheComfortZone;
import com.frenderman.tcz.common.core.register.TCZEntities;
import com.frenderman.tcz.common.core.register.TCZParticles;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
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

    @SubscribeEvent
    public static void registerParticleFactories(ParticleFactoryRegisterEvent event) {
        ParticleManager particleManager = Minecraft.getInstance().particleEngine;

        particleManager.register(TCZParticles.PILLOW_FEATHER.get(), PillowFeatherParticle.Factory::new);
        particleManager.register(TCZParticles.PILLOW_FEATHER_POOF.get(), new PillowFeatherExplosionParticle.Factory());
        particleManager.register(TCZParticles.PILLOW_FEATHER_IMPACT.get(), new PillowFeatherImpactParticle.Factory());
    }
}
