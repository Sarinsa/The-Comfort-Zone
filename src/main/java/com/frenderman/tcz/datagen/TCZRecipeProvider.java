package com.frenderman.tcz.datagen;

import com.frenderman.tcz.common.core.TheComfortZone;
import com.frenderman.tcz.common.core.register.TCZBlocks;
import com.frenderman.tcz.common.tag.TCZItemTags;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

public class TCZRecipeProvider extends RecipeProvider {

    public TCZRecipeProvider(DataGenerator dataGenerator) {
        super(dataGenerator.getPackOutput());
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
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

        /*
        this.stoolRecipe(TCZBlocks.BLACK_OAK_STOOL.get(), TCZBlocks.BLACK_PILLOW.get(), Items.OAK_SLAB, consumer);
        this.stoolRecipe(TCZBlocks.BLUE_OAK_STOOL.get(), TCZBlocks.BLUE_PILLOW.get(), Items.OAK_SLAB, consumer);
        this.stoolRecipe(TCZBlocks.BROWN_OAK_STOOL.get(), TCZBlocks.BROWN_PILLOW.get(), Items.OAK_SLAB, consumer);
        this.stoolRecipe(TCZBlocks.CYAN_OAK_STOOL.get(), TCZBlocks.CYAN_PILLOW.get(), Items.OAK_SLAB, consumer);
        this.stoolRecipe(TCZBlocks.GRAY_OAK_STOOL.get(), TCZBlocks.GRAY_PILLOW.get(), Items.OAK_SLAB, consumer);
        this.stoolRecipe(TCZBlocks.GREEN_OAK_STOOL.get(), TCZBlocks.GREEN_PILLOW.get(), Items.OAK_SLAB, consumer);
        this.stoolRecipe(TCZBlocks.LIGHT_BLUE_OAK_STOOL.get(), TCZBlocks.LIGHT_BLUE_PILLOW.get(), Items.OAK_SLAB, consumer);
        this.stoolRecipe(TCZBlocks.LIGHT_GRAY_OAK_STOOL.get(), TCZBlocks.LIGHT_GRAY_PILLOW.get(), Items.OAK_SLAB, consumer);
        this.stoolRecipe(TCZBlocks.LIME_OAK_STOOL.get(), TCZBlocks.LIME_PILLOW.get(), Items.OAK_SLAB, consumer);
        this.stoolRecipe(TCZBlocks.MAGENTA_OAK_STOOL.get(), TCZBlocks.MAGENTA_PILLOW.get(), Items.OAK_SLAB, consumer);
        this.stoolRecipe(TCZBlocks.ORANGE_OAK_STOOL.get(), TCZBlocks.ORANGE_PILLOW.get(), Items.OAK_SLAB, consumer);
        this.stoolRecipe(TCZBlocks.PINK_OAK_STOOL.get(), TCZBlocks.PINK_PILLOW.get(), Items.OAK_SLAB, consumer);
        this.stoolRecipe(TCZBlocks.PURPLE_OAK_STOOL.get(), TCZBlocks.PURPLE_PILLOW.get(), Items.OAK_SLAB, consumer);
        this.stoolRecipe(TCZBlocks.RED_OAK_STOOL.get(), TCZBlocks.RED_PILLOW.get(), Items.OAK_SLAB, consumer);
        this.stoolRecipe(TCZBlocks.WHITE_OAK_STOOL.get(), TCZBlocks.WHITE_PILLOW.get(), Items.OAK_SLAB, consumer);
        this.stoolRecipe(TCZBlocks.YELLOW_OAK_STOOL.get(), TCZBlocks.YELLOW_PILLOW.get(), Items.OAK_SLAB, consumer);

         */
    }

    private ShapedRecipeBuilder shapedRecipe(ItemLike result, int count) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result, count);
    }

    private void pillowRecipe(ItemLike pillow, TagKey<Item> dye, Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, pillow, 1)
                .group(TheComfortZone.resourceLoc("pillows").toString())
                .requires(TCZItemTags.PILLOWS)
                .requires(dye)
                .unlockedBy("has_feathers", has(Tags.Items.FEATHERS))
                .save(consumer);
    }

    private void stoolRecipe(ItemLike stool, ItemLike pillow, ItemLike slab, Consumer<FinishedRecipe> consumer) {
        shapedRecipe(stool, 1)
                .group(TheComfortZone.resourceLoc("stools").toString())
                .pattern("P")
                .pattern("S")
                .define('P', pillow)
                .define('S', slab)
                .unlockedBy("has_items", inventoryTrigger(
                        ItemPredicate.Builder.item().of(TCZItemTags.PILLOWS).build(),
                        ItemPredicate.Builder.item().of(slab).build()
                ))
                .save(consumer);
    }
}
