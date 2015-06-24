package com.firebearsstudio.arcaneindustry.client.render.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

import com.firebearsstudio.arcaneindustry.Main;
import com.firebearsstudio.arcaneindustry.items.ArcaneItems;

public class ItemRenderRegister {

	public static String modid = Main.MOD_ID;
	
	public static void registerItemRenderer() {
		reg(ArcaneItems.buttOfPower);
		reg(ArcaneItems.blueRoughGem);
		reg(ArcaneItems.redRoughGem);
		reg(ArcaneItems.greenRoughGem);
		
	}
	
	public static void reg(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0,
				new ModelResourceLocation(modid + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
