package com.frenderman.tcz.common.event;

import com.frenderman.tcz.common.item.PillowBlockItem;
import com.frenderman.tcz.common.misc.ai.CatLieOnPillowGoal;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Cat;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EntityEvents {

    @SubscribeEvent
    public void onEntityJoinWorld(EntityJoinWorldEvent event) {
        if (event.getEntity() instanceof Cat cat) {
            cat.goalSelector.addGoal(7, new CatLieOnPillowGoal<>(cat, 1.1D, 8));
        }
    }

    @SubscribeEvent
    public void onLivingDamage(LivingDamageEvent event) {
        if (event.getSource().getEntity() instanceof LivingEntity livingEntity) {
            if (livingEntity.getItemInHand(InteractionHand.MAIN_HAND).getItem() instanceof PillowBlockItem) {
                event.setAmount(0.001F);
            }
        }
    }
}
