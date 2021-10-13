package com.frenderman.tcz.client.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particles.BasicParticleType;

import java.util.Random;

public class PillowFeatherParticle extends SpriteTexturedParticle {

    private float rotSpeed;
    private final double gravity = -0.05D;

    public PillowFeatherParticle(ClientWorld clientWorld, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, IAnimatedSprite sprite) {
        super(clientWorld, x, y, z, xSpeed, ySpeed, zSpeed);
        Random random = clientWorld.random;
        this.rotSpeed = ((float)Math.random() - 0.5F) * 0.1F;

        this.setSprite(sprite.get(random));
        this.setLifetime(55 + random.nextInt(30));
    }

    @Override
    public IParticleRenderType getRenderType() {
        return IParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
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

    public static class Factory implements IParticleFactory<BasicParticleType> {
        private final IAnimatedSprite sprites;

        public Factory(IAnimatedSprite animatedSprite) {
            this.sprites = animatedSprite;
        }

        public Particle createParticle(BasicParticleType basicParticleType, ClientWorld clientWorld, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            return new PillowFeatherParticle(clientWorld, x, y, z, xSpeed, ySpeed, zSpeed, this.sprites);
        }
    }
}
