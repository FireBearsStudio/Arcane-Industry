package com.firebearsstudio.arcaneindustry.crafting;

import java.util.List;

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
import com.firebearsstudio.arcaneindustry.recipes.InscriberRecipes;

public class ArcaneCrafting {

	public static void oreRegistration() {
		// ores
		OreDictionary.registerOre("orePeridot", ArcaneBlocks.greenGemOre);
		OreDictionary.registerOre("oreRuby", ArcaneBlocks.redGemOre);
		OreDictionary.registerOre("oreSapphire", ArcaneBlocks.blueGemOre);
		OreDictionary.registerOre("oreInfernium", ArcaneBlocks.inferniumOre);
		OreDictionary.registerOre("oreTruesilver", ArcaneBlocks.truesilverOre);
		
		// dust
		OreDictionary.registerOre("dustGem", ArcaneItems.gemDust);
		OreDictionary.registerOre("dustIron", ArcaneItems.dustIron);
		OreDictionary.registerOre("dustGold", ArcaneItems.dustGold);
		OreDictionary.registerOre("dustInfernium", ArcaneItems.dustInfernium);
		OreDictionary.registerOre("dustTruesilver", ArcaneItems.dustTruesilver);

		// items
		OreDictionary.registerOre("gemPeridot", ArcaneItems.greenRoughGem);
		OreDictionary.registerOre("gemRuby", ArcaneItems.redRoughGem);
		OreDictionary.registerOre("gemSapphire", ArcaneItems.blueRoughGem);
		OreDictionary.registerOre("gemLife", ArcaneItems.lifeCrystal);
		
		// ingots
		OreDictionary.registerOre("ingotTruesilver", ArcaneItems.truesilverIngot);
		OreDictionary.registerOre("ingotInfernium", ArcaneItems.inferniumIngot);
	}
	
