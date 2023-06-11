package com.frenderman.tcz.datagen;

import com.frenderman.tcz.common.core.TheComfortZone;
import com.frenderman.tcz.datagen.loot_table.TCZLootTableProvider;
import com.frenderman.tcz.datagen.tags.TCZBlockTagProvider;
import com.frenderman.tcz.datagen.tags.TCZItemTagProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TheComfortZone.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGatherer {


    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        DataGenerator dataGen = event.getGenerator();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();

        if (event.includeServer()) {
            dataGen.addProvider(true, new TCZRecipeProvider(dataGen));
            dataGen.addProvider(true, new TCZLootTableProvider(dataGen));
            TCZBlockTagProvider blockTagProvider = new TCZBlockTagProvider(dataGen, fileHelper);
            dataGen.addProvider(true, blockTagProvider);
            dataGen.addProvider(true, new TCZItemTagProvider(dataGen, blockTagProvider, fileHelper));
        }
        if (event.includeClient()) {
            dataGen.addProvider(true, new TCZBlockStateProvider(dataGen, fileHelper));
            dataGen.addProvider(true, new TCZLangProvider(dataGen));
        }
    }
}
