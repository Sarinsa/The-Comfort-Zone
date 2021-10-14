package com.frenderman.tcz.common.core.config;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class TCZCommonConfig {

    public static final Common COMMON;
    public static final ForgeConfigSpec COMMON_SPEC;

    static {
        Pair<Common, ForgeConfigSpec> commonPair = new ForgeConfigSpec.Builder().configure(Common::new);
        COMMON = commonPair.getLeft();
        COMMON_SPEC = commonPair.getRight();
    }

    public static final class Common {

        private final ForgeConfigSpec.BooleanValue pillowKnockback;


        private Common(ForgeConfigSpec.Builder configBuilder) {

            this.pillowKnockback = configBuilder.comment("(EXPERIMENTAL FEATURE) By default, punching entities with a pillow will knock them further away than normal. If this at any point" +
                            " causes the game to crash or creates trouble otherwise, pillow knockback can be disabled here.")
                    .define("pillow_knockback", true);
        }

        public boolean pillowKnockbackEnabled() {
            return this.pillowKnockback.get();
        }
    }
}
