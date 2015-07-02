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

import com.google.common.collect.Maps;

public class InscriberRecipes {

	static final InscriberRecipes inscribingBase = new InscriberRecipes();
	// the list of inscribing results
	final Map inscribingList = Maps.newHashMap();
	final Map experienceList = Maps.newHashMap();
	
	public static InscriberRecipes instance() {
		return inscribingBase;
	}
	
	InscriberRecipes() {
		// add base recipes here
		
	}
	
	public void addInscribingRecipe(ItemStack stackIn, ItemStack stackOut, float exp) {
		inscribingList.put(stackIn, stackOut);
		experienceList.put(stackOut, Float.valueOf(exp));
	}
	
	public void addInscribingRecipe(String input, ItemStack stackOut, float exp) {
		List<ItemStack> list1 = OreDictionary.getOres(input);

		for (int i = 0; i < list1.size(); i++) {
			if (list1.get(i) != null) {
				ItemStack stack1 = list1.get(i).copy();

				inscribingList.put(stack1, stackOut);
				experienceList.put(stackOut, Float.valueOf(exp));			
			}
		}
	}
	
	public void addInscribingRecipe(ItemStack stackIn, String output, int amountOutput, float exp) {
		List<ItemStack> list1 = OreDictionary.getOres(output);

		for (int i = 0; i < list1.size(); i++) {
			if (list1.get(i) != null) {
				ItemStack stack1 = list1.get(i).copy();
				stack1.stackSize = amountOutput;

				inscribingList.put(stackIn, stack1);
				experienceList.put(stack1, Float.valueOf(exp));			
			}
		}
	}
	
	public void addInscribingRecipe(String input, String output, int amountOutput, float exp) {
		List<ItemStack> list1 = OreDictionary.getOres(input);
		List<ItemStack> list2 = OreDictionary.getOres(output);

		for (int i = 0; i < list1.size(); i++) {
			for (int j = 0; j < list2.size(); j++) {
				if (list1.get(i) != null && list2.get(j) != null) {
					ItemStack stack1 = list1.get(i).copy();
					ItemStack stack2 = list2.get(j).copy();
					stack2.stackSize = amountOutput;

					inscribingList.put(stack1, stack2);
					experienceList.put(stack2, Float.valueOf(exp));			
				}
			}
		}
	}
	
	public void addInscribingRecipe(String input, int amountInput, ItemStack stackOut, float exp) {
		List<ItemStack> list1 = OreDictionary.getOres(input);

		for (int i = 0; i < list1.size(); i++) {
			if (list1.get(i) != null) {
				ItemStack stack1 = list1.get(i).copy();
				stack1.stackSize = amountInput;

				inscribingList.put(stack1, stackOut);
				experienceList.put(stackOut, Float.valueOf(exp));			
			}
		}
	}
	
	// Returns the inscribing result of an item
	public ItemStack getInscribingResult(ItemStack stack) {
		Iterator iterator = inscribingList.entrySet().iterator();
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
	
	public Map getInscribingList() {
		return inscribingList;
	}
	
	public float getInscribingExprience(ItemStack stack) {
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
