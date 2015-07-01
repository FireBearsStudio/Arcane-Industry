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

import com.firebearsstudio.arcaneindustry.inventory.InscriberContainer;
import com.firebearsstudio.arcaneindustry.items.ArcaneItems;
import com.firebearsstudio.arcaneindustry.recipes.InscriberRecipes;

public class InscriberTileEntity extends TileEntityLockable implements IUpdatePlayerListBox, ISidedInventory {

	public enum slotEnum {
		INPUT_SLOT, OUTPUT_SLOT, FUEL_SLOT
	}

	static final int[] slotsTop = new int[] { slotEnum.INPUT_SLOT.ordinal() };
	static final int[] slotsBottom = new int[] { slotEnum.OUTPUT_SLOT.ordinal() };
	static final int[] slotsSides = new int[] { slotEnum.FUEL_SLOT.ordinal() };
	
	ItemStack[] inscriberItemStackArray = new ItemStack[3];
	int cookTime;
	int burnTimeRemaining;
	int burnTimeInitialValue;
	String inscriberCustomName;
	
	static final short COOK_TIME_FOR_COMPLETION = 200;	// vanilla value is 200 = 10 seconds

	@Override
	public void update() {
		if (burnTimeRemaining <= 0) {
			burnTimeRemaining = burnFuel();
		}
		
		// if there is nothing to inscribe or there is no room in the output, reset the cooktime and return
		if (canInscribe()) {
			// if fuel is available, keep cooking the item
			if (burnTimeRemaining > 0) {
				cookTime++;
			}
			
			// if cooktime has reached maxcooktime inscribe the item and reset the cooktime 
			if (cookTime >= COOK_TIME_FOR_COMPLETION) {
				InscribeItem();
				cookTime = 0;
			}
		} else if (inscriberItemStackArray[slotEnum.INPUT_SLOT.ordinal()] == null) {
			cookTime = 0;
		}
	}
	
	public boolean canInscribe() {
		// if nothing in input slot or nothing in fuel slot
		if (inscriberItemStackArray[slotEnum.INPUT_SLOT.ordinal()] == null || inscriberItemStackArray[slotEnum.FUEL_SLOT.ordinal()] == null) {
			return false;
		} else {
			// check if it has an inscribing recipe
			ItemStack stackToOutput = InscriberRecipes.instance().getInscribingResult(inscriberItemStackArray[slotEnum.INPUT_SLOT.ordinal()]);
			
			if (stackToOutput == null) {
				return false;
			}
			
			if (inscriberItemStackArray[slotEnum.OUTPUT_SLOT.ordinal()] == null) {
				return true;
			}
			
			if (!inscriberItemStackArray[slotEnum.OUTPUT_SLOT.ordinal()].isItemEqual(stackToOutput)) {
				return false;
			}
			
			int result = inscriberItemStackArray[slotEnum.OUTPUT_SLOT.ordinal()].stackSize + stackToOutput.stackSize;
			
			return result <= inscriberItemStackArray[slotEnum.OUTPUT_SLOT.ordinal()].getMaxStackSize();
		}
	}
	
	public void InscribeItem() {
		if (canInscribe()) {
			ItemStack stack = InscriberRecipes.instance().getInscribingResult(inscriberItemStackArray[slotEnum.INPUT_SLOT.ordinal()]);
			
			// check if output slot is empty
			if (inscriberItemStackArray[slotEnum.OUTPUT_SLOT.ordinal()] == null) {
				inscriberItemStackArray[slotEnum.OUTPUT_SLOT.ordinal()] = stack.copy();
			} else if (inscriberItemStackArray[slotEnum.OUTPUT_SLOT.ordinal()].getItem() == stack.getItem()) {
				inscriberItemStackArray[slotEnum.OUTPUT_SLOT.ordinal()].stackSize += stack.stackSize;
			}
			
			inscriberItemStackArray[slotEnum.INPUT_SLOT.ordinal()].stackSize--;
			
			if (inscriberItemStackArray[slotEnum.INPUT_SLOT.ordinal()].stackSize <= 0) {
				inscriberItemStackArray[slotEnum.INPUT_SLOT.ordinal()] = null;
			}
		}
	}
	
