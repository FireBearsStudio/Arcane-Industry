package com.firebearsstudio.arcaneindustry.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.firebearsstudio.arcaneindustry.recipes.GrinderRecipes;
import com.firebearsstudio.arcaneindustry.slot.SlotGrinderOutput;
import com.firebearsstudio.arcaneindustry.tileentity.GrinderTileEntity;

public class GrinderContainer extends Container {

	final IInventory tileGrinder;
	final int sizeInventory;
	int ticksGrindingItemSoFar;
	int ticksPerItem;
	int timeCanGrind;
	
	public GrinderContainer(InventoryPlayer playerInventory, GrinderTileEntity tileEntity) {
		tileGrinder = tileEntity;
		sizeInventory = tileGrinder.getSizeInventory();
		addSlotToContainer(new Slot(tileGrinder, GrinderTileEntity.slotEnum.INPUT_SLOT.ordinal(), 50, 35));
		addSlotToContainer(new SlotGrinderOutput(playerInventory.player, tileGrinder, GrinderTileEntity.slotEnum.OUTPUT_SLOT.ordinal(), 116, 35));
		
		// add player inventory slots
		// note that the slot numbers are within the player inventory so can be same as the tile entity inventory
		int i;
		for (i = 0; i < 3; ++i) {
			for (int j = 0; j < 9; ++j) {
				addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
		
		// add hotbar slots
		for (i = 0; i < 9; ++i) {
			addSlotToContainer(new Slot(playerInventory, i, 8 + i * 18, 142));
		}
	}
	
	@Override
	public void addCraftingToCrafters(ICrafting listener) {
		super.addCraftingToCrafters(listener);
		listener.func_175173_a(this, tileGrinder);
	}
	
	/**
	 * Looks for changes made in the container, sends them to every listener
	 */
	@Override
	public void detectAndSendChanges() {
		super.detectAndSendChanges();
		
		for (int i = 0; i < crafters.size(); ++i) {
			ICrafting icrafting = (ICrafting)crafters.get(i);
			
			if (ticksGrindingItemSoFar != tileGrinder.getField(2)) {
				icrafting.sendProgressBarUpdate(this, 2, tileGrinder.getField(2));
			}
			
			if (timeCanGrind != tileGrinder.getField(0)) {
				icrafting.sendProgressBarUpdate(this, 0, tileGrinder.getField(0));
			}
			
			if (ticksPerItem != tileGrinder.getField(3)) {
				icrafting.sendProgressBarUpdate(this, 3, tileGrinder.getField(3));
			}
		}
		
		ticksGrindingItemSoFar = tileGrinder.getField(2);
		timeCanGrind = tileGrinder.getField(0);
		ticksPerItem = tileGrinder.getField(3);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int id, int data) {
		tileGrinder.setField(id, data);
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return tileGrinder.isUseableByPlayer(playerIn);
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex) {
		ItemStack stack = null;
		Slot slot = (Slot)inventorySlots.get(slotIndex);
		
		if (slot != null && slot.getHasStack()) {
			ItemStack stack2 = slot.getStack();
			stack = stack2.copy();
			
			if (slotIndex == GrinderTileEntity.slotEnum.OUTPUT_SLOT.ordinal()) {
				if (!mergeItemStack(stack2, sizeInventory, sizeInventory + 36, true)) {
					return null;
				}
				
				slot.onSlotChange(stack2, stack);
			} else if (slotIndex != GrinderTileEntity.slotEnum.INPUT_SLOT.ordinal()) {
				// check if there is a grinding recipe for the stack
				if (GrinderRecipes.instance().getGrindingResult(stack2) != null) {
					if (!mergeItemStack(stack2, 0, 1, false)) {
						return null;
					}
				} else if (slotIndex >= sizeInventory && slotIndex < sizeInventory + 27) {	// player inventory slots
					if (!mergeItemStack(stack2, sizeInventory + 27, sizeInventory + 36, false)) {
						return null;
					}
				} else if (slotIndex >= sizeInventory + 27 && slotIndex < sizeInventory + 36 && !mergeItemStack(stack2, sizeInventory + 1, sizeInventory + 27, false)) {	// hotbar slots
					return null;
				}
			} else if (!mergeItemStack(stack2, sizeInventory, sizeInventory + 36, false)) {
				return null;
			}
			
			if (stack2.stackSize == 0) {
				slot.putStack((ItemStack)null);
			} else {
				slot.onSlotChanged();
			}
			
			if (stack2.stackSize == stack.stackSize) {
				return null;
			}
			
			slot.onPickupFromSlot(player, stack2);
		}
		
		return stack;
	}
}
