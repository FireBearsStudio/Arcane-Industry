package com.firebearsstudio.arcaneindustry.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.firebearsstudio.arcaneindustry.recipes.GrinderRecipes;
import com.firebearsstudio.arcaneindustry.slot.SlotGrinderOutput;
import com.firebearsstudio.arcaneindustry.tileentity.GrinderTileEntity;
import com.firebearsstudio.arcaneindustry.tileentity.InscriberTileEntity;

public class InscriberContainer extends Container {

	final InscriberTileEntity tileInscriber;
	final int sizeInventory;
	int ticksCookingItemSoFar;
	int ticksPerItem;
	int timeCanCook;
	
	public InscriberContainer(InventoryPlayer playerInventory, InscriberTileEntity tileEntity) {
		tileInscriber = tileEntity;
		sizeInventory = playerInventory.getSizeInventory();
		// input slot
		addSlotToContainer(new Slot(tileInscriber, InscriberTileEntity.slotEnum.INPUT_SLOT.ordinal(), 56, 17));
		// fuel slot
		addSlotToContainer(new Slot(tileInscriber, InscriberTileEntity.slotEnum.FUEL_SLOT.ordinal(), 56, 53));
		// output slot
		addSlotToContainer(new SlotGrinderOutput(playerInventory.player, tileInscriber, GrinderTileEntity.slotEnum.OUTPUT_SLOT.ordinal(), 116, 35));
		
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
		listener.func_175173_a(this, tileInscriber);
	}
	
	/**
	 * Looks for changes made in the container, sends them to every listener
	 */
	@Override
	public void detectAndSendChanges() {
		super.detectAndSendChanges();
		
		for (int i = 0; i < crafters.size(); ++i) {
			ICrafting icrafting = (ICrafting)crafters.get(i);
			
			if (ticksCookingItemSoFar != tileInscriber.getField(2)) {
				icrafting.sendProgressBarUpdate(this, 2, tileInscriber.getField(2));
			}
			
			if (timeCanCook != tileInscriber.getField(0)) {
				icrafting.sendProgressBarUpdate(this, 0, tileInscriber.getField(0));
			}
			
			if (ticksPerItem != tileInscriber.getField(3)) {
				icrafting.sendProgressBarUpdate(this, 3, tileInscriber.getField(3));
			}
		}
		
		ticksCookingItemSoFar = tileInscriber.getField(2);
		timeCanCook = tileInscriber.getField(0);
		ticksPerItem = tileInscriber.getField(3);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int id, int data) {
		tileInscriber.setField(id, data);
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return tileInscriber.isUseableByPlayer(playerIn);
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
