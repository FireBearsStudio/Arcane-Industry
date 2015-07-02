package com.firebearsstudio.arcaneindustry.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.firebearsstudio.arcaneindustry.Main;
import com.firebearsstudio.arcaneindustry.inventory.GrinderContainer;
import com.firebearsstudio.arcaneindustry.inventory.InscriberContainer;
import com.firebearsstudio.arcaneindustry.tileentity.GrinderTileEntity;
import com.firebearsstudio.arcaneindustry.tileentity.InscriberTileEntity;

@SideOnly(Side.CLIENT)
public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));
		
		if (tileEntity != null) {	// if a tile entity is needed
			if (ID == Main.GUI_ENUM.GRINDER.ordinal()) {	// checks id vs gui enum to run specific code
				return new GrinderContainer(player.inventory, (GrinderTileEntity)tileEntity); 
			} else if (ID == Main.GUI_ENUM.INSCRIBER.ordinal()) {
				return new InscriberContainer(player.inventory, (InscriberTileEntity)tileEntity);
			}
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));
		
		if (tileEntity != null) {
			if (ID == Main.GUI_ENUM.GRINDER.ordinal()) {
				return new GrinderGui(player.inventory, (GrinderTileEntity)tileEntity);
			} else if (ID == Main.GUI_ENUM.INSCRIBER.ordinal()) {
				return new InscriberGui(player.inventory, (InscriberTileEntity)tileEntity);
			}
		}
		return null;
	}

	
}
