package com.frenderman.tcz.common.mixin;

import com.frenderman.tcz.common.core.config.TCZCommonConfig;
import com.frenderman.tcz.common.tag.TCZItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    @Unique
    private DamageSource tczSource;

    public LivingEntityMixin(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "hurt", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;knockback(DDD)V", shift = At.Shift.BEFORE))
    public void onHurt(DamageSource damageSource, float damage, CallbackInfoReturnable<Boolean> cir) {
        this.tczSource = damageSource;
    }

    @ModifyArg(method = "hurt", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;knockback(DDD)V"), index = 0)
    public float modifyKnockback(float knockback) {
        if (!TCZCommonConfig.COMMON.pillowKnockbackEnabled())
            return knockback;

        DamageSource damageSource = this.tczSource;

        if (damageSource == null) {
            return knockback;
        }

        if (damageSource.getDirectEntity() instanceof LivingEntity) {
            LivingEntity entity = (LivingEntity) damageSource.getDirectEntity();
            ItemStack stack = entity.getItemInHand(InteractionHand.MAIN_HAND);

            if (!stack.isEmpty() && stack.is(TCZItemTags.PILLOWS)) {
                return knockback + 0.4F;
            }
        }
        this.tczSource = null;
        return knockback;
    }
}
