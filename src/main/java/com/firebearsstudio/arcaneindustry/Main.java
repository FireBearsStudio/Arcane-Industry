package com.firebearsstudio.arcaneindustry;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Main.MOD_ID, name = Main.MOD_NAME, version = Main.VERSION)
public class Main {
	
	public static final String MOD_ID = "arcaneindustry";
	public static final String MOD_NAME = "Arcane Industry";
	public static final String VERSION = "0.0.1";
	
	@Instance
	public static Main instance = new Main();

	public enum GUI_ENUM {
		GRINDER
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		this.proxy.preInit(e);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e) {
		this.proxy.init(e);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		this.proxy.postInit(e);
	}
	
	@SidedProxy(clientSide = "com.firebearsstudio.arcaneindustry.ClientProxy", serverSide = "com.firebearsstudio.arcaneindustry.ServerProxy")
	public static CommonProxy proxy;
}
