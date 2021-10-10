package com.frenderman.tcz.client.particle;

import com.frenderman.tcz.common.core.register.TCZParticles;
import com.frenderman.tcz.common.particle.PillowFeatherParticleData;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.MetaParticle;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.world.ClientWorld;

import javax.annotation.Nullable;

public class PillowFeatherImpactParticle extends MetaParticle {

    private int timeSinceStart;

    private final int particleCount;
    private final int runs;

    private final double xSpeed;
    private final double ySpeed;
    private final double zSpeed;

    private PillowFeatherImpactParticle(ClientWorld world, PillowFeatherParticleData particleData, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
        super(world, x, y, z, 0.0D, 0.0D, 0.0D);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.zSpeed = zSpeed;

        double fallDist = particleData.getFallDistance();

        this.particleCount = Math.min(55, (int) (fallDist * 1.4));
        this.runs = Math.min(4, (int) (fallDist * 0.3) + 1);
    }

    public void tick() {
        for(int i = 0; i < this.particleCount; ++i) {
            double xSpeed = this.xSpeed != 0.0D ? this.zSpeed : (random.nextGaussian() * 10.0D);
            double ySpeed = this.ySpeed != 0.0D ? this.ySpeed : (random.nextGaussian() * 10.0D);
            double zSpeed = this.zSpeed != 0.0D ? this.zSpeed : (random.nextGaussian() * 10.0D);
            this.level.addParticle(TCZParticles.PILLOW_FEATHER.get(), this.x, this.y, this.z, xSpeed, ySpeed, zSpeed);
        }
        ++this.timeSinceStart;
        if (this.timeSinceStart >= this.runs) {
            this.remove();
        }
    }

    public static class Factory implements IParticleFactory<PillowFeatherParticleData> {

        @Nullable
        @Override
        public Particle createParticle(PillowFeatherParticleData particleData, ClientWorld clientWorld, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            return new PillowFeatherImpactParticle(clientWorld, particleData, x, y, z, xSpeed, ySpeed, zSpeed);
        }
    }
}
