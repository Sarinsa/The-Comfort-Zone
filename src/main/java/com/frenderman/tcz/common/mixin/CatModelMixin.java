package com.frenderman.tcz.common.mixin;

import com.frenderman.tcz.common.misc.mixin_hooks.ClientMixinHooks;
import net.minecraft.client.model.CatModel;
import net.minecraft.client.model.OcelotModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.animal.Cat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;


// UNUSED
//@Mixin(CatModel.class)
public abstract class CatModelMixin <T extends Cat> extends OcelotModel<T> {

    public CatModelMixin(ModelPart root) {
        super(root);
    }

    //@Redirect(method = "prepareMobModel(Lnet/minecraft/world/entity/animal/Cat;FFF)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/animal/Cat;isInSittingPose()Z", ordinal = 0))
    /*
    public boolean redirectPrepareMobModel(Cat instance) {
        return ClientMixinHooks.isCatSitting(instance);
    }

     */
}
