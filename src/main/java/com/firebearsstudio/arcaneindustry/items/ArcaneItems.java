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
	
	public static ItemArcaneSword arcaneSword;
	public static ItemArcanePickaxe arcanePickaxe;
	public static ItemArcaneMultitool arcaneMulti;
	
	public static ItemArcaneArmor arcaneHelmet;
	public static ItemArcaneArmor arcaneChestplate;
	public static ItemArcaneArmor arcaneLeggings;
	public static ItemArcaneArmor arcaneBoots;
	
	public static ArcaneItemFood arcaneCocoa;
	
	public static ToolMaterial GEM = EnumHelper.addToolMaterial("GEM", 3, 131, 15.0F, 1.0F, 0);
	
	public static ArmorMaterial GEM_ARMOR = EnumHelper.addArmorMaterial("GEM_ARMOR", "arcaneindustry:gem_armor", 16, new int[] {3, 8, 6, 3}, 30); 
	
	public static void createItems() {
		GameRegistry.registerItem(buttOfPower = new BasicItem("butt_of_power"), "butt_of_power");
		GameRegistry.registerItem(blueRoughGem = new BasicItem("blue_rough_gem"), "blue_rough_gem");
		GameRegistry.registerItem(redRoughGem = new BasicItem("red_rough_gem"), "red_rough_gem");
		GameRegistry.registerItem(greenRoughGem = new BasicItem("green_rough_gem"), "green_rough_gem");
		GameRegistry.registerItem(gemDust = new BasicItem("gem_dust"), "gem_dust");
		GameRegistry.registerItem(dustIron = new BasicItem("iron_dust"), "iron_dust");
		GameRegistry.registerItem(dustGold = new BasicItem("gold_dust"), "gold_dust");
		
		GameRegistry.registerItem(metaItem = new MetaItem("meta_item"), "meta_item");
		
		GameRegistry.registerItem(arcaneSword = new ItemArcaneSword("arcane_sword", GEM), "arcane_sword");
		GameRegistry.registerItem(arcanePickaxe = new ItemArcanePickaxe("arcane_pickaxe", GEM), "arcane_pickaxe");
		GameRegistry.registerItem(arcaneMulti = new ItemArcaneMultitool("arcane_multitool", GEM), "arcane_multitool");
		
		GameRegistry.registerItem(arcaneHelmet = new ItemArcaneArmor("arcane_helmet", GEM_ARMOR, 1, 0), "arcane_helmet");
		GameRegistry.registerItem(arcaneChestplate = new ItemArcaneArmor("arcane_chestplate", GEM_ARMOR, 1, 1), "arcane_chestplate");
		GameRegistry.registerItem(arcaneLeggings = new ItemArcaneArmor("arcane_leggings", GEM_ARMOR, 2, 2), "arcane_leggings");
		GameRegistry.registerItem(arcaneBoots = new ItemArcaneArmor("arcane_boots", GEM_ARMOR, 1, 3), "arcane_boots");
		
		GameRegistry.registerItem(arcaneCocoa = (ArcaneItemFood) new ArcaneItemFood("arcane_cocoa", 2, 0.2F, false,
				new PotionEffect(Potion.moveSpeed.id, 1200, 1),
				new PotionEffect(Potion.jump.id, 600, 0),
				new PotionEffect(Potion.regeneration.id, 200, 1))
				.setAlwaysEdible(), "arcane_cocoa");
	}
}
