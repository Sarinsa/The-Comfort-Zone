package com.frenderman.tcz.common.block;

import net.minecraft.world.level.block.Block;

/**
 * The stool has been removed.
 */
public class StoolBlock extends Block {
    public StoolBlock(Properties p_49795_) {
        super(p_49795_);
    } /*

    private static final VoxelShape SHAPE = VoxelShapes.or(
            Block.box(0.0D, 3.0D, 0.0D, 16.0D, 9.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 3.0D, 3.0D, 3.0D),
            Block.box(13.0D, 0.0D, 0.0D, 16.0D, 3.0D, 3.0D),
            Block.box(0.0D, 0.0D, 13.0D, 3.0D, 3.0D, 16.0D),
            Block.box(13.0D, 0.0D, 13.0D, 16.0D, 3.0D, 16.0D)
    );

    public StoolBlock() {
        super(AbstractBlock.Properties.of(Material.WOOD)
                .sound(SoundType.WOOD)
                .strength(0.4F, 0.3F)
                .noOcclusion()
                .harvestTool(ToolType.AXE));
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
            if (!world.isClientSide) {
                RideableDummyEntity entity = new RideableDummyEntity(world, pos.getX() + 0.5D, pos.getY() + (6.0D / 16.D), pos.getZ() + 0.5D);
                world.addFreshEntity(entity);
                playerEntity.startRiding(entity);
            }
            return ActionResultType.sidedSuccess(world.isClientSide);
        }
        return ActionResultType.PASS;
    }

    /**
     * @return True if there are no rideable dummy entities
     *         at the given BlockPos.
     */
    /*
    private boolean canSpawnRideable(World world, BlockPos pos) {
        AxisAlignedBB box = new AxisAlignedBB(pos);
        return world.getEntitiesOfClass(RideableDummyEntity.class, box).isEmpty();
    }

    @Override
    public void fallOn(World world, BlockPos pos, Entity entity, float fallDist) {
        entity.causeFallDamage(fallDist * 0.5F, 1.0F);
    }

    @Override
    public void updateEntityAfterFallOn(IBlockReader world, Entity entity) {
        if (entity.isSuppressingBounce()) {
            super.updateEntityAfterFallOn(world, entity);
        }
        else {
            Vector3d vector3d = entity.getDeltaMovement();

            if (vector3d.y < 0.0D) {
                double bounce = entity instanceof LivingEntity ? 1.0D : 0.8D;
                entity.setDeltaMovement(vector3d.x, -vector3d.y * (double)0.66F * bounce, vector3d.z);
            }
        }
    }


    @Override
    @SuppressWarnings("deprecation")
    public void onRemove(BlockState state, World world, BlockPos pos, BlockState neighbor, boolean p_196243_5_) {
        world.updateNeighbourForOutputSignal(pos, this);
        super.onRemove(state, world, pos, neighbor, p_196243_5_);
    }

    @Override
    public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 30;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return 15;
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean isPathfindable(BlockState state, IBlockReader world, BlockPos pos, PathType pathType) {
        return false;
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    public void onBlockExploded(BlockState state, World world, BlockPos pos, Explosion explosion) {
        super.onBlockExploded(state, world, pos, explosion);

        if (world instanceof ServerWorld) {
            ServerWorld serverWorld = (ServerWorld) world;
            serverWorld.sendParticles(TCZParticles.PILLOW_FEATHER_POOF.get(), pos.getX() + 0.5D, pos.getY() + 0.65D, pos.getZ() + 0.5D, 1, 0, 0, 0, 0);
        }
    }

    @Override
    @SuppressWarnings("deprecation")
    public int getAnalogOutputSignal(BlockState state, World world, BlockPos pos) {
        List<RideableDummyEntity> entities = world.getEntitiesOfClass(RideableDummyEntity.class, new AxisAlignedBB(pos));

        if (!entities.isEmpty()) {
            for (RideableDummyEntity dummyEntity : entities) {
                if (!dummyEntity.getPassengers().isEmpty()) {
                    return 1;
                }
            }
        }
        return 0;
    }

     */
}
