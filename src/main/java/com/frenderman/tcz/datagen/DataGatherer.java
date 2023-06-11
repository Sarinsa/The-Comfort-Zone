package com.frenderman.tcz.datagen;

import com.frenderman.tcz.common.core.TheComfortZone;
import com.frenderman.tcz.datagen.loot_table.TCZBlockLootTables;
import com.frenderman.tcz.datagen.loot_table.TCZLootTableProvider;
import com.frenderman.tcz.datagen.tags.TCZBlockTagProvider;
import com.frenderman.tcz.datagen.tags.TCZItemTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = TheComfortZone.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGatherer {


    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        DataGenerator dataGen = event.getGenerator();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        PackOutput packOutput = dataGen.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        if (event.includeServer()) {
            List<LootTableProvider.SubProviderEntry> subproviders = new ArrayList<>();

            subproviders.add(new LootTableProvider.SubProviderEntry(() -> new TCZBlockLootTables(FeatureFlags.DEFAULT_FLAGS), LootContextParamSets.BLOCK));

            dataGen.addProvider(true, new TCZRecipeProvider(dataGen));
            dataGen.addProvider(true, new TCZLootTableProvider(dataGen.getPackOutput(), subproviders));
            TCZBlockTagProvider blockTagProvider = new TCZBlockTagProvider(packOutput, lookupProvider, fileHelper);
            dataGen.addProvider(true, blockTagProvider);
            dataGen.addProvider(true, new TCZItemTagProvider(packOutput, lookupProvider, blockTagProvider.contentsGetter(), fileHelper));
        }
        if (event.includeClient()) {
            dataGen.addProvider(true, new TCZBlockStateProvider(dataGen, fileHelper));
            dataGen.addProvider(true, new TCZLangProvider(dataGen));
        }
    }
}
