package com.frenderman.tcz.common.mixin;

import com.frenderman.tcz.common.core.TheComfortZone;
import com.frenderman.tcz.common.tag.TCZBlockTags;
import net.minecraft.entity.ai.goal.CatLieOnBedGoal;
import net.minecraft.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CatLieOnBedGoal.class)
public abstract class CatLieOnBedGoalMixin extends MoveToBlockGoal {

    public CatLieOnBedGoalMixin(CatEntity catEntity, double p_i45888_2_, int p_i45888_4_) {
        super(catEntity, p_i45888_2_, p_i45888_4_);
    }

    @Inject(method = "isValidTarget", at = @At("HEAD"), cancellable = true)
    public void onIsValidTarget(IWorldReader world, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        TheComfortZone.LOGGER.info("Is block pillow: " + world.getBlockState(pos).getBlock().is(TCZBlockTags.PILLOWS));
        if (world.isEmptyBlock(pos.above()) && world.getBlockState(pos).getBlock().is(TCZBlockTags.PILLOWS)) {
            cir.setReturnValue(true);
        }
    }
}
