package com.firebearsstudio.arcaneindustry.tileentity;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.firebearsstudio.arcaneindustry.blocks.TutorialGrinder;
import com.firebearsstudio.arcaneindustry.inventory.GrinderContainer;
import com.firebearsstudio.arcaneindustry.recipes.GrinderRecipes;

public class GrinderTileEntity extends TileEntityLockable implements IUpdatePlayerListBox, ISidedInventory {

	public enum slotEnum {
		INPUT_SLOT, OUTPUT_SLOT
	}

	static final int[] slotsTop = new int[] { slotEnum.INPUT_SLOT.ordinal() };
	static final int[] slotsBottom = new int[] { slotEnum.OUTPUT_SLOT.ordinal() };
	static final int[] slotsSides = new int[] {};
	
	ItemStack[] grinderItemStackArray = new ItemStack[2];
	int timeCanGrind;
	int currentItemGrindTime;
	int ticksGrindingItemSoFar;
	int ticksPerItem;
	String grinderCustomName;
	
	static final short COOK_TIME_FOR_COMPLETION = 300;	// vanilla value is 200 = 10 seconds
	
	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState) {
		return false;
	}
	
	@Override
	public void update() {
		boolean hasBeenGrinding = grindingSomething();
		boolean changedGrindingState = false;
		
		if (grindingSomething()) {
			--timeCanGrind;
		}
		
		if (!worldObj.isRemote) {
			// if something in input slot
			if (grinderItemStackArray[slotEnum.INPUT_SLOT.ordinal()] != null) {
				// start grinding
				if (!grindingSomething() && canGrind()) {
					timeCanGrind = 150;
					
					if (grindingSomething()) {
						changedGrindingState = true;
					}
				}
				
				// continue grinding
				if (grindingSomething() && canGrind()) {
					ticksGrindingItemSoFar++;
					
					// check if completed grinding an item
					if (ticksGrindingItemSoFar == ticksPerItem) {
						ticksGrindingItemSoFar = 0;
						ticksPerItem = timeToGrindOneItem(grinderItemStackArray[0]);
						grindItem();
						changedGrindingState = true;
					}
				} else {
					ticksGrindingItemSoFar = 0;
				}
			}
			
			// started or stopped grinding, update block to change to active or inactive model
			if (hasBeenGrinding != grindingSomething()) {
				changedGrindingState = true;
				//TutorialGrinder.changeBlockBasedOnGrindingStatus(grindingSomething(), worldObj, pos);
			}
		}
		
		if (changedGrindingState) {
			markDirty();
		}
	}
	
	boolean canGrind() {
		// if nothing in input slot
		if (grinderItemStackArray[slotEnum.INPUT_SLOT.ordinal()] == null) {
			return false;
		} else {
			// check if it has a grinding recipe
			ItemStack stackToOutput = GrinderRecipes.instance().getGrindingResult(grinderItemStackArray[slotEnum.INPUT_SLOT.ordinal()]);
			
			if (stackToOutput == null) {
				return false;
			}
			
			if (grinderItemStackArray[slotEnum.OUTPUT_SLOT.ordinal()] == null) {
				return true;
			}
			
			if (!grinderItemStackArray[slotEnum.OUTPUT_SLOT.ordinal()].isItemEqual(stackToOutput)) {
				return false;
			}
			
			int result = grinderItemStackArray[slotEnum.OUTPUT_SLOT.ordinal()].stackSize + stackToOutput.stackSize;
			
			return result <= grinderItemStackArray[slotEnum.OUTPUT_SLOT.ordinal()].getMaxStackSize();
		}
	}
	
	public void grindItem() {
		if (canGrind()) {
			ItemStack stack = GrinderRecipes.instance().getGrindingResult(grinderItemStackArray[slotEnum.INPUT_SLOT.ordinal()]);
			
			// check if output slot is empty
			if (grinderItemStackArray[slotEnum.OUTPUT_SLOT.ordinal()] == null) {
				grinderItemStackArray[slotEnum.OUTPUT_SLOT.ordinal()] = stack.copy();
			} else if (grinderItemStackArray[slotEnum.OUTPUT_SLOT.ordinal()].getItem() == stack.getItem()) {
				grinderItemStackArray[slotEnum.OUTPUT_SLOT.ordinal()].stackSize += stack.stackSize;
			}
			
			--grinderItemStackArray[slotEnum.INPUT_SLOT.ordinal()].stackSize;
			
			if (grinderItemStackArray[slotEnum.INPUT_SLOT.ordinal()].stackSize <= 0) {
				grinderItemStackArray[slotEnum.INPUT_SLOT.ordinal()] = null;
			}
		}
	}

	@Override
	public int getSizeInventory() {
		return grinderItemStackArray.length;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		return grinderItemStackArray[index];
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		if (grinderItemStackArray[index] != null) {
			ItemStack stack;
			if (grinderItemStackArray[index].stackSize <= count) {
				stack = grinderItemStackArray[index];
				grinderItemStackArray[index] = null;
				return stack;
			} else {
				stack = grinderItemStackArray[index].splitStack(count);
				if (grinderItemStackArray[index].stackSize == 0) {
					grinderItemStackArray[index] = null;
				}
				
				return stack;
			}
		} else {
			return null;
		}
	}

	/**
	 * When some containers are closed they call this on each slot, then
	 * drop whatever it returns as an EntityItem -
	 * like when you close a workbench GUI
	 */
	@Override
	public ItemStack getStackInSlotOnClosing(int index) {
		if (grinderItemStackArray[index] != null) {
			ItemStack stack = grinderItemStackArray[index];
			grinderItemStackArray[index] = null;
			return stack;
		} else {
			return null;
		}
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		boolean isSameItemStackAlreadyInSlot = stack != null &&
				stack.isItemEqual(grinderItemStackArray[index]) &&
				ItemStack.areItemStackTagsEqual(stack, grinderItemStackArray[index]);
		grinderItemStackArray[index] = stack;
		
		if (stack != null && stack.stackSize > getInventoryStackLimit()) {
			stack.stackSize = getInventoryStackLimit();
		}
		
		// if input slot, reset the grinding timers
		if (index == slotEnum.INPUT_SLOT.ordinal() && !isSameItemStackAlreadyInSlot) {
			ticksPerItem = timeToGrindOneItem
					(stack);
			ticksGrindingItemSoFar = 0;
			markDirty();
		}
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}
	
	public boolean grindingSomething() {
		return true;
	}
	
	@SideOnly(Side.CLIENT)
	public static boolean func_174903_a(IInventory inv) {
		return true;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return worldObj.getTileEntity(pos) != this ? false : player.getDistanceSq(pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D) <= 64.0D;
	}

	@Override
	public void openInventory(EntityPlayer player) {}

	@Override
	public void closeInventory(EntityPlayer player) {}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		return index == slotEnum.INPUT_SLOT.ordinal() ? true : false;
	}

	@Override
	public int getField(int id) {
		switch (id) {
			case 0:
				return timeCanGrind;
			case 1:
				return currentItemGrindTime;
			case 2:
				return ticksGrindingItemSoFar;
			case 3:
				return ticksPerItem;
			default:
				return 0;
		}
	}

	@Override
	public void setField(int id, int value) {
		switch (id) {
		case 0:
			timeCanGrind = value;
			break;
		case 1:
			currentItemGrindTime = value;
			break;
		case 2:
			ticksGrindingItemSoFar = value;
			break;
		case 3:
			ticksPerItem = value;
			break;
		default:
			break;
		}
	}

	@Override
	public int getFieldCount() {
		return 4;
	}

	@Override
	public void clear() {
		for (int i = 0; i < grinderItemStackArray.length; ++i) {
			grinderItemStackArray[i] = null;
		}
	}

	@Override
	public String getName() {
		return hasCustomName() ? grinderCustomName : "container.grinder";
	}

	@Override
	public boolean hasCustomName() {
		return grinderCustomName != null && grinderCustomName.length() > 0;
	}
	
	public void setCustomInventoryName(String name) {
		grinderCustomName = name;
	}

	@Override
	public Container createContainer(InventoryPlayer playerInventory,
			EntityPlayer playerIn) {
		return new GrinderContainer(playerInventory, this);
	}

	@Override
	public String getGuiID() {
		return "arcaneindustry:grinder";
	}

	@Override
	public int[] getSlotsForFace(EnumFacing side) {
		return side == EnumFacing.DOWN ? slotsBottom :
			(side == EnumFacing.UP ? slotsTop : slotsSides);
	}

	@Override
	public boolean canInsertItem(int index, ItemStack itemStackIn,
			EnumFacing direction) {
		return isItemValidForSlot(index, itemStackIn);
	}

	@Override
	public boolean canExtractItem(int index, ItemStack stack,
			EnumFacing direction) {
		return true;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		NBTTagList tagList = compound.getTagList("Items", 10);
		grinderItemStackArray = new ItemStack[getSizeInventory()];
		
		for (int i = 0; i < tagList.tagCount(); ++i) {
			NBTTagCompound tagCompound = tagList.getCompoundTagAt(i);
			byte b0 = tagCompound.getByte("Slot");
			
			if (b0 >= 0 && b0 < grinderItemStackArray.length) {
				grinderItemStackArray[b0] = ItemStack.loadItemStackFromNBT(tagCompound);
			}
		}
		
		timeCanGrind = compound.getShort("GrindTime");
		ticksGrindingItemSoFar = compound.getShort("CookTime");
		ticksPerItem = compound.getShort("CookTimeTotal");
		
		if (compound.hasKey("CustomName", 8)) {
			grinderCustomName = compound.getString("CustomName");
		}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setShort("GrindTime", (short)timeCanGrind);
		compound.setShort("CookTime", (short)ticksGrindingItemSoFar);
		compound.setShort("CookTimeTotal", (short)ticksPerItem);
		NBTTagList tagList = new NBTTagList();
		
		for (int i = 0; i < grinderItemStackArray.length; ++i) {
			if (grinderItemStackArray[i] != null) {
				NBTTagCompound tagCompound = new NBTTagCompound();
				tagCompound.setByte("Slot", (byte)i);
				grinderItemStackArray[i].writeToNBT(tagCompound);
				tagList.appendTag(tagCompound);
			}
		}
		
		compound.setTag("Items", tagList);
		
		if (hasCustomName()) {
			compound.setString("CustomName", grinderCustomName);
		}
	}

	public int timeToGrindOneItem(ItemStack stack) {
		return COOK_TIME_FOR_COMPLETION;
	}
	
	public double fractionOfCookTimeComplete() {
		double fraction = ticksGrindingItemSoFar / (double)COOK_TIME_FOR_COMPLETION;
		return MathHelper.clamp_double(fraction, 0.0, 1.0);
	}
}
