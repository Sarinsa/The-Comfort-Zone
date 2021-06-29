package com.frenderman.tcz.common.event;

import com.frenderman.tcz.common.misc.ai.CatLieOnPillowGoal;
import net.minecraft.entity.passive.CatEntity;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EntityEvents {

    @SubscribeEvent
    public void onEntityJoinWorld(EntityJoinWorldEvent event) {
        if (event.getEntity() instanceof CatEntity) {
            CatEntity cat = (CatEntity) event.getEntity();
            cat.goalSelector.addGoal(7, new CatLieOnPillowGoal<>(cat, 1.1D, 8));
        }
    }
}
