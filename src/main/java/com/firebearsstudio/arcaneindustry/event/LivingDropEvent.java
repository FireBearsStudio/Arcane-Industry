package com.firebearsstudio.arcaneindustry.event;

import java.util.Random;

import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityEndermite;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityGuardian;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.firebearsstudio.arcaneindustry.items.ArcaneItems;

public class LivingDropEvent {

	public static double rand;
	
	@SubscribeEvent
	public void onDrop(LivingDropsEvent event) {
		// you can also check the random chance here, rather than every time,
		// since you use the exact same probability for all your cases
		if (event.source.getDamageType().equals("player") && event.entity.worldObj.rand.nextFloat() < 1.00F) {
			if (event.entity instanceof EntityZombie) {
				if (event.entity.worldObj.rand.nextInt(100) < 10) {
					event.entityLiving.dropItem(ArcaneItems.lifeCrystal, 1);
				}
			} else if (event.entity instanceof EntitySkeleton) {
				if (event.entity.worldObj.rand.nextInt(100) < 10) {
					event.entityLiving.dropItem(ArcaneItems.lifeCrystal, 1);
				}
			} else if (event.entity instanceof EntityCreeper) {
				if (event.entity.worldObj.rand.nextInt(100) < 10) {
					event.entityLiving.dropItem(ArcaneItems.lifeCrystal, 1);
				}
			} else if (event.entity instanceof EntityEnderman) {
				if (event.entity.worldObj.rand.nextInt(100) < 10) {
					event.entityLiving.dropItem(ArcaneItems.lifeCrystal, 1);
				}
			} else if (event.entity instanceof EntityEndermite) {
				if (event.entity.worldObj.rand.nextInt(100) < 10) {
					event.entityLiving.dropItem(ArcaneItems.lifeCrystal, 1);
				}
			} else if (event.entity instanceof EntitySilverfish) {
				if (event.entity.worldObj.rand.nextInt(100) < 10) {
					event.entityLiving.dropItem(ArcaneItems.lifeCrystal, 1);
				}
			} else if (event.entity instanceof EntityGuardian) {
				if (event.entity.worldObj.rand.nextInt(100) < 10) {
					event.entityLiving.dropItem(ArcaneItems.lifeCrystal, 1);
				}
			} else if (event.entity instanceof EntityCow) {
				if (event.entity.worldObj.rand.nextInt(100) < 5) {
					event.entityLiving.dropItem(ArcaneItems.lifeCrystal, 1);
				}
			} else if (event.entity instanceof EntitySheep) {
				if (event.entity.worldObj.rand.nextInt(100) < 5) {
					event.entityLiving.dropItem(ArcaneItems.lifeCrystal, 1);
				}
			} else if (event.entity instanceof EntityChicken) {
				if (event.entity.worldObj.rand.nextInt(100) < 5) {
					event.entityLiving.dropItem(ArcaneItems.lifeCrystal, 1);
				}
			} else if (event.entity instanceof EntityMooshroom) {
				if (event.entity.worldObj.rand.nextInt(100) < 5) {
					event.entityLiving.dropItem(ArcaneItems.lifeCrystal, 1);
				}
			} else if (event.entity instanceof EntityPig) {
				if (event.entity.worldObj.rand.nextInt(100) < 5) {
					event.entityLiving.dropItem(ArcaneItems.lifeCrystal, 1);
				}
			} else if (event.entity instanceof EntityPigZombie) {
				if (event.entity.worldObj.rand.nextInt(100) < 7) {
					event.entityLiving.dropItem(ArcaneItems.lifeCrystal, 1);
				}
			} else if (event.entity instanceof EntityGhast) {
				if (event.entity.worldObj.rand.nextInt(100) < 10) {
					event.entityLiving.dropItem(ArcaneItems.lifeCrystal, 1);
				}
			} else if (event.entity instanceof EntityBlaze) {
				if (event.entity.worldObj.rand.nextInt(100) < 10) {
					event.entityLiving.dropItem(ArcaneItems.lifeCrystal, 1);
				}
			}
		}
	}
}
