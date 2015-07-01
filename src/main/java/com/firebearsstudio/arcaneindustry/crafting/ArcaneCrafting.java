package com.firebearsstudio.arcaneindustry.crafting;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.OreDictionary.OreRegisterEvent;
import net.minecraftforge.oredict.ShapedOreRecipe;

import com.firebearsstudio.arcaneindustry.blocks.ArcaneBlocks;
import com.firebearsstudio.arcaneindustry.items.ArcaneItems;
import com.firebearsstudio.arcaneindustry.recipes.GrinderRecipes;

public class ArcaneCrafting {

	public static void oreRegistration() {
		// ores
		OreDictionary.registerOre("orePeridot", ArcaneBlocks.greenGemOre);
		OreDictionary.registerOre("oreRuby", ArcaneBlocks.redGemOre);
		OreDictionary.registerOre("oreSapphire", ArcaneBlocks.blueGemOre);

		// items
		OreDictionary.registerOre("gemPeridot", ArcaneItems.greenRoughGem);
		OreDictionary.registerOre("gemRuby", ArcaneItems.redRoughGem);
		OreDictionary.registerOre("gemSapphire", ArcaneItems.blueRoughGem);
		OreDictionary.registerOre("dustGem", ArcaneItems.gemDust);
		OreDictionary.registerOre("dustIron", ArcaneItems.dustIron);
		OreDictionary.registerOre("dustGold", ArcaneItems.dustGold);
		OreDictionary.registerOre("gemLife", ArcaneItems.lifeCrystal);
	}
	
	public static void initCrafting() {
		// SHAPED
		GameRegistry.addRecipe(new ItemStack(ArcaneBlocks.testBlock), "AA", "AA", 'A', ArcaneItems.gemDust);
		// armor
		// -green
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ArcaneItems.arcaneHelmet), "AAA", "A A", "   ", 'A', "gemPeridot"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ArcaneItems.arcaneChestplate), "A A", "AAA", "AAA", 'A', "gemPeridot"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ArcaneItems.arcaneLeggings), "AAA", "A A", "A A", 'A', "gemPeridot"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ArcaneItems.arcaneBoots), "A A", "A A", "   ", 'A', "gemPeridot"));
		// -blue
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ArcaneItems.arcaneHelmet), "AAA", "A A", "   ", 'A', "gemRuby"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ArcaneItems.arcaneChestplate), "A A", "AAA", "AAA", 'A', "gemRuby"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ArcaneItems.arcaneLeggings), "AAA", "A A", "A A", 'A', "gemRuby"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ArcaneItems.arcaneBoots), "A A", "A A", "   ", 'A', "gemRuby"));
		// -red
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ArcaneItems.arcaneHelmet), "AAA", "A A", "   ", 'A', "gemSapphire"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ArcaneItems.arcaneChestplate), "A A", "AAA", "AAA", 'A', "gemSapphire"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ArcaneItems.arcaneLeggings), "AAA", "A A", "A A", 'A', "gemSapphire"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ArcaneItems.arcaneBoots), "A A", "A A", "   ", 'A', "gemSapphire"));
		
		// tools
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ArcaneItems.arcanePickaxe), "AAA", " S ", " S ", 'A', "gemPeridot", 'S', "woodStick"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ArcaneItems.arcaneSword), " A ", " A ", " S ", 'A', "gemPeridot", 'S', "woodStick"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ArcaneItems.arcaneSword), "  A", "  A", "  S", 'A', "gemPeridot", 'S', "woodStick"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ArcaneItems.arcaneSword), "A  ", "A  ", "S  ", 'A', "gemPeridot", 'S', "woodStick"));
		
		// SHAPELESS
		GameRegistry.addShapelessRecipe(new ItemStack(ArcaneItems.buttOfPower), Items.redstone, new ItemStack(Items.dye, 1, 4));
		
		// SMELTING
		addSmeltingRecipe("dustIron", "ingotIron", 0.1F);
		addSmeltingRecipe("dustGold", "ingotGold", 0.1F);
		
		// GRINDER
		// -grinder itself
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ArcaneBlocks.grinder), 
				"   ", 
				"ABC", 
				"DDD", 'A', "plankWood", 'B', "stickWood", 'C', "stone", 'D', Blocks.stone_slab));
		
		// grinder recipes
		// gem dust
		GrinderRecipes.instance().addGrindingRecipe("gemSapphire", "dustGem", 1, 0.2F);
		GrinderRecipes.instance().addGrindingRecipe("gemPeridot", "dustGem", 1, 0.2F);
		GrinderRecipes.instance().addGrindingRecipe("gemRuby", "dustGem", 1, 0.2F);
		// ores
		// -metals
		GrinderRecipes.instance().addGrindingRecipe("oreIron", "dustIron", 2, 0.1F);
		GrinderRecipes.instance().addGrindingRecipe("oreGold", "dustGold", 2, 0.1F);
		// -gems
		GrinderRecipes.instance().addGrindingRecipe("orePeridot", "gemPeridot", 2, 0.2F);
		GrinderRecipes.instance().addGrindingRecipe("oreRuby", "gemRuby", 2, 0.2F);
		GrinderRecipes.instance().addGrindingRecipe("oreSapphire", "gemSapphire", 2, 0.2F);
		// -misc
		GrinderRecipes.instance().addGrindingRecipe("oreRedstone", "dustRedstone", 10, 0.2F);
		GrinderRecipes.instance().addGrindingRecipe("glowstone", "dustGlowstone", 4, 0.2F);
		GrinderRecipes.instance().addGrindingRecipe("oreDiamond", "gemDiamond", 2, 1.0F);
		GrinderRecipes.instance().addGrindingRecipe("oreEmerald", "gemEmerald", 2, 1.0F);
		GrinderRecipes.instance().addGrindingRecipe("oreCoal", new ItemStack(Items.coal, 4), 0.2F);
		GrinderRecipes.instance().addGrindingRecipe("oreLapis", "gemLapis", 6, 1.0F);
		GrinderRecipes.instance().addGrindingRecipe("oreQuartz", "gemQuartz", 4, 1.0F);
		
		// INSCRIBER
		// -inscriber itself
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ArcaneBlocks.inscriber), 
				"ABC", 
				"SLS", 
				"SSS", 'A', "gemPeridot", 'B', "gemRuby", 'C', "gemSapphire", 'S', "stone", 'L', "gemLife"));

		// inscriber recipes
		
	}
	
	static void addSmeltingRecipe(String input, String output, float exp) {
		for (ItemStack item1 : OreDictionary.getOres(input)) {
			for (ItemStack item2 : OreDictionary.getOres(output)) {
				if (item1 != null && item2 != null) {
					GameRegistry.addSmelting(item1, item2, exp);
				}
			}
		}
	}
}
