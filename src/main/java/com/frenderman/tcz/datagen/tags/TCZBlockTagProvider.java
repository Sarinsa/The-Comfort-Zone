package com.frenderman.tcz.datagen.tags;

import com.frenderman.tcz.common.core.TheComfortZone;
import com.frenderman.tcz.common.tag.TCZBlockTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import static com.frenderman.tcz.common.core.register.TCZBlocks.*;

import javax.annotation.Nullable;

public class TCZBlockTagProvider extends BlockTagsProvider {

    public TCZBlockTagProvider(DataGenerator dataGenerator, @Nullable ExistingFileHelper existingFileHelper) {
        super(dataGenerator, TheComfortZone.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        this.tag(TCZBlockTags.PILLOWS).add(
                BLACK_PILLOW.get(),
                BLUE_PILLOW.get(),
                BROWN_PILLOW.get(),
                CYAN_PILLOW.get(),
                GRAY_PILLOW.get(),
                GREEN_PILLOW.get(),
                LIGHT_BLUE_PILLOW.get(),
                LIGHT_GRAY_PILLOW.get(),
                LIME_PILLOW.get(),
                MAGENTA_PILLOW.get(),
                ORANGE_PILLOW.get(),
                PINK_PILLOW.get(),
                PURPLE_PILLOW.get(),
                RED_PILLOW.get(),
                WHITE_PILLOW.get(),
                YELLOW_PILLOW.get()
        );
    }
}
