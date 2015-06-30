package com.firebearsstudio.arcaneindustry.slot;

import com.firebearsstudio.arcaneindustry.recipes.GrinderRecipes;

import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;

public class SlotGrinderOutput extends Slot {

	// the player that is using the GUI where this slot resides
	final EntityPlayer player;
	int numGrinderOutput;
	
	public SlotGrinderOutput(EntityPlayer player, IInventory inventoryIn, int index, int xPosition,
			int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
		this.player = player;
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		return false;	// can't place anything into it
	}
	
	@Override
	public ItemStack decrStackSize(int amount) {
		if (getHasStack()) {
			numGrinderOutput += Math.min(amount, getStack().stackSize);
		}
		
		return super.decrStackSize(amount);
	}
	
	@Override
	public void onPickupFromSlot(EntityPlayer player, ItemStack stack) {
		onCrafting(stack);
		super.onPickupFromSlot(player, stack);
	}
	
	@Override
	public void onCrafting(ItemStack stack, int amountGround) {
		numGrinderOutput += amountGround;
		onCrafting(stack);
	}
	
	@Override
	protected void onCrafting(ItemStack stack) {
		if (!player.worldObj.isRemote) {
			int expEarned = numGrinderOutput;
			float expFactor = GrinderRecipes.instance().getGrindingExprience(stack);
			
			if (expFactor == 0.0F) {
				expEarned = 0;
			} else if (expFactor < 1.0F) {
				int possibleExpEarned = MathHelper.floor_float(expEarned * expFactor);
				
				if (possibleExpEarned < MathHelper.ceiling_float_int(expEarned * expFactor) && Math.random() < expEarned * expFactor - possibleExpEarned) {
					++possibleExpEarned;
				}
				
				expEarned = possibleExpEarned;
			}
			
			// create experience orbs
			int expInOrb;
			while (expEarned > 0) {
				expInOrb = EntityXPOrb.getXPSplit(expEarned);
				expEarned -= expInOrb;
				player.worldObj.spawnEntityInWorld(new EntityXPOrb(player.worldObj, player.posX + 0.5D, player.posY + 0.5D, player.posZ + 0.5D, expInOrb));
			}
		}
		
		numGrinderOutput = 0;
		
		/**
		 * you can trigger achievements here based on output
		 * E.g. if (stack.getItem() == Items.grinded_fish) {
		 * 			player.triggerAchievement(AchievementList.grindFish);
		 * 		}
		 */
	}
}