	public static void initCrafting() {
		// SHAPED
		GameRegistry.addRecipe(new ItemStack(ArcaneBlocks.testBlock), "AA", "AA", 'A', ArcaneItems.gemDust);
		// armor
		// -green
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ArcaneItems.greenGemHelmet), "AAA", "A A", "   ", 'A', "gemPeridot"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ArcaneItems.greenGemChestplate), "A A", "AAA", "AAA", 'A', "gemPeridot"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ArcaneItems.greenGemLeggings), "AAA", "A A", "A A", 'A', "gemPeridot"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ArcaneItems.greenGemBoots), "A A", "A A", "   ", 'A', "gemPeridot"));
		// -red
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ArcaneItems.redGemHelmet), "AAA", "A A", "   ", 'A', "gemRuby"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ArcaneItems.redGemChestplate), "A A", "AAA", "AAA", 'A', "gemRuby"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ArcaneItems.redGemLeggings), "AAA", "A A", "A A", 'A', "gemRuby"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ArcaneItems.redGemBoots), "A A", "A A", "   ", 'A', "gemRuby"));
		// -blue
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ArcaneItems.blueGemHelmet), "AAA", "A A", "   ", 'A', "gemSapphire"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ArcaneItems.blueGemChestplate), "A A", "AAA", "AAA", 'A', "gemSapphire"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ArcaneItems.blueGemLeggings), "AAA", "A A", "A A", 'A', "gemSapphire"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ArcaneItems.blueGemBoots), "A A", "A A", "   ", 'A', "gemSapphire"));
		
		// tools
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ArcaneItems.greenGemPickaxe), "AAA", " S ", " S ", 'A', "gemPeridot", 'S', "woodStick"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ArcaneItems.greenGemSword), " A ", " A ", " S ", 'A', "gemPeridot", 'S', "woodStick"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ArcaneItems.greenGemSword), "  A", "  A", "  S", 'A', "gemPeridot", 'S', "woodStick"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ArcaneItems.greenGemSword), "A  ", "A  ", "S  ", 'A', "gemPeridot", 'S', "woodStick"));
		// -red
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ArcaneItems.redGemPickaxe), "AAA", " S ", " S ", 'A', "gemRuby", 'S', "woodStick"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ArcaneItems.redGemSword), " A ", " A ", " S ", 'A', "gemRuby", 'S', "woodStick"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ArcaneItems.redGemSword), "  A", "  A", "  S", 'A', "gemRuby", 'S', "woodStick"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ArcaneItems.redGemSword), "A  ", "A  ", "S  ", 'A', "gemRuby", 'S', "woodStick"));
		// -blue
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ArcaneItems.blueGemPickaxe), "AAA", " S ", " S ", 'A', "gemSapphire", 'S', "woodStick"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ArcaneItems.blueGemSword), " A ", " A ", " S ", 'A', "gemSapphire", 'S', "woodStick"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ArcaneItems.blueGemSword), "  A", "  A", "  S", 'A', "gemSapphire", 'S', "woodStick"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ArcaneItems.blueGemSword), "A  ", "A  ", "S  ", 'A', "gemSapphire", 'S', "woodStick"));
		
		// frames
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ArcaneItems.ironFrame), "A A", " B ", "A A", 'A', "ingotIron", 'B', ArcaneItems.coalConduit));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ArcaneItems.goldFrame), "A A", " B ", "A A", 'A', "ingotGold", 'B', ArcaneItems.redstoneConduit));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ArcaneItems.diamondFrame), "A A", " B ", "A A", 'A', "gemDiamond", 'B', ArcaneItems.lapisConduit));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ArcaneItems.truesilverFrame), "A A", " B ", "A A", 'A', "ingotTruesilver", 'B', ArcaneItems.enderPearlConduit));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ArcaneItems.inferniumFrame), "A A", " B ", "A A", 'A', "ingotInfernium", 'B', ArcaneItems.netherStarConduit));
		
		// SHAPELESS
		GameRegistry.addShapelessRecipe(new ItemStack(ArcaneItems.buttOfPower), Items.redstone, new ItemStack(Items.dye, 1, 4));
		
		// SMELTING
		addSmeltingRecipe("dustIron", "ingotIron", 1, 0.1F);
		addSmeltingRecipe("dustGold", "ingotGold", 1, 0.1F);
		addSmeltingRecipe("oreInfernium", "ingotInfernium", 1, 0.3F);
		addSmeltingRecipe("dustInfernium", "ingotInfernium", 1, 0.2F);
		
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
		GrinderRecipes.instance().addGrindingRecipe("oreInfernium", "dustInfernium", 2, 0.3F);
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
		// conduits
		InscriberRecipes.instance().addInscribingRecipe(new ItemStack(ArcaneItems.coalConduit), new ItemStack(Items.coal, 1), 0.1F);
		InscriberRecipes.instance().addInscribingRecipe(new ItemStack(ArcaneItems.redstoneConduit), "dustRedstone", 1, 0.1F);
		InscriberRecipes.instance().addInscribingRecipe(new ItemStack(ArcaneItems.lapisConduit), "gemLapis", 1, 0.1F);
		InscriberRecipes.instance().addInscribingRecipe(new ItemStack(ArcaneItems.enderPearlConduit), new ItemStack(Items.ender_pearl, 1), 0.1F);
		InscriberRecipes.instance().addInscribingRecipe(new ItemStack(ArcaneItems.netherStarConduit), new ItemStack(Items.nether_star, 1), 0.1F);
		
		// cut frames
		// -iron frame cut
		InscriberRecipes.instance().addInscribingRecipe(new ItemStack(ArcaneItems.ironFrameRoughGreen), new ItemStack(ArcaneItems.ironFrameCutGreen), 0.5F);
		InscriberRecipes.instance().addInscribingRecipe(new ItemStack(ArcaneItems.ironFrameRoughRed), new ItemStack(ArcaneItems.ironFrameCutRed), 0.5F);
		InscriberRecipes.instance().addInscribingRecipe(new ItemStack(ArcaneItems.ironFrameRoughBlue), new ItemStack(ArcaneItems.ironFrameCutBlue), 0.5F);
		// -gold frame cut
		InscriberRecipes.instance().addInscribingRecipe(new ItemStack(ArcaneItems.goldFrameRoughGreen), new ItemStack(ArcaneItems.goldFrameCutGreen), 0.5F);
		InscriberRecipes.instance().addInscribingRecipe(new ItemStack(ArcaneItems.goldFrameRoughRed), new ItemStack(ArcaneItems.goldFrameCutRed), 0.5F);
		InscriberRecipes.instance().addInscribingRecipe(new ItemStack(ArcaneItems.goldFrameRoughBlue), new ItemStack(ArcaneItems.goldFrameCutBlue), 0.5F);
		// -diamond frame cut
		InscriberRecipes.instance().addInscribingRecipe(new ItemStack(ArcaneItems.diamondFrameRoughGreen), new ItemStack(ArcaneItems.diamondFrameCutGreen), 0.5F);
		InscriberRecipes.instance().addInscribingRecipe(new ItemStack(ArcaneItems.diamondFrameRoughRed), new ItemStack(ArcaneItems.diamondFrameCutRed), 0.5F);
		InscriberRecipes.instance().addInscribingRecipe(new ItemStack(ArcaneItems.diamondFrameRoughBlue), new ItemStack(ArcaneItems.diamondFrameCutBlue), 0.5F);
		// -truesilver frame cut
		InscriberRecipes.instance().addInscribingRecipe(new ItemStack(ArcaneItems.truesilverFrameRoughGreen), new ItemStack(ArcaneItems.truesilverFrameCutGreen), 0.5F);
		InscriberRecipes.instance().addInscribingRecipe(new ItemStack(ArcaneItems.truesilverFrameRoughRed), new ItemStack(ArcaneItems.truesilverFrameCutRed), 0.5F);
		InscriberRecipes.instance().addInscribingRecipe(new ItemStack(ArcaneItems.truesilverFrameRoughBlue), new ItemStack(ArcaneItems.truesilverFrameCutBlue), 0.5F);
		// -infernium frame cut
		InscriberRecipes.instance().addInscribingRecipe(new ItemStack(ArcaneItems.inferniumFrameRoughGreen), new ItemStack(ArcaneItems.inferniumFrameCutGreen), 0.5F);
		InscriberRecipes.instance().addInscribingRecipe(new ItemStack(ArcaneItems.inferniumFrameRoughRed), new ItemStack(ArcaneItems.inferniumFrameCutRed), 0.5F);
		InscriberRecipes.instance().addInscribingRecipe(new ItemStack(ArcaneItems.inferniumFrameRoughBlue), new ItemStack(ArcaneItems.inferniumFrameCutBlue), 0.5F);
	}

	static void addSmeltingRecipe(String input, String output, int amountOutput, float exp) {
		List<ItemStack> list1 = OreDictionary.getOres(input);
		List<ItemStack> list2 = OreDictionary.getOres(output);

		for (int i = 0; i < list1.size(); i++) {
			for (int j = 0; j < list2.size(); j++) {
				if (list1.get(i) != null && list2.get(j) != null) {
					ItemStack stack1 = list1.get(i).copy();
					ItemStack stack2 = list2.get(j).copy();
					stack2.stackSize = amountOutput;

					GameRegistry.addSmelting(stack1, stack2, exp);
				}
			}
		}
	}
	
	static void addSmeltingRecipe(String input, ItemStack stackOut, float exp) {
		List<ItemStack> list1 = OreDictionary.getOres(input);

		for (int i = 0; i < list1.size(); i++) {
			if (list1.get(i) != null) {
				ItemStack stack1 = list1.get(i).copy();
				
				GameRegistry.addSmelting(stack1, stackOut, exp);
			}
		}
	}

	public void addInscribingRecipe(ItemStack stackIn, String output, int amountOutput, float exp) {
		List<ItemStack> list1 = OreDictionary.getOres(output);

		for (int i = 0; i < list1.size(); i++) {
			if (list1.get(i) != null) {
				ItemStack stack1 = list1.get(i).copy();
				stack1.stackSize = amountOutput;

				GameRegistry.addSmelting(stackIn, stack1, exp);			
			}
		}
	}
	
}
