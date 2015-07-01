package com.firebearsstudio.arcaneindustry.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ArcaneBasicNetherOre extends Block {

	private Item drop;
	private int meta;
	private int least_quantity;
	private int most_quantity;

	protected ArcaneBasicNetherOre(String unlocalizedName, Material mat, float hardness, float resistance, String tool, int harvestLvl) {
		super(mat);
		this.setUnlocalizedName(unlocalizedName);
		this.setHardness(hardness);
		this.setResistance(resistance);
		this.setHarvestLevel(tool, harvestLvl);
		this.setStepSound(soundTypeStone);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	@Override
	public Item getItemDropped(IBlockState blockstate, Random rand, int fortune) {
		return this.drop;
	}
	
	@Override
	public int damageDropped(IBlockState blockstate) {
		return this.meta;
	}
	
	@Override
	public int quantityDropped(IBlockState blockstate, int fortune, Random rand) {
		if(this.least_quantity >= this.most_quantity) {
			return this.least_quantity;
		}
		return this.least_quantity + rand.nextInt(this.most_quantity - this.least_quantity + fortune + 1);
	}
}
