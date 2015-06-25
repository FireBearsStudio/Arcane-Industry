package com.firebearsstudio.arcaneindustry.blocks;

import com.firebearsstudio.arcaneindustry.items.ArcaneItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ArcaneBlocks {

	public static Block testBlock;
	public static BlockProperties propertyBlock;
	
	public static ArcaneBlockOre buttOre;
	
	public static ArcaneBlockMultiOre multiOre;
	
	public static ArcaneBlockBasicOre blueGemOre;
	public static ArcaneBlockBasicOre redGemOre;
	public static ArcaneBlockBasicOre greenGemOre;
	
	public static void createBlocks() {
		GameRegistry.registerBlock(testBlock = new BasicBlock("test_block").setLightLevel(1.0f), "test_block");
		GameRegistry.registerBlock(propertyBlock = new BlockProperties("block_properties", Material.cloth, 10.0f, 6.0f), ItemBlockMeta.class, "block_properties");
		GameRegistry.registerBlock(buttOre = new ArcaneBlockOre("butt_ore", Material.rock, ArcaneItems.buttOfPower, 2, 4), "butt_ore");
		GameRegistry.registerBlock(multiOre = new ArcaneBlockMultiOre("arcane_multi_ore", Material.rock), "arcane_multi_ore");
		GameRegistry.registerBlock(blueGemOre = new ArcaneBlockBasicOre("blue_gem_ore", Material.rock, 10.0F, 6.0F, "pickaxe", 2), "blue_gem_ore");
		GameRegistry.registerBlock(redGemOre = new ArcaneBlockBasicOre("red_gem_ore", Material.rock, 10.0F, 6.0F, "pickaxe", 2), "red_gem_ore");
		GameRegistry.registerBlock(greenGemOre = new ArcaneBlockBasicOre("green_gem_ore", Material.rock, 10.0F, 6.0F, "pickaxe", 2), "green_gem_ore");
	}
}
