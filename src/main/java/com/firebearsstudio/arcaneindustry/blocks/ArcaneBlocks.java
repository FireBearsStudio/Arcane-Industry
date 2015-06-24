package com.firebearsstudio.arcaneindustry.blocks;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ArcaneBlocks {

	public static Block testBlock;
	
	public static void createBlocks() {
		GameRegistry.registerBlock(testBlock = new BasicBlock("test_block").setLightLevel(1.0f), "test_block");
	}
}
