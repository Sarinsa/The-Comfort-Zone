package com.frenderman.tcz.common.core.register;

import com.frenderman.tcz.common.core.TheComfortZone;
import com.frenderman.tcz.common.tile.TableBlockEntity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class TCZBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, TheComfortZone.MODID);


    public static final RegistryObject<BlockEntityType<TableBlockEntity>> TABLE = register("table", TableBlockEntity::new, () -> List.of(TCZBlocks.OAK_TABLE.get()));


    private static <T extends BlockEntity> RegistryObject<BlockEntityType<T>> register(String name, BlockEntityType.BlockEntitySupplier<T> blockEntitySupplier, Supplier<List<Block>> validBlocks) {
        return BLOCK_ENTITIES.register(name, () -> BlockEntityType.Builder.of(blockEntitySupplier, validBlocks.get().toArray(new Block[]{})).build(null));
    }
}
