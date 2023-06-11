package com.frenderman.tcz.datagen.tags;

import com.frenderman.tcz.common.core.TheComfortZone;
import com.frenderman.tcz.common.tag.TCZBlockTags;
import com.frenderman.tcz.common.tag.TCZItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class TCZItemTagProvider extends ItemTagsProvider {

    public TCZItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagsProvider.TagLookup<Block>> blockTagsProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTagsProvider, TheComfortZone.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.copy(TCZBlockTags.PILLOWS, TCZItemTags.PILLOWS);
        //this.copy(TCZBlockTags.STOOLS, TCZItemTags.STOOLS);
    }
}
