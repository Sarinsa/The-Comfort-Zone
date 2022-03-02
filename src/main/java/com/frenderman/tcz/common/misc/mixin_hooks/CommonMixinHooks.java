package com.frenderman.tcz.common.misc.mixin_hooks;

import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.level.block.state.BlockState;

public class CommonMixinHooks {

    public static void onCatTick(Cat cat, BlockState onState) {
        /*
        if (cat.isInSittingPose()) {
            if (!cat.isLying()) {
                if (onState.is(TCZBlockTags.PILLOWS)) {
                    cat.setLying(true);
                }
            }
        }

         */
    }
}
