package com.firebearsstudio.arcaneindustry.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ArcaneBasicNetherOre extends Block {
	
	protected ArcaneBasicNetherOre(String unlocalizedName, Material mat, float hardness, float resistance, String tool, int harvestLvl) {
		super(mat);
		this.setUnlocalizedName(unlocalizedName);
		this.setHardness(hardness);
		this.setResistance(resistance);
		this.setHarvestLevel(tool, harvestLvl);
		this.setStepSound(soundTypeStone);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
}
