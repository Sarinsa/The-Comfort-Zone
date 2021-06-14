package com.frenderman.tcz.common.entity;

import com.frenderman.tcz.common.core.register.TCZEntities;
import com.frenderman.tcz.common.tag.TCZBlockTags;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class RideableDummyEntity extends Entity {

    /**
     * The minimum amount of time this entity
     * can exist without a passenger (in ticks).
     */
    private int gracePeriod;
    /**
     * Used to mark that a passenger has dismounted
     * and that this entity should be removed.
     */
    private boolean shouldBeRemoved;

    public RideableDummyEntity(EntityType<?> entityType, World world) {
        super(entityType, world);
    }

    public RideableDummyEntity(World world, double x, double y, double z) {
        this(TCZEntities.RIDEABLE_DUMMY_ENTITY.get(), world);
        this.setPos(x, y, z);
        this.blocksBuilding = false;
        this.shouldBeRemoved = false;
        this.gracePeriod = 10;
    }

    @Override
    public void tick() {
        super.tick();

        if (!this.level.isClientSide) {
            if ((this.getPassengers().isEmpty() && this.gracePeriod <= 0) || !this.validPosition() || this.shouldBeRemoved) {
                this.remove();
            }
        }
    }

    @Override
    public double getPassengersRidingOffset() {
        return -0.125D;
    }

    @Override
    public Vector3d getDismountLocationForPassenger(LivingEntity livingEntity) {
        return new Vector3d(this.getX(), this.getBoundingBox().maxY + 0.45D, this.getZ());
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
    protected void removePassenger(Entity entity) {
        super.removePassenger(entity);
        this.updateNeighbour();
        this.shouldBeRemoved = true;
    }

    @Override
    protected void addPassenger(Entity entity) {
        super.addPassenger(entity);
        this.updateNeighbour();
    }

    private void updateNeighbour() {
        this.level.updateNeighbourForOutputSignal(this.blockPosition(), this.level.getBlockState(this.blockPosition()).getBlock());
    }

    @Override
    public IPacket<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
