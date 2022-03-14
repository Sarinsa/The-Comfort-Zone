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
        private final ForgeConfigSpec.DoubleValue pillowKnockbackStrength;


        private Common(ForgeConfigSpec.Builder configBuilder) {

            this.pillowKnockback = configBuilder.comment("If enabled, pillows will have increased knockback when hitting mobs.")
                    .define("pillow_knockback", true);

            this.pillowKnockbackStrength = configBuilder.comment("If pillow knockback is enabled, this field will determine the knockback strength. Note that this only changes the pillow block item's " +
                            "knockback attribute modifier, and in vanilla Minecraft the player's knockback attribute has a max cap of 5.0, so going above this will have no effect.")
                    .defineInRange("pillow_knockback_strength", 1.2D, 0.0D, 1000.0D);
        }


        public boolean pillowKnockbackEnabled() {
            return this.pillowKnockback.get();
        }

        public double getPillowKnockbackStrength() {
            return this.pillowKnockbackStrength.get();
        }
    }
}
