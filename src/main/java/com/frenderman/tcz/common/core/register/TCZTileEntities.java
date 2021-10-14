package com.frenderman.tcz.common.core.register;

import com.frenderman.tcz.common.core.TheComfortZone;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.function.Supplier;

public class TCZTileEntities {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, TheComfortZone.MODID);


    //public static final RegistryObject<TileEntityType<TableTileEntity>> TABLE = register("table", TableTileEntity::new, Arrays.asList(TCZBlocks.OAK_TABLE.get()));


    private static <T extends TileEntity> RegistryObject<TileEntityType<T>> register(String name, Supplier<T> tileEntitySupplier, List<Block> validBlocks) {
        return TILE_ENTITIES.register(name, () -> TileEntityType.Builder.of(tileEntitySupplier, validBlocks.toArray(new Block[]{})).build(null));
    }
}
