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
	public static Item gemDust;
	public static Item dustIron;
	public static Item dustGold;
	
	public static MetaItem metaItem;
	
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
		GameRegistry.registerItem(gemDust = new BasicItem("gem_dust"), "gem_dust");
		GameRegistry.registerItem(dustIron = new BasicItem("iron_dust"), "iron_dust");
		GameRegistry.registerItem(dustGold = new BasicItem("gold_dust"), "gold_dust");
		
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
