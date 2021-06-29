package com.frenderman.tcz.common.misc.ai;

import com.frenderman.tcz.common.tag.TCZBlockTags;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

import java.util.EnumSet;

public class CatLieOnPillowGoal<T extends CatEntity> extends MoveToBlockGoal {

    private final T cat;

    public CatLieOnPillowGoal(T cat, double speed, int searchRange) {
        super(cat, speed, searchRange, 6);
        this.cat = cat;
        this.setFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
    }

    public boolean canUse() {
        return this.cat.isTame() && !this.cat.isOrderedToSit() && !this.cat.isLying() && !this.isFarAwayFromOwner(this.cat) && super.canUse();
    }

    public void start() {
        super.start();
        this.cat.setInSittingPose(false);
    }

    private boolean isFarAwayFromOwner(T cat) {
        Entity owner = cat.getOwner();
        return owner != null && this.cat.distanceToSqr(owner) > 100.0D;
    }

    protected int nextStartTick(CreatureEntity creatureEntity) {
        return 40;
    }

    public void stop() {
        super.stop();
        this.cat.setLying(false);
    }

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

    protected boolean isValidTarget(IWorldReader worldReader, BlockPos pos) {
        if (worldReader instanceof World) {
            World world = (World) worldReader;

            boolean unoccupied = world.getEntities(this.cat, new AxisAlignedBB(pos)).isEmpty();
            return world.isEmptyBlock(pos.above()) && world.getBlockState(pos).getBlock().is(TCZBlockTags.PILLOWS) && unoccupied;
        }
        return false;
    }
}
