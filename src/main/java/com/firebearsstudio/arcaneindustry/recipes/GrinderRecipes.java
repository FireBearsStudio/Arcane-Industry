package com.firebearsstudio.arcaneindustry.recipes;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.firebearsstudio.arcaneindustry.blocks.ArcaneBlocks;
import com.firebearsstudio.arcaneindustry.items.ArcaneItems;
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
	
	public void addGrindingRecipe(String input, ItemStack stackOut, float exp) {
		List<ItemStack> list1 = OreDictionary.getOres(input);

		for (int i = 0; i < list1.size(); i++) {
			if (list1.get(i) != null) {
				ItemStack stack1 = list1.get(i).copy();

				grindingList.put(stack1, stackOut);
				experienceList.put(stackOut, Float.valueOf(exp));			
			}
		}
	}
	
	public void addGrindingRecipe(ItemStack stackIn, String output, int amountOutput, float exp) {
		List<ItemStack> list1 = OreDictionary.getOres(output);

		for (int i = 0; i < list1.size(); i++) {
			if (list1.get(i) != null) {
				ItemStack stack1 = list1.get(i).copy();
				stack1.stackSize = amountOutput;

				grindingList.put(stackIn, stack1);
				experienceList.put(stack1, Float.valueOf(exp));			
			}
		}
	}
	
	public void addGrindingRecipe(String input, String output, int amountOutput, float exp) {
		List<ItemStack> list1 = OreDictionary.getOres(input);
		List<ItemStack> list2 = OreDictionary.getOres(output);

		for (int i = 0; i < list1.size(); i++) {
			for (int j = 0; j < list2.size(); j++) {
				if (list1.get(i) != null && list2.get(j) != null) {
					ItemStack stack1 = list1.get(i).copy();
					ItemStack stack2 = list2.get(j).copy();
					stack2.stackSize = amountOutput;

					grindingList.put(stack1, stack2);
					experienceList.put(stack2, Float.valueOf(exp));			
				}
			}
		}
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
