package com.frenderman.tcz.common.particle;

import com.frenderman.tcz.common.core.register.TCZParticles;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Locale;

public class PillowFeatherParticleData implements ParticleOptions {

    public static void init() {}

    public static final Codec<PillowFeatherParticleData> CODEC = RecordCodecBuilder
            .create((dataInstance) -> dataInstance.group(Codec.DOUBLE.fieldOf("falldist")
                    .forGetter((particleData) -> particleData.fallDistance)).apply(dataInstance, PillowFeatherParticleData::new));

    public static final ParticleOptions.Deserializer<PillowFeatherParticleData> DESERIALIZER = new ParticleOptions.Deserializer<>() {

        public PillowFeatherParticleData fromCommand(ParticleType<PillowFeatherParticleData> particleType, StringReader stringReader) throws CommandSyntaxException {
            stringReader.expect(' ');
            double fallDist = stringReader.readDouble();
            return new PillowFeatherParticleData(fallDist);
        }

        public PillowFeatherParticleData fromNetwork(ParticleType<PillowFeatherParticleData> particleType, FriendlyByteBuf buffer) {
            return new PillowFeatherParticleData(buffer.readDouble());
        }
    };

    private double fallDistance;

    public PillowFeatherParticleData(double fallDistance) {
        this.fallDistance = fallDistance;
    }

    @Override
    public ParticleType<?> getType() {
        return TCZParticles.PILLOW_FEATHER_IMPACT.get();
    }

    @Override
    public void writeToNetwork(FriendlyByteBuf buffer) {
        buffer.writeDouble(this.fallDistance);
    }

    @Override
    public String writeToString() {
        return String.format(Locale.ROOT, "%s %s", ForgeRegistries.PARTICLE_TYPES.getKey(this.getType()), this.fallDistance);
    }

    public double getFallDistance() {
        return this.fallDistance;
    }
}
