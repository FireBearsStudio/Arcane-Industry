package com.firebearsstudio.arcaneindustry.items;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ArcaneItems {

	public static Item buttOfPower;
	public static Item blueRoughGem;
	public static Item redRoughGem;
	public static Item greenRoughGem;
	
	public static void createItems() {
		GameRegistry.registerItem(buttOfPower = new BasicItem("butt_of_power"), "butt_of_power");
		GameRegistry.registerItem(blueRoughGem = new BasicItem("blue_rough_gem"), "blue_rough_gem");
		GameRegistry.registerItem(redRoughGem = new BasicItem("red_rough_gem"), "red_rough_gem");
		GameRegistry.registerItem(greenRoughGem = new BasicItem("green_rough_gem"), "green_rough_gem");
	}
}
