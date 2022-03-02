package com.frenderman.tcz.client.renderer.misc;

import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

/**
 * Used for the rideable dummy entity.
 */
public class NoRenderer<T extends Entity> extends EntityRenderer<T> {

    private static final ResourceLocation TEXTURE = new ResourceLocation("");

    public NoRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public boolean shouldRender(T entity, Frustum clippingHelper, double x, double y, double z) {
        return false;
    }

    @Override
    public ResourceLocation getTextureLocation(T entity) {
        return TEXTURE;
    }
}
