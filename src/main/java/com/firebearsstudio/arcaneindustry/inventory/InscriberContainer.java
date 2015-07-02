package com.firebearsstudio.arcaneindustry.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.firebearsstudio.arcaneindustry.recipes.InscriberRecipes;
import com.firebearsstudio.arcaneindustry.slot.SlotGrinderOutput;
import com.firebearsstudio.arcaneindustry.tileentity.InscriberTileEntity;

public class InscriberContainer extends Container {

	final InscriberTileEntity tileInscriber;
	final int sizeInventory;
	int cookTime;
	int burnTimeRemaining;
	int burnTimeInitialValue;
	
	public InscriberContainer(InventoryPlayer playerInventory, InscriberTileEntity tileEntity) {
		tileInscriber = tileEntity;
		sizeInventory = playerInventory.getSizeInventory();
		// input slot
		addSlotToContainer(new Slot(tileInscriber, InscriberTileEntity.slotEnum.INPUT_SLOT.ordinal(), 56, 17));
		// fuel slot
		addSlotToContainer(new Slot(tileInscriber, InscriberTileEntity.slotEnum.FUEL_SLOT.ordinal(), 56, 53));
		// output slot
		addSlotToContainer(new SlotGrinderOutput(playerInventory.player, tileInscriber, InscriberTileEntity.slotEnum.OUTPUT_SLOT.ordinal(), 116, 35));
		
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

			if (cookTime != tileInscriber.getField(0)) {
				icrafting.sendProgressBarUpdate(this, 0, tileInscriber.getField(0));
			}
			
			if (burnTimeRemaining != tileInscriber.getField(1)) {
				icrafting.sendProgressBarUpdate(this, 2, tileInscriber.getField(1));
			}
			
			if (burnTimeInitialValue != tileInscriber.getField(2)) {
				icrafting.sendProgressBarUpdate(this, 3, tileInscriber.getField(2));
			}
		}

		cookTime = tileInscriber.getField(0);
		burnTimeRemaining = tileInscriber.getField(1);
		burnTimeInitialValue = tileInscriber.getField(2);
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
		Slot sourceSlot = (Slot)inventorySlots.get(slotIndex);
		if (sourceSlot == null || !sourceSlot.getHasStack()) {
			return null;
		}
		ItemStack stack = sourceSlot.getStack();
		ItemStack stackCopy = stack.copy();
		
		// check if the slot clicked is one of the vanilla container slot
		if (slotIndex >= 3 && slotIndex < 39) {
			// this is a vanilla container slot so merge the stack into one of the furnace slots
			// if the stack can be inscribed try to merge the stack into the input slots
			if (InscriberRecipes.instance().getInscribingResult(stack) != null) {
				if (!mergeItemStack(stack, 0, 1, false)) {
					return null;
				}
			} else if (InscriberTileEntity.getItemBurnTime(stack) > 0) {
				if (!mergeItemStack(stack, 1, 2, false)) {
					return null;
				}
			} else {
				return null;
			}
		} else if (slotIndex >= 0 && slotIndex < 4) {
			// this is an inscriber slot so merge the stack into the player's inventory: try the hotbar first and then the main inventory
			// because the main inventory slots are immediately after the hotbar slots, we can just merge with a single call
			if (!mergeItemStack(stack, 3, 39, false)) {
				return null;
			}
		} else {
			System.err.println("invalid slotIndex: " + slotIndex);
			return null;
		}
		
		// if stack size == 0 (the entire stack was moved) set slot contents to null
		if (stack.stackSize == 0) {
			sourceSlot.putStack(null);
		} else {
			sourceSlot.onSlotChanged();
		}
		
		sourceSlot.onPickupFromSlot(player, stack);
		return stackCopy;
		
		/*ItemStack stack = null;
		Slot slot = (Slot)inventorySlots.get(slotIndex);
		
		if (slot != null && slot.getHasStack()) {
			ItemStack stack2 = slot.getStack();
			stack = stack2.copy();
			
			if (slotIndex == InscriberTileEntity.slotEnum.OUTPUT_SLOT.ordinal()) {
				if (!mergeItemStack(stack2, sizeInventory, sizeInventory + 36, true)) {
					return null;
				}
				
				slot.onSlotChange(stack2, stack);
			} else if (slotIndex != InscriberTileEntity.slotEnum.INPUT_SLOT.ordinal() && slotIndex != InscriberTileEntity.slotEnum.FUEL_SLOT.ordinal()) {
				// check if there is an inscriber recipe for the stack
				if (InscriberRecipes.instance().getInscribingResult(stack2) != null) {
					if (!mergeItemStack(stack2, 0, 1, false)) {
						return null;
					}
				} else if (stack2.getItem() == ArcaneItems.gemDust) {
					if (!mergeItemStack(stack2, 1, 2, false)) {
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
		
		return stack;*/
	}
}
