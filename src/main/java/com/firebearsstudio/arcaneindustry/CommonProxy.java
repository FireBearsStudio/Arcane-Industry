package com.firebearsstudio.arcaneindustry;

import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.firebearsstudio.arcaneindustry.blocks.ArcaneBlocks;
import com.firebearsstudio.arcaneindustry.items.ArcaneItems;

public class CommonProxy {
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		ArcaneItems.createItems();
		ArcaneBlocks.createBlocks();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e) {
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		
	}
}
