package com.firebearsstudio.arcaneindustry;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.firebearsstudio.arcaneindustry.client.render.blocks.BlockRenderRegister;
import com.firebearsstudio.arcaneindustry.client.render.items.ItemRenderRegister;
import com.firebearsstudio.arcaneindustry.mob.EntitySalamanderMob;
import com.firebearsstudio.arcaneindustry.mob.ModelSalamander;
import com.firebearsstudio.arcaneindustry.mob.RenderSalamanderMob;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);
		
		BlockRenderRegister.preInit();
		ItemRenderRegister.preInit();
	}

	@Override
	public void init(FMLInitializationEvent e) {
		super.init(e);
		
		ItemRenderRegister.registerItemRenderer();
		BlockRenderRegister.registerBlockRenderer();
		
		RenderingRegistry.registerEntityRenderingHandler(EntitySalamanderMob.class, new RenderSalamanderMob(Minecraft.getMinecraft().getRenderManager(), new ModelSalamander(), 0.0F));
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		super.postInit(e);
	}

}
