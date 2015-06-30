package com.firebearsstudio.arcaneindustry.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.firebearsstudio.arcaneindustry.items.ModItems;

public final class ModBlocks {

	public static Block tutorialBlock;
	public static BlockProperties propertyBlock;
	public static ModBlockOre tutorialOre;
	public static ModBlockMultiOre tutorialMultiOre;
	
	public static TutorialGrinder grinder;
	
	public static void createBlocks() {
		GameRegistry.registerBlock(tutorialBlock = new BasicBlock("tutorial_block").setLightLevel(1.0f), "tutorial_block");
		
		GameRegistry.registerBlock(propertyBlock = new BlockProperties("block_properties", Material.rock, 1.0F, 1.0F), ItemBlockMeta.class, "block_properties");
		
		GameRegistry.registerBlock(tutorialOre = new ModBlockOre("tutorial_ore", Material.rock, ModItems.tutorialItem, 2, 4), "tutorial_ore");
		GameRegistry.registerBlock(tutorialMultiOre = new ModBlockMultiOre("tutorial_multi_ore", Material.rock), "tutorial_multi_ore");
		
		GameRegistry.registerBlock(grinder = new TutorialGrinder("grinder"), "grinder");
	}
}
