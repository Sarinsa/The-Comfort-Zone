package com.frenderman.tcz.datagen;

import com.frenderman.tcz.common.core.TheComfortZone;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

import static com.frenderman.tcz.common.core.register.TCZBlocks.*;
import static com.frenderman.tcz.common.core.register.TCZBlocks.YELLOW_PILLOW;

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
    }
}
