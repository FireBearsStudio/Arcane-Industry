package com.firebearsstudio.arcaneindustry.crafting;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.firebearsstudio.arcaneindustry.blocks.ArcaneBlocks;
import com.firebearsstudio.arcaneindustry.items.ArcaneItems;

public class ArcaneCrafting {

	public static void initCrafting() {
		GameRegistry.addRecipe(new ItemStack(ArcaneBlocks.testBlock), "AA", "AA", 'A', ArcaneItems.gemDust);
		
		GameRegistry.addShapelessRecipe(new ItemStack(ArcaneItems.buttOfPower), Items.redstone, new ItemStack(Items.dye, 1, 4));
		
		GameRegistry.addSmelting(ArcaneItems.blueRoughGem, new ItemStack(ArcaneItems.gemDust), 1.0f);
		GameRegistry.addSmelting(ArcaneItems.redRoughGem, new ItemStack(ArcaneItems.gemDust), 1.0f);
		GameRegistry.addSmelting(ArcaneItems.greenRoughGem, new ItemStack(ArcaneItems.gemDust), 1.0f);
		
		GameRegistry.addSmelting(ArcaneBlocks.blueGemOre, new ItemStack(ArcaneItems.blueRoughGem, 3), 0.5F);
		GameRegistry.addSmelting(ArcaneBlocks.redGemOre, new ItemStack(ArcaneItems.redRoughGem, 3), 0.5F);
		GameRegistry.addSmelting(ArcaneBlocks.greenGemOre, new ItemStack(ArcaneItems.greenRoughGem, 3), 0.5F);
		
		// grinder
		// GrinderRecipes.instance().addGrindingRecipe(new ItemStack(Items.baked_potato, 2), new ItemStack(Items.diamond), 1.0F); // example
	}
}
