package com.frenderman.tcz.client.particle;

import com.frenderman.tcz.common.core.register.TCZParticles;
import com.frenderman.tcz.common.particle.PillowFeatherParticleData;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.NoRenderParticle;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;

import javax.annotation.Nullable;

public class PillowFeatherImpactParticle extends NoRenderParticle {

    private int timeSinceStart;

    private final int particleCount;
    private final int runs;

    private final double xSpeed;
    private final double ySpeed;
    private final double zSpeed;

    private PillowFeatherImpactParticle(ClientLevel level, PillowFeatherParticleData particleData, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
        super(level, x, y, z, 0.0D, 0.0D, 0.0D);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.zSpeed = zSpeed;

        double fallDist = particleData.getFallDistance();

        particleCount = Math.min(55, (int) (fallDist * 1.4));
        runs = Math.min(4, (int) (fallDist * 0.3) + 1);
    }

    public void tick() {
        for(int i = 0; i < this.particleCount; ++i) {
            double xSpeed = this.xSpeed != 0.0D ? this.zSpeed : (random.nextGaussian() * 10.0D);
            double ySpeed = this.ySpeed != 0.0D ? this.ySpeed : (random.nextGaussian() * 10.0D);
            double zSpeed = this.zSpeed != 0.0D ? this.zSpeed : (random.nextGaussian() * 10.0D);
            level.addParticle(TCZParticles.PILLOW_FEATHER.get(), x, y, z, xSpeed, ySpeed, zSpeed);
        }
        ++timeSinceStart;
        if (timeSinceStart >= runs) {
            remove();
        }
    }

    public static class Provider implements ParticleProvider<PillowFeatherParticleData> {

        @Nullable
        @Override
        public Particle createParticle(PillowFeatherParticleData particleData, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            return new PillowFeatherImpactParticle(level, particleData, x, y, z, xSpeed, ySpeed, zSpeed);
        }
    }
}