	int burnFuel() {
		int burningCount = 0;
		boolean invChanged = false;
		if (burnTimeRemaining > 0) {
			--burnTimeRemaining;
		}
		
		if (burnTimeRemaining == 0) {
			if (inscriberItemStackArray[slotEnum.FUEL_SLOT.ordinal()] != null) {
				if (inscriberItemStackArray[slotEnum.FUEL_SLOT.ordinal()].getItem() == ArcaneItems.gemDust) {
					burningCount = 100;
				}
			}
		}
		
		if (invChanged) {
			markDirty();
		}
		
		return burningCount;
	}
	
	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState) {
		return false;
	}
	
	@Override
	public int getSizeInventory() {
		return inscriberItemStackArray.length;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		return inscriberItemStackArray[index];
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		if (inscriberItemStackArray[index] != null) {
			ItemStack stack;
			if (inscriberItemStackArray[index].stackSize <= count) {
				stack = inscriberItemStackArray[index];
				inscriberItemStackArray[index] = null;
				return stack;
			} else {
				stack = inscriberItemStackArray[index].splitStack(count);
				if (inscriberItemStackArray[index].stackSize == 0) {
					inscriberItemStackArray[index] = null;
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
		if (inscriberItemStackArray[index] != null) {
			ItemStack stack = inscriberItemStackArray[index];
			inscriberItemStackArray[index] = null;
			return stack;
		} else {
			return null;
		}
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		boolean isSameItemStackAlreadyInSlot = stack != null &&
				stack.isItemEqual(inscriberItemStackArray[index]) &&
				ItemStack.areItemStackTagsEqual(stack, inscriberItemStackArray[index]);
		inscriberItemStackArray[index] = stack;
		
		if (stack != null && stack.stackSize > getInventoryStackLimit()) {
			stack.stackSize = getInventoryStackLimit();
		}
		
		// if input slot, reset the inscribing timers
		if (index == slotEnum.INPUT_SLOT.ordinal() && !isSameItemStackAlreadyInSlot) {
			cookTime = 0;
			markDirty();
		}
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}
	
	public boolean cookingSomething() {
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
		if (index == slotEnum.INPUT_SLOT.ordinal()) {
			return true;
		} else if (index == slotEnum.FUEL_SLOT.ordinal()) {
			if (stack == new ItemStack(ArcaneItems.gemDust)) {
				return true;
			}
			return false;
		} else {
			return false;
		}
		//return index == slotEnum.INPUT_SLOT.ordinal() ? true : false;
	}
	@Override
	public int getField(int id) {
		switch (id) {
			case 0:
				return cookTime;
			case 1:
				return burnTimeRemaining;
			case 2:
				return burnTimeInitialValue;
			default:
				return 0;
		}
	}

	@Override
	public void setField(int id, int value) {
		switch (id) {
		case 0:
			cookTime = value;
			break;
		case 1:
			burnTimeRemaining = value;
			break;
		case 2:
			burnTimeInitialValue = value;
			break;
		default:
			break;
		}
	}
	@Override
	public int getFieldCount() {
		return 3;
	}

	@Override
	public void clear() {
		for (int i = 0; i < inscriberItemStackArray.length; ++i) {
			inscriberItemStackArray[i] = null;
		}
	}

	@Override
	public String getName() {
		return hasCustomName() ? inscriberCustomName : "container.inscriber";
	}

	@Override
	public boolean hasCustomName() {
		return inscriberCustomName != null && inscriberCustomName.length() > 0;
	}
	
	public void setCustomInventoryName(String name) {
		inscriberCustomName = name;
	}


	@Override
	public Container createContainer(InventoryPlayer playerInventory,
			EntityPlayer playerIn) {
		return new InscriberContainer(playerInventory, this);
	}

	@Override
	public String getGuiID() {
		return "arcaneindustry:inscriber";
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
		inscriberItemStackArray = new ItemStack[getSizeInventory()];
		
		for (int i = 0; i < tagList.tagCount(); ++i) {
			NBTTagCompound tagCompound = tagList.getCompoundTagAt(i);
			byte b0 = tagCompound.getByte("Slot");
			
			if (b0 >= 0 && b0 < inscriberItemStackArray.length) {
				inscriberItemStackArray[b0] = ItemStack.loadItemStackFromNBT(tagCompound);
			}
		}
		
		//timeCanCook = compound.getShort("CookTime");
		cookTime = compound.getShort("CookTime");
		burnTimeRemaining = compound.getShort("BurnRemaining");
		burnTimeInitialValue = compound.getShort("BurnInitial");
		//COOK_TIME_FOR_COMPLETION = compound.getShort("CookTimeTotal");
		
		if (compound.hasKey("CustomName", 8)) {
			inscriberCustomName = compound.getString("CustomName");
		}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		//compound.setShort("CookTime", (short)timeCanCook);
		compound.setShort("CookTime", (short)cookTime);
		compound.setShort("BurnRemaining", (short)burnTimeRemaining);
		compound.setShort("BurnInitial", (short)burnTimeInitialValue);
		//compound.setShort("CookTimeTotal", (short)COOK_TIME_FOR_COMPLETION);
		NBTTagList tagList = new NBTTagList();
		
		for (int i = 0; i < inscriberItemStackArray.length; ++i) {
			if (inscriberItemStackArray[i] != null) {
				NBTTagCompound tagCompound = new NBTTagCompound();
				tagCompound.setByte("Slot", (byte)i);
				inscriberItemStackArray[i].writeToNBT(tagCompound);
				tagList.appendTag(tagCompound);
			}
		}
		
		compound.setTag("Items", tagList);
		
		if (hasCustomName()) {
			compound.setString("CustomName", inscriberCustomName);
		}
	}

	/*public int timeToCookOneItem(ItemStack stack) {
		return COOK_TIME_FOR_COMPLETION;
	}*/
	
	public double fractionOfCookTimeComplete() {
		double fraction = cookTime / (double)COOK_TIME_FOR_COMPLETION;
		return MathHelper.clamp_double(fraction, 0.0, 1.0);
	}
	
	public double fractionOfFuelRemaining() {
		if (burnTimeInitialValue <= 0) {
			return 0;
		}
		
		double fraction = burnTimeRemaining / (double)burnTimeInitialValue;
		return MathHelper.clamp_double(fraction, 0.0, 1.0);
	}
	
	public int secondsOfFuelRemaining() {
		if (burnTimeInitialValue <= 0) {
			return 0;
		}
		return burnTimeRemaining / 20;	// 20 ticks per second
	}
}
