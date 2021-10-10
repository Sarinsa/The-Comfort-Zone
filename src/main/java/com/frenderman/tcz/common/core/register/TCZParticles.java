package com.frenderman.tcz.common.core.register;

import com.frenderman.tcz.common.core.TheComfortZone;
import com.frenderman.tcz.common.particle.PillowFeatherParticleData;
import com.mojang.serialization.Codec;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class TCZParticles {

    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, TheComfortZone.MODID);


    public static final RegistryObject<BasicParticleType> PILLOW_FEATHER = registerBasic("pillow_feather", true);
    public static final RegistryObject<BasicParticleType> PILLOW_FEATHER_POOF = registerBasic("pillow_feather_poof", true);
    public static final RegistryObject<ParticleType<PillowFeatherParticleData>> PILLOW_FEATHER_IMPACT = register("pillow_feather_impact", ParticleTypes.PillowFeatherParticleType::new);


    private static RegistryObject<BasicParticleType> registerBasic(String name, boolean alwaysShow) {
        return PARTICLES.register(name, () -> new BasicParticleType(alwaysShow));
    }

    private static <T extends IParticleData> RegistryObject<ParticleType<T>> register(String name, Supplier<ParticleType<T>> particleTypeSupplier) {
        return PARTICLES.register(name, particleTypeSupplier);
    }

    /**
     * Inner class containing our custom
     * particle types.
     */
    public static class ParticleTypes {

        public static class PillowFeatherParticleType extends ParticleType<PillowFeatherParticleData> {

            public PillowFeatherParticleType() {
                super(false, PillowFeatherParticleData.DESERIALIZER);
            }

            @Override
            public Codec<PillowFeatherParticleData> codec() {
                return PillowFeatherParticleData.CODEC;
            }
        }
    }
}
