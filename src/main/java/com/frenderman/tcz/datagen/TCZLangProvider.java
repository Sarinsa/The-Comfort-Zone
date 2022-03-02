package com.frenderman.tcz.datagen;

import com.frenderman.tcz.common.core.TheComfortZone;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

import static com.frenderman.tcz.common.core.register.TCZBlocks.*;

public class TCZLangProvider extends LanguageProvider {

    public TCZLangProvider(DataGenerator gen) {
        super(gen, TheComfortZone.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        this.addBlock(BLACK_PILLOW, "Black Pillow");
        this.addBlock(BLUE_PILLOW, "Blue Pillow");
        this.addBlock(BROWN_PILLOW, "Brown Pillow");
        this.addBlock(CYAN_PILLOW, "Cyan Pillow");
        this.addBlock(GRAY_PILLOW, "Gray Pillow");
        this.addBlock(GREEN_PILLOW, "Green Pillow");
        this.addBlock(LIGHT_BLUE_PILLOW, "Light Blue Pillow");
        this.addBlock(LIGHT_GRAY_PILLOW, "Light Gray Pillow");
        this.addBlock(LIME_PILLOW, "Lime Pillow");
        this.addBlock(MAGENTA_PILLOW, "Magenta Pillow");
        this.addBlock(ORANGE_PILLOW, "Orange Pillow");
        this.addBlock(PINK_PILLOW, "Pink Pillow");
        this.addBlock(PURPLE_PILLOW, "Purple Pillow");
        this.addBlock(RED_PILLOW, "Red Pillow");
        this.addBlock(WHITE_PILLOW, "White Pillow");
        this.addBlock(YELLOW_PILLOW, "Yellow Pillow");

        /*
        this.addBlock(BLACK_OAK_STOOL, "Black Oak Stool");
        this.addBlock(BLUE_OAK_STOOL, "Blue Oak Stool");
        this.addBlock(BROWN_OAK_STOOL, "Brown Oak Stool");
        this.addBlock(CYAN_OAK_STOOL, "Cyan Oak Stool");
        this.addBlock(GRAY_OAK_STOOL, "Gray Oak Stool");
        this.addBlock(GREEN_OAK_STOOL, "Green Oak Stool");
        this.addBlock(LIGHT_BLUE_OAK_STOOL, "Light Blue Oak Stool");
        this.addBlock(LIGHT_GRAY_OAK_STOOL, "Light Gray Oak Stool");
        this.addBlock(LIME_OAK_STOOL, "Lime Oak Stool");
        this.addBlock(MAGENTA_OAK_STOOL, "Magenta Oak Stool");
        this.addBlock(ORANGE_OAK_STOOL, "Orange Oak Stool");
        this.addBlock(PINK_OAK_STOOL, "Pink Oak Stool");
        this.addBlock(PURPLE_OAK_STOOL, "Purple Oak Stool");
        this.addBlock(RED_OAK_STOOL, "Red Oak Stool");
        this.addBlock(WHITE_OAK_STOOL, "White Oak Stool");
        this.addBlock(YELLOW_OAK_STOOL, "Yellow Oak Stool");

         */
    }
}
