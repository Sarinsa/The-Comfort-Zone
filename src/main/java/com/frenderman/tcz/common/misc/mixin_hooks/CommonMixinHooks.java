package com.frenderman.tcz.common.misc.mixin_hooks;

import net.minecraft.block.BlockState;
import net.minecraft.entity.passive.CatEntity;

public class CommonMixinHooks {

    public static void onCatTick(CatEntity cat, BlockState onState) {
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
