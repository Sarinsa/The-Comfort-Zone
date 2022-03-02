package com.frenderman.tcz.common.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

import java.util.UUID;

public class PillowBlockItem extends BlockItem {

    public static final UUID TCZ_KNOCKBACK_UUID = UUID.fromString("A8DD90F2-C124-4661-A23B-BfA5C3C22C2B");

    private final Multimap<Attribute, AttributeModifier> defaultModifiers;

    public PillowBlockItem(Block block, Properties properties) {
        super(block, properties);
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_KNOCKBACK, new AttributeModifier(TCZ_KNOCKBACK_UUID, "Pillow modifier", 5.0D, AttributeModifier.Operation.ADDITION));
        this.defaultModifiers = builder.build();
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        return slot == EquipmentSlot.MAINHAND ? this.defaultModifiers : super.getAttributeModifiers(slot, stack);
    }
}
