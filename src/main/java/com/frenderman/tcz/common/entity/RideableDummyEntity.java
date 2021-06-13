package com.frenderman.tcz.common.entity;

import com.frenderman.tcz.common.core.register.TCZEntities;
import com.frenderman.tcz.common.tag.TCZBlockTags;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class RideableDummyEntity extends Entity {

    private Entity passenger;

    public RideableDummyEntity(EntityType<?> entityType, World world) {
        super(entityType, world);
    }

    public RideableDummyEntity(World world, double x, double y, double z, PlayerEntity playerEntity) {
        this(TCZEntities.RIDEABLE_DUMMY_ENTITY.get(), world);
        this.setPos(x, y, z);
        playerEntity.startRiding(this);
        this.blocksBuilding = false;
    }

    private void setPassenger(Entity passenger) {
        this.passenger = passenger;
    }

    private Entity getPassenger() {
        return this.passenger;
    }

    @Override
    public void tick() {
        /*
        if (this.firstTick) {
            if (this.getPassenger() != null) {
                this.getPassenger().startRiding(this);
            }
        }
        */
        super.tick();

        if (this.getPassengers().isEmpty() || !this.validPosition()) {
            this.remove();
        }
    }

    @Override
    public double getPassengersRidingOffset() {
        return -0.25D;
    }

    private boolean validPosition() {
        return this.level.getBlockState(this.blockPosition()).is(TCZBlockTags.PILLOWS);
    }

    @Override
    protected void defineSynchedData() {

    }

    @Override
    protected void readAdditionalSaveData(CompoundNBT compoundNBT) {

    }

    @Override
    protected void addAdditionalSaveData(CompoundNBT compoundNBT) {

    }

    @Override
    public IPacket<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    /*
    @Override
    public void writeSpawnData(PacketBuffer buffer) {
        buffer.writeInt(this.getPassenger() == null ? this.getId() : this.getPassenger().getId());
    }

    @Override
    public void readSpawnData(PacketBuffer additionalData) {
        Entity passenger = this.level.getEntity(additionalData.readInt());

        if (passenger != null && passenger != this) {
            this.setPassenger(passenger);
        }
    }

     */
}
