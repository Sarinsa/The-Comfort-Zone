package com.frenderman.tcz.datagen.tags;

import com.frenderman.tcz.common.core.TheComfortZone;
import com.frenderman.tcz.common.tag.TCZBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

import java.util.concurrent.CompletableFuture;

import static com.frenderman.tcz.common.core.register.TCZBlocks.*;

public class TCZBlockTagProvider extends BlockTagsProvider {

    public TCZBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TheComfortZone.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
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

        /*
        this.tag(TCZBlockTags.STOOLS).add(
                BLACK_OAK_STOOL.get(),
                BLUE_OAK_STOOL.get(),
                BROWN_OAK_STOOL.get(),
                CYAN_OAK_STOOL.get(),
                GRAY_OAK_STOOL.get(),
                GREEN_OAK_STOOL.get(),
                LIGHT_BLUE_OAK_STOOL.get(),
                LIGHT_GRAY_OAK_STOOL.get(),
                LIME_OAK_STOOL.get(),
                MAGENTA_OAK_STOOL.get(),
                ORANGE_OAK_STOOL.get(),
                PINK_OAK_STOOL.get(),
                PURPLE_OAK_STOOL.get(),
                RED_OAK_STOOL.get(),
                WHITE_OAK_STOOL.get(),
                YELLOW_OAK_STOOL.get()
        );

         */

        this.tag(TCZBlockTags.SITTABLES).addTag(TCZBlockTags.PILLOWS);
        //this.tag(TCZBlockTags.PILLOWS).addTag(TCZBlockTags.STOOLS);
    }
}
