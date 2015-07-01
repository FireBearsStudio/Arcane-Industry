package com.firebearsstudio.arcaneindustry.event;

import com.firebearsstudio.arcaneindustry.items.ArcaneItems;

import net.minecraft.entity.monster.EntityZombie;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class LivingDropEvent {

	public static double rand;
	
	@SubscribeEvent
	public void onDrop(LivingDropsEvent event) {
		// you can also check the random chance here, rather than every time,
		// since you use the exact same probability for all your cases
		if (event.source.getDamageType().equals("player") && event.entity.worldObj.rand.nextFloat() < 1.00F) {
			if (event.entity instanceof EntityZombie) {
				event.entityLiving.dropItem(ArcaneItems.lifeCrystal, 1);
			}
		}
	}
}
