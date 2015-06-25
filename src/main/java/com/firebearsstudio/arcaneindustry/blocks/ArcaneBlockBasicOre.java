package com.firebearsstudio.arcaneindustry.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class ArcaneBlockBasicOre extends Block {

	protected ArcaneBlockBasicOre(String unlocalizedName, Material mat, float hardness, float resistance, String tool, int harvestLvl) {
		super(mat);
		this.setUnlocalizedName(unlocalizedName);
		this.setHardness(hardness);
		this.setResistance(resistance);
		this.setHarvestLevel(tool, harvestLvl);
		this.setStepSound(soundTypeStone);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
}
