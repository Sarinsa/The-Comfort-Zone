package com.frenderman.tcz.datagen;

import com.frenderman.tcz.common.core.TheComfortZone;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
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

        this.stoolBlock(BLACK_OAK_STOOL.get(), Blocks.OAK_PLANKS);
        this.stoolBlock(BLUE_OAK_STOOL.get(), Blocks.OAK_PLANKS);
        this.stoolBlock(BROWN_OAK_STOOL.get(), Blocks.OAK_PLANKS);
        this.stoolBlock(CYAN_OAK_STOOL.get(), Blocks.OAK_PLANKS);
        this.stoolBlock(GRAY_OAK_STOOL.get(), Blocks.OAK_PLANKS);
        this.stoolBlock(GREEN_OAK_STOOL.get(), Blocks.OAK_PLANKS);
        this.stoolBlock(LIGHT_BLUE_OAK_STOOL.get(), Blocks.OAK_PLANKS);
        this.stoolBlock(LIGHT_GRAY_OAK_STOOL.get(), Blocks.OAK_PLANKS);
        this.stoolBlock(LIME_OAK_STOOL.get(), Blocks.OAK_PLANKS);
        this.stoolBlock(MAGENTA_OAK_STOOL.get(), Blocks.OAK_PLANKS);
        this.stoolBlock(ORANGE_OAK_STOOL.get(), Blocks.OAK_PLANKS);
        this.stoolBlock(PINK_OAK_STOOL.get(), Blocks.OAK_PLANKS);
        this.stoolBlock(PURPLE_OAK_STOOL.get(), Blocks.OAK_PLANKS);
        this.stoolBlock(RED_OAK_STOOL.get(), Blocks.OAK_PLANKS);
        this.stoolBlock(WHITE_OAK_STOOL.get(), Blocks.OAK_PLANKS);
        this.stoolBlock(YELLOW_OAK_STOOL.get(), Blocks.OAK_PLANKS);
    }

    private String name(Block block) {
        return block.getRegistryName().getPath();
    }

    private ResourceLocation texture(String path) {
        return new ResourceLocation(TheComfortZone.MODID, ModelProvider.BLOCK_FOLDER + "/" + path);
    }

    private ResourceLocation vanillaTexture(String path) {
        return new ResourceLocation(ModelProvider.BLOCK_FOLDER + "/" + path);
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

    private void stoolBlock(Block stoolBlock, Block planks) {
        try {
            String name = stoolBlock.getBlock().getRegistryName().getPath();
            String planksName = planks.getRegistryName().getPath();
            String plankWoodName = planksName.split("_")[0];
            String topName = name.split(plankWoodName)[0];

            ModelFile model = models().withExistingParent(name(stoolBlock), TheComfortZone.MODID + ":block/stool_template")
                    .texture("side", texture(name + "_side"))
                    .texture("bottom", texture(plankWoodName + "_stool_bottom"))
                    .texture("top", texture(topName + "stool_top"))
                    .texture("planks", vanillaTexture(planksName));


            getVariantBuilder(stoolBlock)
                    .forAllStates((state) -> ConfiguredModel.builder()
                            .modelFile(model)
                            .build());
            simpleBlockItem(stoolBlock, model);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
