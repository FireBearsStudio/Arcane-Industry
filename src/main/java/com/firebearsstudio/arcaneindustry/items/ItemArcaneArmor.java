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
		// green gem armor
		if(itemStack.getItem() == ArcaneItems.greenGemHelmet) {
			effectPlayer(player, Potion.waterBreathing, 0);
		}
		if(itemStack.getItem() == ArcaneItems.greenGemChestplate) {
			effectPlayer(player, Potion.absorption, 0);
		}
		if(itemStack.getItem() == ArcaneItems.greenGemLeggings) {
			effectPlayer(player, Potion.jump, 0);
		}
		if(itemStack.getItem() == ArcaneItems.greenGemBoots) {
			effectPlayer(player, Potion.moveSpeed, 0);
		}
		if(player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(3).getItem() == ArcaneItems.greenGemHelmet
				&& player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem() == ArcaneItems.greenGemChestplate
				&& player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(1).getItem() == ArcaneItems.greenGemLeggings
				&& player.inventory.armorItemInSlot(0) != null && player.inventory.armorItemInSlot(0).getItem() == ArcaneItems.greenGemLeggings) {
			this.effectPlayer(player, Potion.regeneration, 1);
		}
		
		// red gem armor
		if(itemStack.getItem() == ArcaneItems.redGemHelmet) {
			effectPlayer(player, Potion.waterBreathing, 1);
		}
		if(itemStack.getItem() == ArcaneItems.redGemChestplate) {
			effectPlayer(player, Potion.absorption, 1);
		}
		if(itemStack.getItem() == ArcaneItems.redGemLeggings) {
			effectPlayer(player, Potion.jump, 1);
		}
		if(itemStack.getItem() == ArcaneItems.redGemBoots) {
			effectPlayer(player, Potion.moveSpeed, 1);
		}
		if(player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(3).getItem() == ArcaneItems.redGemHelmet
				&& player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem() == ArcaneItems.redGemChestplate
				&& player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(1).getItem() == ArcaneItems.redGemLeggings
				&& player.inventory.armorItemInSlot(0) != null && player.inventory.armorItemInSlot(0).getItem() == ArcaneItems.redGemLeggings) {
			this.effectPlayer(player, Potion.regeneration, 1);
		}
		
		// blue gem armor
		if(itemStack.getItem() == ArcaneItems.blueGemHelmet) {
			effectPlayer(player, Potion.waterBreathing, 2);
		}
		if(itemStack.getItem() == ArcaneItems.blueGemChestplate) {
			effectPlayer(player, Potion.absorption, 2);
		}
		if(itemStack.getItem() == ArcaneItems.blueGemLeggings) {
			effectPlayer(player, Potion.jump, 2);
		}
		if(itemStack.getItem() == ArcaneItems.blueGemBoots) {
			effectPlayer(player, Potion.moveSpeed, 2);
		}
		if(player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(3).getItem() == ArcaneItems.blueGemHelmet
				&& player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem() == ArcaneItems.blueGemChestplate
				&& player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(1).getItem() == ArcaneItems.blueGemLeggings
				&& player.inventory.armorItemInSlot(0) != null && player.inventory.armorItemInSlot(0).getItem() == ArcaneItems.blueGemLeggings) {
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
