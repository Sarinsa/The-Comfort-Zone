package com.frenderman.tcz.common.misc;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.entity.animal.Cat;

// UNUSED
public class NBTHelper {

    /*
    private static final String MOD_DATA_KEY = "thecomfortzoneData";
    private static final String PILLOW_CHILL_KEY = "PillowChilling";


    public static void setCatPillowChill(Cat cat, boolean chilling) {
        CompoundTag entityData = cat.getPersistentData();

        if (entityData.contains(MOD_DATA_KEY, Tag.TAG_COMPOUND)) {
            entityData.getCompound(MOD_DATA_KEY).putBoolean(PILLOW_CHILL_KEY, chilling);
        }
        else {
            CompoundTag modData = new CompoundTag();
            modData.putBoolean(PILLOW_CHILL_KEY, chilling);
            entityData.put(MOD_DATA_KEY, modData);
        }
    }

    public static boolean isCatPillowChill(Cat cat) {
        CompoundTag entityData = cat.getPersistentData();

        if (entityData.contains(MOD_DATA_KEY, Tag.TAG_COMPOUND)) {
            return entityData.getCompound(MOD_DATA_KEY).contains(PILLOW_CHILL_KEY, Tag.TAG_BYTE)
                    && entityData.getCompound(MOD_DATA_KEY).getBoolean(PILLOW_CHILL_KEY);
        }
        return false;
    }

     */
}
