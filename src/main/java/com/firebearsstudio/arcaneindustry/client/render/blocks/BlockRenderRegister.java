package com.firebearsstudio.arcaneindustry.client.render.blocks;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

import com.firebearsstudio.arcaneindustry.Main;
import com.firebearsstudio.arcaneindustry.blocks.ArcaneBlocks;

public class BlockRenderRegister {

	public static String mod_id = Main.MOD_ID;
	
	public static void preInit() {
		ModelBakery.addVariantName(Item.getItemFromBlock(ArcaneBlocks.propertyBlock), "arcaneindustry:block_properties_black", "arcaneindustry:block_properties_white");
	}
	
	public static void registerBlockRenderer() {
		reg(ArcaneBlocks.testBlock);
		reg(ArcaneBlocks.propertyBlock, 0, "block_properties_white");
		reg(ArcaneBlocks.propertyBlock, 1, "block_properties_black");
		reg(ArcaneBlocks.buttOre);
		reg(ArcaneBlocks.multiOre);
		reg(ArcaneBlocks.blueGemOre);
		reg(ArcaneBlocks.redGemOre);
		reg(ArcaneBlocks.greenGemOre);
	}
	
	public static void reg(Block block) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().
			register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(mod_id + ":" + block.getUnlocalizedName().substring(5), "inventory"));
	}
	
	public static void reg(Block block, int meta, String file) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().
			register(Item.getItemFromBlock(block), meta, new ModelResourceLocation(mod_id + ":" + file, "inventory"));
	}
}
