package com.firebearsstudio.arcaneindustry;

import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.firebearsstudio.arcaneindustry.blocks.ArcaneBlocks;
import com.firebearsstudio.arcaneindustry.crafting.ArcaneCrafting;
import com.firebearsstudio.arcaneindustry.gui.GuiHandler;
import com.firebearsstudio.arcaneindustry.items.ArcaneItems;
import com.firebearsstudio.arcaneindustry.tileentity.ArcaneTileEntities;
import com.firebearsstudio.arcaneindustry.world.ArcaneNetherGen;
import com.firebearsstudio.arcaneindustry.world.ArcaneWorldGen;

public class CommonProxy {
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		ArcaneItems.createItems();
		ArcaneBlocks.createBlocks();
		ArcaneTileEntities.init();
		ArcaneCrafting.oreRegistration();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e) {
		ArcaneCrafting.initCrafting();
		GameRegistry.registerWorldGenerator(new ArcaneWorldGen(), 0);
		GameRegistry.registerWorldGenerator(new ArcaneNetherGen(), 0);
		
		NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		
	}
}
