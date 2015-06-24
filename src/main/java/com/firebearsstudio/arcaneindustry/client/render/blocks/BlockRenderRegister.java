package com.firebearsstudio.arcaneindustry.client.render.blocks;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

import com.firebearsstudio.arcaneindustry.Main;
import com.firebearsstudio.arcaneindustry.blocks.ArcaneBlocks;

public final class BlockRenderRegister {

	public static String modid = Main.MOD_ID;
	
	public static void registerBlockRenderer() {
		reg(ArcaneBlocks.testBlock);
	}
	
	public static void reg(Block block) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation(modid + ":" + block.getUnlocalizedName().substring(5), "inventory"));
	}
}
