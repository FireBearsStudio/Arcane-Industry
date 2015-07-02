package com.firebearsstudio.arcaneindustry.mob;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.world.World;

public class EntitySalamanderMob extends EntityAnimal {

	public EntitySalamanderMob(World worldIn) {
		super(worldIn);
		this.setSize(0.8F, 0.2F);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIWander(this, 0.5D));
		this.tasks.addTask(2, new EntityAIPanic(this, 1.25D));
		this.ridingEntity = null;
		this.riddenByEntity = null;
	}

	public boolean isAIEnabled() {
		return true;
	}
	
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0F);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5D);
	}

	public boolean canBeRidden() {
		return false;
	}
	
	@Override
	public EntityAgeable createChild(EntityAgeable ageable) {
		return null;
	}
}
