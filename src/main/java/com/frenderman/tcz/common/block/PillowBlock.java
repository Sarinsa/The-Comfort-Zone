package com.frenderman.tcz.common.block;

import com.frenderman.tcz.common.core.register.TCZParticles;
import com.frenderman.tcz.common.entity.RideableDummyEntity;
import com.frenderman.tcz.common.particle.PillowFeatherParticleData;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.List;

public class PillowBlock extends Block {

    private static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 9.0D, 16.0D);

    public PillowBlock() {
        super(BlockBehaviour.Properties.of(Material.WOOL)
                .sound(SoundType.WOOL)
                .strength(0.4F, 0.1F));
    }

    public PillowBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    @SuppressWarnings("deprecation")
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    @SuppressWarnings("deprecation")
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (!player.isPassenger() && !player.isCrouching() && level.isEmptyBlock(pos.above()) && this.canSpawnRideable(level, pos)) {
            if (!level.isClientSide) {
                RideableDummyEntity entity = new RideableDummyEntity(level, pos.getX() + 0.5D, pos.getY() + (6.0D / 16.D), pos.getZ() + 0.5D);
                level.addFreshEntity(entity);
                player.startRiding(entity);
            }
            return InteractionResult.sidedSuccess(level.isClientSide);
        }
        return InteractionResult.PASS;
    }

    /**
     * @return True if there are no rideable dummy entities
     *         at the given BlockPos.
     */
    private boolean canSpawnRideable(Level level, BlockPos pos) {
        return level.getEntitiesOfClass(RideableDummyEntity.class, new AABB(pos)).isEmpty();
    }

    @Override
    public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        if (entity.isSuppressingBounce()) {
            super.fallOn(level, state, pos, entity, fallDistance);
        }
        else {
            entity.causeFallDamage(fallDistance, 0.0F, DamageSource.FALL);
        }

        if (fallDistance > 8.0F) {
            if (!level.isClientSide) {
                ServerLevel serverLevel = (ServerLevel) level;
                serverLevel.sendParticles(new PillowFeatherParticleData(fallDistance), pos.getX() + 0.5D, pos.getY() + 0.65D, pos.getZ() + 0.5D, 1, 0, 0, 0, 0);
            }
        }
    }

    @Override
    public void updateEntityAfterFallOn(BlockGetter level, Entity entity) {
        if (entity.isSuppressingBounce()) {
            super.updateEntityAfterFallOn(level, entity);
        }
        else {
            Vec3 velocity = entity.getDeltaMovement();

            if (velocity.y < 0.0D) {
                double yMul = entity instanceof LivingEntity ? 1.0D : 0.8D;
                entity.setDeltaMovement(velocity.x, -velocity.y * (double)0.66F * yMul, velocity.z);
            }
        }
    }

    @Override
    @SuppressWarnings("deprecation")
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState neighbor, boolean p_196243_5_) {
        level.updateNeighbourForOutputSignal(pos, this);
        super.onRemove(state, level, pos, neighbor, p_196243_5_);
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction face) {
        return 60;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction face) {
        return 30;
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean isPathfindable(BlockState state, BlockGetter level, BlockPos pos, PathComputationType pathType) {
        return false;
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    @Override
    public void onBlockExploded(BlockState state, Level level, BlockPos pos, Explosion explosion) {
        super.onBlockExploded(state, level, pos, explosion);

        if (level instanceof ServerLevel serverLevel) {
            serverLevel.sendParticles(TCZParticles.PILLOW_FEATHER_POOF.get(), pos.getX() + 0.5D, pos.getY() + 0.65D, pos.getZ() + 0.5D, 1, 0, 0, 0, 0);
        }
    }

    @Override
    @SuppressWarnings("deprecation")
    public int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos) {
        List<RideableDummyEntity> entities = level.getEntitiesOfClass(RideableDummyEntity.class, new AABB(pos));

        if (!entities.isEmpty()) {
            for (RideableDummyEntity dummyEntity : entities) {
                if (!dummyEntity.getPassengers().isEmpty()) {
                    return 1;
                }
            }
        }
        return 0;
    }
}
