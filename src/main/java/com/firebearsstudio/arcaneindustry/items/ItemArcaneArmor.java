package com.firebearsstudio.arcaneindustry.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemArcaneArmor extends ItemArmor {

	public ItemArcaneArmor(String unlocalizedName, ArmorMaterial material, int renderIndex, int armorType) {
		super(material, renderIndex, armorType);
		
		this.setUnlocalizedName(unlocalizedName);
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
		if(itemStack.getItem() == ArcaneItems.arcaneHelmet) {
			effectPlayer(player, Potion.waterBreathing, 0);
		}
		if(itemStack.getItem() == ArcaneItems.arcaneChestplate) {
			effectPlayer(player, Potion.absorption, 0);
		}
		if(itemStack.getItem() == ArcaneItems.arcaneLeggings) {
			effectPlayer(player, Potion.jump, 10000);
		}
		if(itemStack.getItem() == ArcaneItems.arcaneBoots) {
			effectPlayer(player, Potion.moveSpeed, 0);
		}
		if(player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(3).getItem() == ArcaneItems.arcaneHelmet
				&& player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem() == ArcaneItems.arcaneChestplate
				&& player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(1).getItem() == ArcaneItems.arcaneLeggings
				&& player.inventory.armorItemInSlot(0) != null && player.inventory.armorItemInSlot(0).getItem() == ArcaneItems.arcaneBoots) {
			this.effectPlayer(player, Potion.regeneration, 1);
		}
	}
	
	private void effectPlayer(EntityPlayer player, Potion potion, int amplifier) {
		// Always affect for 8 seconds, then refresh
		if(player.getActivePotionEffect(potion) == null || player.getActivePotionEffect(potion).getDuration() <= 1) {
			player.addPotionEffect(new PotionEffect(potion.id, 159, amplifier, true, true));
		}
	}
}
