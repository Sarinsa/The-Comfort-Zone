package com.frenderman.tcz.datagen;

import com.frenderman.tcz.common.core.TheComfortZone;
import com.frenderman.tcz.common.core.register.TCZBlocks;
import com.frenderman.tcz.common.tag.TCZItemTags;
import net.minecraft.data.*;
import net.minecraft.item.Item;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

public class TCZRecipeProvider extends RecipeProvider {

    public TCZRecipeProvider(DataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {
        this.shapedRecipe(TCZBlocks.WHITE_PILLOW.get(), 1)
                .unlockedBy("has_feathers", has(Tags.Items.FEATHERS))
                .pattern("##")
                .pattern("##")
                .define('#', Tags.Items.FEATHERS)
                .save(consumer, TheComfortZone.resourceLoc("white_pillow_from_feathers"));

        this.pillowRecipe(TCZBlocks.BLACK_PILLOW.get(), Tags.Items.DYES_BLACK, consumer);
        this.pillowRecipe(TCZBlocks.BLUE_PILLOW.get(), Tags.Items.DYES_BLUE, consumer);
        this.pillowRecipe(TCZBlocks.BROWN_PILLOW.get(), Tags.Items.DYES_BROWN, consumer);
        this.pillowRecipe(TCZBlocks.CYAN_PILLOW.get(), Tags.Items.DYES_CYAN, consumer);
        this.pillowRecipe(TCZBlocks.GRAY_PILLOW.get(), Tags.Items.DYES_GRAY, consumer);
        this.pillowRecipe(TCZBlocks.GREEN_PILLOW.get(), Tags.Items.DYES_GREEN, consumer);
        this.pillowRecipe(TCZBlocks.LIGHT_BLUE_PILLOW.get(), Tags.Items.DYES_LIGHT_BLUE, consumer);
        this.pillowRecipe(TCZBlocks.LIGHT_GRAY_PILLOW.get(), Tags.Items.DYES_LIGHT_GRAY, consumer);
        this.pillowRecipe(TCZBlocks.LIME_PILLOW.get(), Tags.Items.DYES_LIME, consumer);
        this.pillowRecipe(TCZBlocks.MAGENTA_PILLOW.get(), Tags.Items.DYES_MAGENTA, consumer);
        this.pillowRecipe(TCZBlocks.ORANGE_PILLOW.get(), Tags.Items.DYES_ORANGE, consumer);
        this.pillowRecipe(TCZBlocks.PINK_PILLOW.get(), Tags.Items.DYES_PINK, consumer);
        this.pillowRecipe(TCZBlocks.PURPLE_PILLOW.get(), Tags.Items.DYES_PURPLE, consumer);
        this.pillowRecipe(TCZBlocks.RED_PILLOW.get(), Tags.Items.DYES_RED, consumer);
        this.pillowRecipe(TCZBlocks.WHITE_PILLOW.get(), Tags.Items.DYES_WHITE, consumer);
        this.pillowRecipe(TCZBlocks.YELLOW_PILLOW.get(), Tags.Items.DYES_YELLOW, consumer);
    }

    private void pillowRecipe(IItemProvider pillow, Tags.IOptionalNamedTag<Item> dye, Consumer<IFinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(pillow, 1)
                .group(TheComfortZone.resourceLoc("pillows").toString())
                .requires(TCZItemTags.PILLOWS)
                .requires(dye)
                .unlockedBy("has_feathers", has(Tags.Items.FEATHERS))
                .save(consumer);
    }

    private ShapedRecipeBuilder shapedRecipe(IItemProvider result, int count) {
        return ShapedRecipeBuilder.shaped(result, count);
    }
}
