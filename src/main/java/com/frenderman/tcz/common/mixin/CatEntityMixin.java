package com.frenderman.tcz.common.mixin;

import com.frenderman.tcz.common.misc.mixin_hooks.CommonMixinHooks;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Cat.class)
public abstract class CatEntityMixin extends TamableAnimal {

    protected CatEntityMixin(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/TamableAnimal;tick()V", ordinal = 0, shift = At.Shift.AFTER))
    public void onTick(CallbackInfo ci) {
        CommonMixinHooks.onCatTick((Cat) (Object) this, this.getBlockStateOn());
    }
}
