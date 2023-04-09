package com.frenderman.tcz.common.core.register;

import com.frenderman.tcz.common.core.TheComfortZone;
import com.frenderman.tcz.common.entity.RideableDummyEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TCZEntities {

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TheComfortZone.MODID);


    public static final RegistryObject<EntityType<RideableDummyEntity>> RIDEABLE_DUMMY_ENTITY = register("rideable_dummy", EntityType.Builder.<RideableDummyEntity>of(RideableDummyEntity::new, MobCategory.MISC).sized(0.4F, 0.1F).noSummon().setShouldReceiveVelocityUpdates(false));


    private static <T extends Entity> RegistryObject<EntityType<T>> register(String name, EntityType.Builder<T> builder) {
        return ENTITIES.register(name, () -> builder.build(name));
    }
}
