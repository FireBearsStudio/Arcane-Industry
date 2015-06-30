package com.firebearsstudio.arcaneindustry.recipes;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.google.common.collect.Maps;

public class GrinderRecipes {

	static final GrinderRecipes grindingBase = new GrinderRecipes();
	// the list of grinding results
	final Map grindingList = Maps.newHashMap();
	final Map experienceList = Maps.newHashMap();
	
	public static GrinderRecipes instance() {
		return grindingBase;
	}
	
	GrinderRecipes() {
		addGrindingRecipe(new ItemStack(Item.getItemFromBlock(Blocks.stonebrick)), new ItemStack(Item.getItemFromBlock(Blocks.gravel)), 0.7F);
		addGrindingRecipe(new ItemStack(Item.getItemFromBlock(Blocks.stone_slab)), new ItemStack(Item.getItemFromBlock(Blocks.gravel)), 0.7F);
		addGrindingRecipe(new ItemStack(Item.getItemFromBlock(Blocks.stone_slab2)), new ItemStack(Item.getItemFromBlock(Blocks.gravel)), 0.7F);
		addGrindingRecipe(new ItemStack(Item.getItemFromBlock(Blocks.stone_stairs)), new ItemStack(Item.getItemFromBlock(Blocks.gravel)), 0.7F);
		addGrindingRecipe(new ItemStack(Item.getItemFromBlock(Blocks.stone)), new ItemStack(Item.getItemFromBlock(Blocks.gravel)), 0.7F);
		addGrindingRecipe(new ItemStack(Item.getItemFromBlock(Blocks.gravel)), new ItemStack(Items.flint), 0.7F);
		addGrindingRecipe(new ItemStack(Item.getItemFromBlock(Blocks.glass)), new ItemStack(Item.getItemFromBlock(Blocks.sand)), 0.7F);
		addGrindingRecipe(new ItemStack(Item.getItemFromBlock(Blocks.cobblestone)), new ItemStack(Item.getItemFromBlock(Blocks.gravel)), 0.7F);
		addGrindingRecipe(new ItemStack(Item.getItemFromBlock(Blocks.dirt)), new ItemStack(Item.getItemFromBlock(Blocks.sand)), 0.7F);
	}
	
	public void addGrindingRecipe(ItemStack stackIn, ItemStack stackOut, float exp) {
		grindingList.put(stackIn, stackOut);
		experienceList.put(stackOut, Float.valueOf(exp));
	}
	
	// Returns the grinding result of an item
	public ItemStack getGrindingResult(ItemStack stack) {
		Iterator iterator = grindingList.entrySet().iterator();
		Entry entry;
		
		do {
			if (!iterator.hasNext()) {
				return null;
			}
			
			entry = (Entry)iterator.next();
		} while (!areItemStacksEqual(stack, (ItemStack)entry.getKey()));
		
		return (ItemStack)entry.getValue();
	}
	
	boolean areItemStacksEqual(ItemStack stack1, ItemStack stack2) {
		return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
	}
	
	public Map getGrindingList() {
		return grindingList;
	}
	
	public float getGrindingExprience(ItemStack stack) {
		Iterator iterator = experienceList.entrySet().iterator();
		Entry entry;
		
		do {
			if (!iterator.hasNext()) {
				return 0.0F;
			}
			
			entry = (Entry)iterator.next();
		} while (!areItemStacksEqual(stack, (ItemStack)entry.getKey()));
		
		return ((Float)entry.getValue()).floatValue();
	}
}
