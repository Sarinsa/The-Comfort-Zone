package com.frenderman.tcz.common.misc.ai;

import com.frenderman.tcz.common.tag.TCZBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.phys.AABB;

import java.util.EnumSet;

public class CatLieOnPillowGoal<T extends Cat> extends MoveToBlockGoal {

    private final T cat;

    public CatLieOnPillowGoal(T cat, double speed, int searchRange) {
        super(cat, speed, searchRange, 6);
        this.cat = cat;
        setFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
    }

    private boolean isFarAwayFromOwner(T cat) {
        Entity owner = cat.getOwner();
        return owner != null && cat.distanceToSqr(owner) > 100.0D;
    }

    @Override
    public boolean canUse() {
        return cat.isTame() && !cat.isLying() && !isFarAwayFromOwner( cat) && super.canUse();
    }

    @Override
    public void start() {
        super.start();
        cat.setInSittingPose(false);
    }

    @Override
    protected int nextStartTick(PathfinderMob mob) {
        return 40;
    }

    @Override
    public void stop() {
        super.stop();
        cat.setLying(false);
    }

    @Override
    public void tick() {
        super.tick();

        cat.setInSittingPose(false);

        if (!isReachedTarget() || isFarAwayFromOwner(cat)) {
            cat.setLying(false);
        }
        else if (!cat.isLying()) {
            cat.setLying(true);
        }
    }

    @Override
    protected boolean isValidTarget(LevelReader levelReader, BlockPos pos) {
        if (levelReader instanceof Level level) {
            boolean unoccupied = level.getEntities(cat, new AABB(pos)).isEmpty();
            return level.isEmptyBlock(pos.above()) && level.getBlockState(pos).is(TCZBlockTags.PILLOWS) && unoccupied;
        }
        return false;
    }
}