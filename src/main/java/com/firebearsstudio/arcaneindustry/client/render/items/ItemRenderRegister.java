package com.firebearsstudio.arcaneindustry.client.render.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

import com.firebearsstudio.arcaneindustry.Main;
import com.firebearsstudio.arcaneindustry.items.ArcaneItems;
import com.firebearsstudio.arcaneindustry.items.ArcaneLivingCrystal;

public class ItemRenderRegister {

	public static String modid = Main.MOD_ID;
	
	public static void registerItemRenderer() {
		reg(ArcaneItems.buttOfPower);
		reg(ArcaneItems.blueRoughGem);
		reg(ArcaneItems.redRoughGem);
		reg(ArcaneItems.greenRoughGem);
		reg(ArcaneItems.lifeCrystal);
		
		// dust
		reg(ArcaneItems.gemDust);
		reg(ArcaneItems.dustIron);
		reg(ArcaneItems.dustGold);
		reg(ArcaneItems.dustInfernium);
		reg(ArcaneItems.dustTruesilver);

		// ingots
		reg(ArcaneItems.truesilverIngot);
		reg(ArcaneItems.inferniumIngot);
		
		// conduits
		reg(ArcaneItems.coalConduit);
		reg(ArcaneItems.redstoneConduit);
		reg(ArcaneItems.lapisConduit);
		reg(ArcaneItems.enderPearlConduit);
		reg(ArcaneItems.netherStarConduit);
		
		// frames
		reg(ArcaneItems.ironFrame);
		reg(ArcaneItems.goldFrame);
		reg(ArcaneItems.diamondFrame);
		reg(ArcaneItems.truesilverFrame);
		reg(ArcaneItems.inferniumFrame);
		
		// rough frames
		reg(ArcaneItems.ironFrameRoughGreen);
		reg(ArcaneItems.ironFrameRoughRed);
		reg(ArcaneItems.ironFrameRoughBlue);
		reg(ArcaneItems.goldFrameRoughGreen);
		reg(ArcaneItems.goldFrameRoughRed);
		reg(ArcaneItems.goldFrameRoughBlue);
		reg(ArcaneItems.diamondFrameRoughGreen);
		reg(ArcaneItems.diamondFrameRoughRed);
		reg(ArcaneItems.diamondFrameRoughBlue);
		reg(ArcaneItems.truesilverFrameRoughGreen);
		reg(ArcaneItems.truesilverFrameRoughRed);
		reg(ArcaneItems.truesilverFrameRoughBlue);
		reg(ArcaneItems.inferniumFrameRoughGreen);
		reg(ArcaneItems.inferniumFrameRoughRed);
		reg(ArcaneItems.inferniumFrameRoughBlue);
		
		// cut frames
		reg(ArcaneItems.ironFrameCutGreen);
		reg(ArcaneItems.ironFrameCutRed);
		reg(ArcaneItems.ironFrameCutBlue);
		reg(ArcaneItems.goldFrameCutGreen);
		reg(ArcaneItems.goldFrameCutRed);
		reg(ArcaneItems.goldFrameCutBlue);
		reg(ArcaneItems.diamondFrameCutGreen);
		reg(ArcaneItems.diamondFrameCutRed);
		reg(ArcaneItems.diamondFrameCutBlue);
		reg(ArcaneItems.truesilverFrameCutGreen);
		reg(ArcaneItems.truesilverFrameCutRed);
		reg(ArcaneItems.truesilverFrameCutBlue);
		reg(ArcaneItems.inferniumFrameCutGreen);
		reg(ArcaneItems.inferniumFrameCutRed);
		reg(ArcaneItems.inferniumFrameCutBlue);
		
		
		//reg(ArcaneItems.metaItem, 0, "meta_item_white");
		//reg(ArcaneItems.metaItem, 1, "meta_item_black");

		// tools
		// -green gem
		reg(ArcaneItems.greenGemSword);
		reg(ArcaneItems.greenGemPickaxe);
		reg(ArcaneItems.greenGemSpade);
		reg(ArcaneItems.greenGemAxe);
		reg(ArcaneItems.greenGemHoe);
		// -red gem
		reg(ArcaneItems.redGemSword);
		reg(ArcaneItems.redGemPickaxe);
		reg(ArcaneItems.redGemSpade);
		reg(ArcaneItems.redGemAxe);
		reg(ArcaneItems.redGemHoe);
		// -blue gem
		reg(ArcaneItems.blueGemSword);
		reg(ArcaneItems.blueGemPickaxe);
		reg(ArcaneItems.blueGemSpade);
		reg(ArcaneItems.blueGemAxe);
		reg(ArcaneItems.blueGemHoe);
		
		// armor
		// -green gem
		reg(ArcaneItems.greenGemHelmet);
		reg(ArcaneItems.greenGemChestplate);
		reg(ArcaneItems.greenGemLeggings);
		reg(ArcaneItems.greenGemBoots);
		// -red gem
		reg(ArcaneItems.redGemHelmet);
		reg(ArcaneItems.redGemChestplate);
		reg(ArcaneItems.redGemLeggings);
		reg(ArcaneItems.redGemBoots);
		// -blue gem
		reg(ArcaneItems.blueGemHelmet);
		reg(ArcaneItems.blueGemChestplate);
		reg(ArcaneItems.blueGemLeggings);
		reg(ArcaneItems.blueGemBoots);
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
