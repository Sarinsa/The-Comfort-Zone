package com.frenderman.tcz.client.renderer.misc;

import net.minecraft.client.renderer.culling.ClippingHelper;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

/**
 * Used for the rideable dummy entity which is used
 * for sitting on pillows and whatnot.
 */
public class NoRenderer<T extends Entity> extends EntityRenderer<T> {

    private static final ResourceLocation TEXTURE = new ResourceLocation("");

    public NoRenderer(EntityRendererManager rendererManager) {
        super(rendererManager);
    }

    @Override
    public boolean shouldRender(T entity, ClippingHelper clippingHelper, double x, double y, double z) {
        return false;
    }

    @Override
    public ResourceLocation getTextureLocation(T entity) {
        return TEXTURE;
    }
}
