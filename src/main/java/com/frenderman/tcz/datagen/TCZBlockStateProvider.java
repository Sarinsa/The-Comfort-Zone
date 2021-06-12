package com.frenderman.tcz.datagen;

import com.frenderman.tcz.common.core.TheComfortZone;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import static com.frenderman.tcz.common.core.register.TCZBlocks.*;

public class TCZBlockStateProvider extends BlockStateProvider {

    public TCZBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, TheComfortZone.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        this.pillowBlock(BLACK_PILLOW.get());
        this.pillowBlock(BLUE_PILLOW.get());
        this.pillowBlock(BROWN_PILLOW.get());
        this.pillowBlock(CYAN_PILLOW.get());
        this.pillowBlock(GRAY_PILLOW.get());
        this.pillowBlock(GREEN_PILLOW.get());
        this.pillowBlock(LIGHT_BLUE_PILLOW.get());
        this.pillowBlock(LIGHT_GRAY_PILLOW.get());
        this.pillowBlock(LIME_PILLOW.get());
        this.pillowBlock(MAGENTA_PILLOW.get());
        this.pillowBlock(ORANGE_PILLOW.get());
        this.pillowBlock(PINK_PILLOW.get());
        this.pillowBlock(PURPLE_PILLOW.get());
        this.pillowBlock(RED_PILLOW.get());
        this.pillowBlock(WHITE_PILLOW.get());
        this.pillowBlock(YELLOW_PILLOW.get());
    }

    private String name(Block block) {
        return block.getRegistryName().getPath();
    }

    private ResourceLocation texture(String path) {
        return new ResourceLocation(TheComfortZone.MODID, ModelProvider.BLOCK_FOLDER + "/" + path);
    }

    private void pillowBlock(Block pillowBlock) {
        String name = pillowBlock.getBlock().getRegistryName().getPath();
        ModelFile model = models().withExistingParent(name(pillowBlock), TheComfortZone.MODID + ":block/pillow")
                .texture("side", texture(name))
                .texture("bottom", texture(name + "_bottom"))
                .texture("top", texture(name + "_top"));

        getVariantBuilder(pillowBlock)
                .forAllStates((state) -> ConfiguredModel.builder()
                        .modelFile(model)
                        .build());
        simpleBlockItem(pillowBlock, model);
    }
}
