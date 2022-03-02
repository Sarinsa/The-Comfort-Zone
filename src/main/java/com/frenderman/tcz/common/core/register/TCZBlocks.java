package com.frenderman.tcz.common.core.register;

import com.frenderman.tcz.common.block.PillowBlock;
import com.frenderman.tcz.common.block.TableBlock;
import com.frenderman.tcz.common.core.TheComfortZone;
import com.frenderman.tcz.common.item.PillowBlockItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

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

    /*
    public static final RegistryObject<Block> BLACK_OAK_STOOL = registerStool("black_oak_stool");
    public static final RegistryObject<Block> BLUE_OAK_STOOL= registerStool("blue_oak_stool");
    public static final RegistryObject<Block> BROWN_OAK_STOOL = registerStool("brown_oak_stool");
    public static final RegistryObject<Block> CYAN_OAK_STOOL = registerStool("cyan_oak_stool");
    public static final RegistryObject<Block> GRAY_OAK_STOOL = registerStool("gray_oak_stool");
    public static final RegistryObject<Block> GREEN_OAK_STOOL = registerStool("green_oak_stool");
    public static final RegistryObject<Block> LIGHT_BLUE_OAK_STOOL = registerStool("light_blue_oak_stool");
    public static final RegistryObject<Block> LIGHT_GRAY_OAK_STOOL = registerStool("light_gray_oak_stool");
    public static final RegistryObject<Block> LIME_OAK_STOOL = registerStool("lime_oak_stool");
    public static final RegistryObject<Block> MAGENTA_OAK_STOOL = registerStool("magenta_oak_stool");
    public static final RegistryObject<Block> ORANGE_OAK_STOOL = registerStool("orange_oak_stool");
    public static final RegistryObject<Block> PINK_OAK_STOOL = registerStool("pink_oak_stool");
    public static final RegistryObject<Block> PURPLE_OAK_STOOL = registerStool("purple_oak_stool");
    public static final RegistryObject<Block> RED_OAK_STOOL = registerStool("red_oak_stool");
    public static final RegistryObject<Block> WHITE_OAK_STOOL = registerStool("white_oak_stool");
    public static final RegistryObject<Block> YELLOW_OAK_STOOL = registerStool("yellow_oak_stool");

     */

    public static final RegistryObject<TableBlock> OAK_TABLE = registerTable("oak_table");


    private static RegistryObject<Block> registerPillow(String name) {
        RegistryObject<Block> block = BLOCKS.register(name, PillowBlock::new);
        TCZItems.ITEMS.register(name, () -> new PillowBlockItem(block.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
        return block;
    }

    /*
    private static RegistryObject<Block> registerStool(String name) {
        return registerBlock(name, StoolBlock::new, CreativeModeTab.TAB_DECORATIONS);
    }
    */

    private static RegistryObject<TableBlock> registerTable(String name) {
        return registerBlock(name, TableBlock::new, null);
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> blockSupplier, CreativeModeTab creativeTab) {
        RegistryObject<T> block = BLOCKS.register(name, blockSupplier);
        TCZItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(creativeTab)));
        return block;
    }
}
