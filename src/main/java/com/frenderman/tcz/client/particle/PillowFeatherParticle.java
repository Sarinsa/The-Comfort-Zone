package com.frenderman.tcz.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;

import java.util.Random;

public class PillowFeatherParticle extends TextureSheetParticle {

    private float rotSpeed;
    private final double gravity = -0.05D;

    public PillowFeatherParticle(ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, SpriteSet sprites) {
        super(level, x, y, z, xSpeed, ySpeed, zSpeed);
        RandomSource random = level.random;
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
        xo = x;
        yo = y;
        zo = z;

        if (age++ >= lifetime) {
            remove();
        }
        else {
            move(this.xd, this.yd, this.zd);
            xd *= 0.96F;
            yd *= 0.96F;
            zd *= 0.96F;

            oRoll = roll;
            roll += (float) Math.PI * rotSpeed * 2.0F;

            rotSpeed *= 0.98F;

            if (onGround) {
                oRoll = roll = 0.0F;
            }
        }
        if (yd > gravity) {
            yd -= 0.002D;
        }
        else if (yd < gravity) {
            yd += 0.002D;
        }
        subtractAlpha();
    }

    public void subtractAlpha() {
        double newAlpha = (1 - ((double)age / (double)lifetime));
        alpha = (float) newAlpha;
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
