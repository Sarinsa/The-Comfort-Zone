package com.frenderman.tcz.common.mixin;

import com.frenderman.tcz.common.misc.mixin_hooks.CommonMixinHooks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CatEntity.class)
public abstract class CatEntityMixin extends TameableEntity {

    protected CatEntityMixin(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/passive/TameableEntity;tick()V", ordinal = 0, shift = At.Shift.AFTER))
    public void onTick(CallbackInfo ci) {
        CommonMixinHooks.onCatTick((CatEntity) (Object) this, this.getBlockStateOn());
    }
}
