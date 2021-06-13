package com.frenderman.tcz.common.block;

import com.frenderman.tcz.common.entity.RideableDummyEntity;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.pathfinding.PathType;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class PillowBlock extends Block {

    private static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 9.0D, 16.0D);

    public PillowBlock() {
        super(AbstractBlock.Properties.of(Material.WOOL).sound(SoundType.WOOL).strength(0.4F, 0.1F));
    }

    @Override
    @SuppressWarnings("deprecation")
    public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext selectionContext) {
        return SHAPE;
    }

    @Override
    @SuppressWarnings("deprecation")
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity playerEntity, Hand hand, BlockRayTraceResult result) {
        if (!playerEntity.isPassenger() && !playerEntity.isCrouching() && world.isEmptyBlock(pos.above()) && this.canSpawnRideable(world, pos)) {
            RideableDummyEntity entity = new RideableDummyEntity(world, pos.getX() + 0.5D, pos.getY() + (9.0D / 16.D), pos.getZ() + 0.5D, playerEntity);
            world.addFreshEntity(entity);
            return ActionResultType.sidedSuccess(world.isClientSide);
        }
        return ActionResultType.PASS;
    }

    /**
     * @return True if there are no rideable dummy entities
     *         at the given BlockPos.
     */
    private boolean canSpawnRideable(World world, BlockPos pos) {
        AxisAlignedBB box = new AxisAlignedBB(pos);
        return world.getEntitiesOfClass(RideableDummyEntity.class, box).isEmpty();
    }

    @Override
    public void fallOn(World world, BlockPos pos, Entity entity, float fallDistance) {
        if (entity.isSuppressingBounce()) {
            super.fallOn(world, pos, entity, fallDistance);
        }
        else {
            entity.causeFallDamage(fallDistance, 0.0F);
        }
    }

    @Override
    public void updateEntityAfterFallOn(IBlockReader world, Entity entity) {
        if (entity.isSuppressingBounce()) {
            super.updateEntityAfterFallOn(world, entity);
        }
        else {
            Vector3d velocity = entity.getDeltaMovement();

            if (velocity.y < 0.0D) {
                double yMul = entity instanceof LivingEntity ? 1.0D : 0.8D;
                entity.setDeltaMovement(velocity.x, -velocity.y * (double)0.66F * yMul, velocity.z);
            }
        }
    }

    @Override
    public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 60;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 30;
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean isPathfindable(BlockState state, IBlockReader world, BlockPos pos, PathType pathType) {
        return false;
    }
}
