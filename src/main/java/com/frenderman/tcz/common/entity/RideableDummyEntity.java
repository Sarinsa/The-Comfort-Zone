package com.frenderman.tcz.common.entity;

import com.frenderman.tcz.common.core.register.TCZEntities;
import com.frenderman.tcz.common.tag.TCZBlockTags;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;

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
    private boolean dismounted;

    private double yDismountOffset;

    public RideableDummyEntity(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    public RideableDummyEntity(Level level, double x, double y, double z) {
        this(level, x, y, z, 0.45D);
    }

    public RideableDummyEntity(Level level, double x, double y, double z, double yDismountOffset) {
        this(TCZEntities.RIDEABLE_DUMMY_ENTITY.get(), level);
        this.setPos(x, y, z);
        this.blocksBuilding = false;
        this.dismounted = false;
        this.gracePeriod = 10;
        this.yDismountOffset = yDismountOffset;
    }

    @Override
    public void tick() {
        super.tick();

        if (!this.level.isClientSide) {
            if ((this.getPassengers().isEmpty() && this.gracePeriod <= 0) || !this.validPosition() || this.dismounted) {
                this.discard();
            }
        }
    }

    @Override
    public double getPassengersRidingOffset() {
        return -0.125D;
    }

    @Override
    public Vec3 getDismountLocationForPassenger(LivingEntity livingEntity) {
        return new Vec3(this.getX(), this.getBoundingBox().maxY + this.yDismountOffset, this.getZ());
    }

    private boolean validPosition() {
        return this.level.getBlockState(this.blockPosition()).is(TCZBlockTags.SITTABLES);
    }

    @Override
    protected void defineSynchedData() {

    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {

    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {

    }

    @Override
    protected void removePassenger(Entity entity) {
        super.removePassenger(entity);
        this.updateNeighbour();
        this.dismounted = true;
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
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
