package com.frenderman.tcz.client.particle;

import com.frenderman.tcz.common.core.register.TCZParticles;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.MetaParticle;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particles.BasicParticleType;

public class PillowFeatherExplosionParticle extends MetaParticle {

    private int timeSinceStart;

    private final double xSpeed;
    private final double ySpeed;
    private final double zSpeed;

    private PillowFeatherExplosionParticle(ClientWorld world, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
        super(world, x, y, z, 0.0D, 0.0D, 0.0D);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.zSpeed = zSpeed;
    }

    public void tick() {
        for(int i = 0; i < 15; ++i) {
            double xSpeed = this.xSpeed != 0.0D ? this.zSpeed : (random.nextGaussian() * 10.0D);
            double ySpeed = this.ySpeed != 0.0D ? this.ySpeed : (random.nextGaussian() * 10.0D);
            double zSpeed = this.zSpeed != 0.0D ? this.zSpeed : (random.nextGaussian() * 10.0D);
            this.level.addParticle(TCZParticles.PILLOW_FEATHER.get(), this.x, this.y, this.z, xSpeed, ySpeed, zSpeed);
        }
        ++this.timeSinceStart;
        if (this.timeSinceStart >= 5) {
            this.remove();
        }
    }

    public static class Factory implements IParticleFactory<BasicParticleType> {

        public Particle createParticle(BasicParticleType type, ClientWorld world, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            return new PillowFeatherExplosionParticle(world, x, y, z, xSpeed, ySpeed, zSpeed);
        }
    }
}
