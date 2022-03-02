package com.frenderman.tcz.datagen.tags;

import com.frenderman.tcz.common.core.TheComfortZone;
import com.frenderman.tcz.common.tag.TCZBlockTags;
import com.frenderman.tcz.common.tag.TCZItemTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class TCZItemTagProvider extends ItemTagsProvider {

    public TCZItemTagProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagsProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(dataGenerator, blockTagsProvider, TheComfortZone.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        this.copy(TCZBlockTags.PILLOWS, TCZItemTags.PILLOWS);
        this.copy(TCZBlockTags.STOOLS, TCZItemTags.STOOLS);
    }
}
