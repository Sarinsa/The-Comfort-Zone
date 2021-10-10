package com.frenderman.tcz.client.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particles.BasicParticleType;

import java.util.Random;

public class PillowFeatherParticle extends SpriteTexturedParticle {

    public PillowFeatherParticle(ClientWorld clientWorld, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, IAnimatedSprite sprite) {
        super(clientWorld, x, y, z, xSpeed, ySpeed, zSpeed);
        Random random = clientWorld.random;

        this.setSprite(sprite.get(random));
        this.setLifetime(55 + random.nextInt(30));
    }

    @Override
    public IParticleRenderType getRenderType() {
        return IParticleRenderType.PARTICLE_SHEET_OPAQUE;
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
            this.xd *= 0.95F;
            this.yd *= 0.95F;
            this.zd *= 0.95F;

            if (this.onGround) {
                this.xd *= 0.4F;
                this.zd *= 0.4F;
            }
        }
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
