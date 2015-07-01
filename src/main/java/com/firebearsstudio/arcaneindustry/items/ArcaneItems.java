package com.firebearsstudio.arcaneindustry.items;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ArcaneItems {

	public static Item buttOfPower;
	public static Item blueRoughGem;
	public static Item redRoughGem;
	public static Item greenRoughGem;
	public static Item lifeCrystal;
	
	// dusts
	public static Item gemDust;
	public static Item dustIron;
	public static Item dustGold;
	public static Item dustInfernium;
	public static Item dustTruesilver;
	
	// ingots
	public static Item truesilverIngot;
	public static Item inferniumIngot;
	
	// conduits
	public static Item coalConduit;
	public static Item redstoneConduit;
	public static Item lapisConduit;
	public static Item enderPearlConduit;
	public static Item netherStarConduit;
	
	// frames
	public static Item ironFrame;
	public static Item goldFrame;
	public static Item diamondFrame;
	public static Item truesilverFrame;
	public static Item inferniumFrame;
	
	// rough frames
	public static Item ironFrameRoughGreen;
	public static Item ironFrameRoughRed;
	public static Item ironFrameRoughBlue;
	public static Item goldFrameRoughGreen;
	public static Item goldFrameRoughRed;
	public static Item goldFrameRoughBlue;
	public static Item diamondFrameRoughGreen;
	public static Item diamondFrameRoughRed;
	public static Item diamondFrameRoughBlue;
	public static Item truesilverFrameRoughGreen;
	public static Item truesilverFrameRoughRed;
	public static Item truesilverFrameRoughBlue;
	public static Item inferniumFrameRoughGreen;
	public static Item inferniumFrameRoughRed;
	public static Item inferniumFrameRoughBlue;
	
	// cut frames
	public static Item ironFrameCutGreen;
	public static Item ironFrameCutRed;
	public static Item ironFrameCutBlue;
	public static Item goldFrameCutGreen;
	public static Item goldFrameCutRed;
	public static Item goldFrameCutBlue;
	public static Item diamondFrameCutGreen;
	public static Item diamondFrameCutRed;
	public static Item diamondFrameCutBlue;
	public static Item truesilverFrameCutGreen;
	public static Item truesilverFrameCutRed;
	public static Item truesilverFrameCutBlue;
	public static Item inferniumFrameCutGreen;
	public static Item inferniumFrameCutRed;
	public static Item inferniumFrameCutBlue;
	
	public static MetaItem metaItem;
	
	// tools
	public static ItemArcaneSword greenGemSword;
	public static ItemArcanePickaxe greenGemPickaxe;
	public static ItemArcaneAxe greenGemAxe;
	public static ItemArcaneSpade greenGemSpade;
	public static ItemArcaneHoe greenGemHoe;
	
	public static ItemArcaneSword redGemSword;
	public static ItemArcanePickaxe redGemPickaxe;
	public static ItemArcaneAxe redGemAxe;
	public static ItemArcaneSpade redGemSpade;
	public static ItemArcaneHoe redGemHoe;
	
	public static ItemArcaneSword blueGemSword;
	public static ItemArcanePickaxe blueGemPickaxe;
	public static ItemArcaneAxe blueGemAxe;
	public static ItemArcaneSpade blueGemSpade;
	public static ItemArcaneHoe blueGemHoe;
	//public static ItemArcaneMultitool arcaneMulti;
	
	// armor
	public static ItemArcaneArmor greenGemHelmet;
	public static ItemArcaneArmor greenGemChestplate;
	public static ItemArcaneArmor greenGemLeggings;
	public static ItemArcaneArmor greenGemBoots;
	
	public static ItemArcaneArmor redGemHelmet;
	public static ItemArcaneArmor redGemChestplate;
	public static ItemArcaneArmor redGemLeggings;
	public static ItemArcaneArmor redGemBoots;
	
	public static ItemArcaneArmor blueGemHelmet;
	public static ItemArcaneArmor blueGemChestplate;
	public static ItemArcaneArmor blueGemLeggings;
	public static ItemArcaneArmor blueGemBoots;
	
	public static ArcaneItemFood arcaneCocoa;
	
	public static ToolMaterial GREEN_GEM = EnumHelper.addToolMaterial("GREEN_GEM", 3, 131, 7.0F, 1.0F, 0);
	public static ToolMaterial RED_GEM = EnumHelper.addToolMaterial("RED_GEM", 4, 450, 8.0F, 2.5F, 0);
	public static ToolMaterial BLUE_GEM = EnumHelper.addToolMaterial("BLUE_GEM", 5, 900, 10.0F, 4.0F, 0);
	
	public static ArmorMaterial GREEN_GEM_ARMOR = EnumHelper.addArmorMaterial("GREEN_GEM_ARMOR", "arcaneindustry:green_gem_armor", 20, new int[] {3, 8, 6, 3}, 10);
	public static ArmorMaterial RED_GEM_ARMOR = EnumHelper.addArmorMaterial("RED_GEM_ARMOR", "arcaneindustry:red_gem_armor", 30, new int[] {3, 8, 6, 3}, 20);
	public static ArmorMaterial BLUE_GEM_ARMOR = EnumHelper.addArmorMaterial("BLUE_GEM_ARMOR", "arcaneindustry:blue_gem_armor", 40, new int[] {3, 8, 6, 3}, 30);
	
	public static void createItems() {
		GameRegistry.registerItem(buttOfPower = new BasicItem("butt_of_power"), "butt_of_power");
		GameRegistry.registerItem(blueRoughGem = new BasicItem("blue_rough_gem"), "blue_rough_gem");
		GameRegistry.registerItem(redRoughGem = new BasicItem("red_rough_gem"), "red_rough_gem");
		GameRegistry.registerItem(greenRoughGem = new BasicItem("green_rough_gem"), "green_rough_gem");
		GameRegistry.registerItem(lifeCrystal = new ArcaneLivingCrystal("life_crystal"), "life_crystal");
		
		// dust
		GameRegistry.registerItem(gemDust = new BasicItem("gem_dust"), "gem_dust");
		GameRegistry.registerItem(dustIron = new BasicItem("iron_dust"), "iron_dust");
		GameRegistry.registerItem(dustGold = new BasicItem("gold_dust"), "gold_dust");
		GameRegistry.registerItem(dustInfernium = new BasicItem("infernium_dust"), "infernium_dust");
		GameRegistry.registerItem(dustTruesilver = new BasicItem("truesilver_dust"), "truesilver_dust");
		
		// ingots
		GameRegistry.registerItem(truesilverIngot = new BasicItem("truesilver_ingot"), "truesiver_ingot");
		GameRegistry.registerItem(inferniumIngot = new BasicItem("infernium_ingot"), "infernium_ingot");
		
		// conduits
		GameRegistry.registerItem(coalConduit = new BasicItem("coal_conduit"), "coal_conduit");
		GameRegistry.registerItem(redstoneConduit = new BasicItem("redstone_conduit"), "redstone_conduit");
		GameRegistry.registerItem(lapisConduit = new BasicItem("lapis_conduit"), "lapis_conduit");
		GameRegistry.registerItem(enderPearlConduit = new BasicItem("ender_pearl_conduit"), "ender_pearl_conduit");
		GameRegistry.registerItem(netherStarConduit = new BasicItem("nether_star_conduit"), "nether_star_conduit");
		
		// frames
		GameRegistry.registerItem(ironFrame = new BasicItem("iron_frame"), "iron_frame");
		GameRegistry.registerItem(goldFrame = new BasicItem("gold_frame"), "gold_frame");
		GameRegistry.registerItem(diamondFrame = new BasicItem("diamond_frame"), "diamond_frame");
		GameRegistry.registerItem(truesilverFrame = new BasicItem("truesilver_frame"), "truesilver_frame");
		GameRegistry.registerItem(inferniumFrame = new BasicItem("infernium_frame"), "infernium_frame");
		
		// rough frames
		GameRegistry.registerItem(ironFrameRoughGreen = new BasicItem("iron_frame_rough_green"), "iron_frame_rough_green");
		GameRegistry.registerItem(ironFrameRoughRed = new BasicItem("iron_frame_rough_red"), "iron_frame_rough_red");
		GameRegistry.registerItem(ironFrameRoughBlue = new BasicItem("iron_frame_rough_blue"), "iron_frame_rough_blue");
		GameRegistry.registerItem(goldFrameRoughGreen = new BasicItem("gold_frame_rough_green"), "gold_frame_rough_green");
		GameRegistry.registerItem(goldFrameRoughRed = new BasicItem("gold_frame_rough_red"), "gold_frame_rough_red");
		GameRegistry.registerItem(goldFrameRoughBlue = new BasicItem("gold_frame_rough_blue"), "gold_frame_rough_blue");
		GameRegistry.registerItem(diamondFrameRoughGreen = new BasicItem("diamond_frame_rough_green"), "diamond_frame_rough_green");
		GameRegistry.registerItem(diamondFrameRoughRed = new BasicItem("diamond_frame_rough_red"), "diamond_frame_rough_red");
		GameRegistry.registerItem(diamondFrameRoughBlue = new BasicItem("diamond_frame_rough_blue"), "diamond_frame_rough_blue");
		GameRegistry.registerItem(truesilverFrameRoughGreen = new BasicItem("truesilver_frame_rough_green"), "truesilver_frame_rough_green");
		GameRegistry.registerItem(truesilverFrameRoughRed = new BasicItem("truesilver_frame_rough_red"), "truesilver_frame_rough_red");
		GameRegistry.registerItem(truesilverFrameRoughBlue = new BasicItem("truesilver_frame_rough_blue"), "truesilver_frame_rough_blue");
		GameRegistry.registerItem(inferniumFrameRoughGreen = new BasicItem("infernium_frame_rough_green"), "infernium_frame_rough_green");
		GameRegistry.registerItem(inferniumFrameRoughRed = new BasicItem("infernium_frame_rough_red"), "infernium_frame_rough_red");
		GameRegistry.registerItem(inferniumFrameRoughBlue = new BasicItem("infernium_frame_rough_blue"), "infernium_frame_rough_blue");
		
		// cut frames
		GameRegistry.registerItem(ironFrameCutGreen = new BasicItem("iron_frame_cut_green"), "iron_frame_cut_green");
		GameRegistry.registerItem(ironFrameCutRed = new BasicItem("iron_frame_cut_red"), "iron_frame_cut_red");
		GameRegistry.registerItem(ironFrameCutBlue = new BasicItem("iron_frame_cut_blue"), "iron_frame_cut_blue");
		GameRegistry.registerItem(goldFrameCutGreen = new BasicItem("gold_frame_cut_green"), "gold_frame_cut_green");
		GameRegistry.registerItem(goldFrameCutRed = new BasicItem("gold_frame_cut_red"), "gold_frame_cut_red");
		GameRegistry.registerItem(goldFrameCutBlue = new BasicItem("gold_frame_cut_blue"), "gold_frame_cut_blue");
		GameRegistry.registerItem(diamondFrameCutGreen = new BasicItem("diamond_frame_cut_green"), "diamond_frame_cut_green");
		GameRegistry.registerItem(diamondFrameCutRed = new BasicItem("diamond_frame_cut_red"), "diamond_frame_cut_red");
		GameRegistry.registerItem(diamondFrameCutBlue = new BasicItem("diamond_frame_cut_blue"), "diamond_frame_cut_blue");
		GameRegistry.registerItem(truesilverFrameCutGreen = new BasicItem("truesilver_frame_cut_green"), "truesilver_frame_cut_green");
		GameRegistry.registerItem(truesilverFrameCutRed = new BasicItem("truesilver_frame_cut_red"), "truesilver_frame_cut_red");
		GameRegistry.registerItem(truesilverFrameCutBlue = new BasicItem("truesilver_frame_cut_blue"), "truesilver_frame_cut_blue");
		GameRegistry.registerItem(inferniumFrameCutGreen = new BasicItem("infernium_frame_cut_green"), "infernium_frame_cut_green");
		GameRegistry.registerItem(inferniumFrameCutRed = new BasicItem("infernium_frame_cut_red"), "infernium_frame_cut_red");
		GameRegistry.registerItem(inferniumFrameCutBlue = new BasicItem("infernium_frame_cut_blue"), "infernium_frame_cut_blue");
		
		GameRegistry.registerItem(metaItem = new MetaItem("meta_item"), "meta_item");
		
		GameRegistry.registerItem(greenGemSword = new ItemArcaneSword("green_gem_sword", GREEN_GEM), "green_gem_sword");
		GameRegistry.registerItem(greenGemPickaxe = new ItemArcanePickaxe("green_gem_pickaxe", GREEN_GEM), "green_gem_pickaxe");
		GameRegistry.registerItem(greenGemAxe = new ItemArcaneAxe("green_gem_axe", GREEN_GEM), "green_gem_axe");
		GameRegistry.registerItem(greenGemSpade = new ItemArcaneSpade("green_gem_spade", GREEN_GEM), "green_gem_spade");
		GameRegistry.registerItem(greenGemHoe = new ItemArcaneHoe("green_gem_hoe", GREEN_GEM), "green_gem_hoe");
		
		GameRegistry.registerItem(redGemSword = new ItemArcaneSword("red_gem_sword", RED_GEM), "red_gem_sword");
		GameRegistry.registerItem(redGemPickaxe = new ItemArcanePickaxe("red_gem_pickaxe", RED_GEM), "red_gem_pickaxe");
		GameRegistry.registerItem(redGemAxe = new ItemArcaneAxe("red_gem_axe", RED_GEM), "red_gem_axe");
		GameRegistry.registerItem(redGemSpade = new ItemArcaneSpade("red_gem_spade", RED_GEM), "red_gem_spade");
		GameRegistry.registerItem(redGemHoe = new ItemArcaneHoe("red_gem_hoe", RED_GEM), "red_gem_hoe");
		
		GameRegistry.registerItem(blueGemSword = new ItemArcaneSword("blue_gem_sword", BLUE_GEM), "blue_gem_sword");
		GameRegistry.registerItem(blueGemPickaxe = new ItemArcanePickaxe("blue_gem_pickaxe", BLUE_GEM), "blue_gem_pickaxe");
		GameRegistry.registerItem(blueGemAxe = new ItemArcaneAxe("blue_gem_axe", BLUE_GEM), "blue_gem_axe");
		GameRegistry.registerItem(blueGemSpade = new ItemArcaneSpade("blue_gem_spade", BLUE_GEM), "blue_gem_spade");
		GameRegistry.registerItem(blueGemHoe = new ItemArcaneHoe("blue_gem_hoe", BLUE_GEM), "blue_gem_hoe");
		//GameRegistry.registerItem(arcaneMulti = new ItemArcaneMultitool("arcane_multitool", GREEN_GEM), "arcane_multitool");
		
		GameRegistry.registerItem(greenGemHelmet = new ItemArcaneArmor("green_gem_helmet", GREEN_GEM_ARMOR, 1, 0), "green_gem_helmet");
		GameRegistry.registerItem(greenGemChestplate = new ItemArcaneArmor("green_gem_chestplate", GREEN_GEM_ARMOR, 1, 1), "green_gem_chestplate");
		GameRegistry.registerItem(greenGemLeggings = new ItemArcaneArmor("green_gem_leggings", GREEN_GEM_ARMOR, 2, 2), "green_gem_leggings");
		GameRegistry.registerItem(greenGemBoots = new ItemArcaneArmor("green_gem_boots", GREEN_GEM_ARMOR, 1, 3), "green_gem_boots");
		
		GameRegistry.registerItem(redGemHelmet = new ItemArcaneArmor("red_gem_helmet", RED_GEM_ARMOR, 1, 0), "red_gem_helmet");
		GameRegistry.registerItem(redGemChestplate = new ItemArcaneArmor("red_gem_chestplate", RED_GEM_ARMOR, 1, 1), "red_gem_chestplate");
		GameRegistry.registerItem(redGemLeggings = new ItemArcaneArmor("red_gem_leggings", RED_GEM_ARMOR, 2, 2), "red_gem_leggings");
		GameRegistry.registerItem(redGemBoots = new ItemArcaneArmor("red_gem_boots", RED_GEM_ARMOR, 1, 3), "red_gem_boots");
		
		GameRegistry.registerItem(blueGemHelmet = new ItemArcaneArmor("blue_gem_helmet", BLUE_GEM_ARMOR, 1, 0), "blue_gem_helmet");
		GameRegistry.registerItem(blueGemChestplate = new ItemArcaneArmor("blue_gem_chestplate", BLUE_GEM_ARMOR, 1, 1), "blue_gem_chestplate");
		GameRegistry.registerItem(blueGemLeggings = new ItemArcaneArmor("blue_gem_leggings", BLUE_GEM_ARMOR, 2, 2), "blue_gem_leggings");
		GameRegistry.registerItem(blueGemBoots = new ItemArcaneArmor("blue_gem_boots", BLUE_GEM_ARMOR, 1, 3), "blue_gem_boots");
		/*GameRegistry.registerItem(arcaneCocoa = (ArcaneItemFood) new ArcaneItemFood("arcane_cocoa", 2, 0.2F, false,
				new PotionEffect(Potion.moveSpeed.id, 1200, 1),
				new PotionEffect(Potion.jump.id, 600, 0),
				new PotionEffect(Potion.regeneration.id, 200, 1))
				.setAlwaysEdible(), "arcane_cocoa");*/
	}
}
