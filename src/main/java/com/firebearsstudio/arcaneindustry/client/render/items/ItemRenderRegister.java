package com.firebearsstudio.arcaneindustry.client.render.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
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
		reg(ArcaneItems.gemDust);
		reg(ArcaneItems.dustIron);
		reg(ArcaneItems.dustGold);
		
		reg(ArcaneItems.metaItem, 0, "meta_item_white");
		reg(ArcaneItems.metaItem, 1, "meta_item_black");
		
		reg(ArcaneItems.arcaneSword);
		reg(ArcaneItems.arcanePickaxe);
		reg(ArcaneItems.arcaneMulti);
		
		reg(ArcaneItems.arcaneHelmet);
		reg(ArcaneItems.arcaneChestplate);
		reg(ArcaneItems.arcaneLeggings);
		reg(ArcaneItems.arcaneBoots);
		
		reg(ArcaneItems.arcaneCocoa);
		
	}
	
	public static void preInit() {
		ModelBakery.addVariantName(ArcaneItems.metaItem, "arcaneindustry:meta_item_white", "arcaneindustry:meta_item_black");
	}
	
	public static void reg(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0,
				new ModelResourceLocation(modid + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
	
	public static void reg(Item item, int meta, String file) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation(modid + ":" + file, "inventory"));
	}
}
