package com.frenderman.tcz.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;

import java.util.Random;

public class PillowFeatherParticle extends TextureSheetParticle {

    private float rotSpeed;
    private final double gravity = -0.05D;

    public PillowFeatherParticle(ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, SpriteSet sprites) {
        super(level, x, y, z, xSpeed, ySpeed, zSpeed);
        Random random = level.random;
        this.rotSpeed = ((float)Math.random() - 0.5F) * 0.1F;

        this.setSprite(sprites.get(random));
        this.setLifetime(55 + random.nextInt(30));
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @Override
    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;

        if (this.age++ >= this.lifetime) {
            this.remove();
        }
        else {
            this.move(this.xd, this.yd, this.zd);
            this.xd *= 0.96F;
            this.yd *= 0.96F;
            this.zd *= 0.96F;

            this.oRoll = this.roll;
            this.roll += (float)Math.PI * this.rotSpeed * 2.0F;

            this.rotSpeed *= 0.98F;

            if (this.onGround) {
                this.oRoll = this.roll = 0.0F;
            }
        }
        if (this.yd > this.gravity) {
            this.yd -= 0.002D;
        }
        else if (this.yd < this.gravity) {
            this.yd += 0.002D;
        }

        this.subtractAlpha();
    }

    public void subtractAlpha() {
        double alpha = (1 - ((double)age / (double)lifetime));
        this.alpha = (float) alpha;
    }

    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Provider(SpriteSet animatedSprite) {
            this.sprites = animatedSprite;
        }

        public Particle createParticle(SimpleParticleType particleType, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            return new PillowFeatherParticle(level, x, y, z, xSpeed, ySpeed, zSpeed, this.sprites);
        }
    }
}
