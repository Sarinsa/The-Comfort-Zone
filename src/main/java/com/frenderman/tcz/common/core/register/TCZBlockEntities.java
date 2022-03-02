package com.frenderman.tcz.common.core.register;

import com.frenderman.tcz.common.core.TheComfortZone;
import com.frenderman.tcz.common.tile.TableBlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Arrays;
import java.util.List;

public class TCZBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, TheComfortZone.MODID);


    public static final RegistryObject<BlockEntityType<TableBlockEntity>> TABLE = register("table", TableBlockEntity::new, Arrays.asList(TCZBlocks.OAK_TABLE.get()));


    private static <T extends BlockEntity> RegistryObject<BlockEntityType<T>> register(String name, BlockEntityType.BlockEntitySupplier<T> blockEntitySupplier, List<Block> validBlocks) {
        return TILE_ENTITIES.register(name, () -> BlockEntityType.Builder.of(blockEntitySupplier, validBlocks.toArray(new Block[]{})).build(null));
    }
}
