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
        this.setFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
    }

    private boolean isFarAwayFromOwner(T cat) {
        Entity owner = cat.getOwner();
        return owner != null && this.cat.distanceToSqr(owner) > 100.0D;
    }

    @Override
    public boolean canUse() {
        return this.cat.isTame() && !this.cat.isLying() && !this.isFarAwayFromOwner(this.cat) && super.canUse();
    }

    @Override
    public void start() {
        super.start();
        this.cat.setInSittingPose(false);
    }

    @Override
    protected int nextStartTick(PathfinderMob mob) {
        return 40;
    }

    @Override
    public void stop() {
        super.stop();
        this.cat.setLying(false);
    }

    @Override
    public void tick() {
        super.tick();

        this.cat.setInSittingPose(false);

        if (!this.isReachedTarget() || this.isFarAwayFromOwner(this.cat)) {
            this.cat.setLying(false);
        }
        else if (!this.cat.isLying()) {
            this.cat.setLying(true);
        }
    }

    @Override
    protected boolean isValidTarget(LevelReader levelReader, BlockPos pos) {
        if (levelReader instanceof Level level) {
            boolean unoccupied = level.getEntities(this.cat, new AABB(pos)).isEmpty();
            return level.isEmptyBlock(pos.above()) && level.getBlockState(pos).is(TCZBlockTags.PILLOWS) && unoccupied;
        }
        return false;
    }
}
