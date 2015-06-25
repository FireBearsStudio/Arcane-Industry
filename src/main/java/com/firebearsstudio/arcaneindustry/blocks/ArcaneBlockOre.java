package com.firebearsstudio.arcaneindustry.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ArcaneBlockOre extends Block {
	
	private Item drop;
	private int meta;
	private int least_quantity;
	private int most_quantity;
	
	protected ArcaneBlockOre(String unlocalizedName, Material mat, Item drop, int meta, int least, int most) {
		super(mat);
		this.drop = drop;
		this.meta = meta;
		this.least_quantity = least;
		this.most_quantity = most;
		this.setHarvestLevel("pickaxe", 1);
		this.setHardness(10.0F);
		this.setResistance(15.0F);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	protected ArcaneBlockOre(String unlocalizedName, Material mat, Item drop, int least_quantity, int most_quantity) {
		this(unlocalizedName, mat, drop, 0, least_quantity, most_quantity);
	}	
	
	protected ArcaneBlockOre(String unlocalizedName, Material mat, Item drop) {
		this(unlocalizedName, mat, drop, 1, 1);
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
