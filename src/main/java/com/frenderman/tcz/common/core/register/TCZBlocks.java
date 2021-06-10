package com.frenderman.tcz.common.core.register;

import com.frenderman.tcz.common.block.PillowBlock;
import com.frenderman.tcz.common.core.TheComfortZone;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class TCZBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TheComfortZone.MODID);

    public static final RegistryObject<Block> BLACK_PILLOW = registerPillow("black_pillow");
    public static final RegistryObject<Block> BLUE_PILLOW = registerPillow("blue_pillow");
    public static final RegistryObject<Block> BROWN_PILLOW = registerPillow("brown_pillow");
    public static final RegistryObject<Block> CYAN_PILLOW = registerPillow("cyan_pillow");
    public static final RegistryObject<Block> GRAY_PILLOW = registerPillow("gray_pillow");
    public static final RegistryObject<Block> GREEN_PILLOW = registerPillow("green_pillow");
    public static final RegistryObject<Block> LIGHT_BLUE_PILLOW = registerPillow("light_blue_pillow");
    public static final RegistryObject<Block> LIGHT_GRAY_PILLOW = registerPillow("light_gray_pillow");
    public static final RegistryObject<Block> LIME_PILLOW = registerPillow("lime_pillow");
    public static final RegistryObject<Block> MAGENTA_PILLOW = registerPillow("magenta_pillow");
    public static final RegistryObject<Block> ORANGE_PILLOW = registerPillow("orange_pillow");
    public static final RegistryObject<Block> PINK_PILLOW = registerPillow("pink_pillow");
    public static final RegistryObject<Block> PURPLE_PILLOW = registerPillow("purple_pillow");
    public static final RegistryObject<Block> RED_PILLOW = registerPillow("red_pillow");
    public static final RegistryObject<Block> WHITE_PILLOW = registerPillow("white_pillow");
    public static final RegistryObject<Block> YELLOW_PILLOW = registerPillow("yellow_pillow");


    private static RegistryObject<Block> registerPillow(String name) {
        return registerBlock(name, PillowBlock::new, ItemGroup.TAB_DECORATIONS);
    }

    private static RegistryObject<Block> registerBlock(String name, Supplier<Block> blockSupplier, ItemGroup itemGroup) {
        RegistryObject<Block> block = BLOCKS.register(name, blockSupplier);
        TCZItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup)));
        return block;
    }
}
