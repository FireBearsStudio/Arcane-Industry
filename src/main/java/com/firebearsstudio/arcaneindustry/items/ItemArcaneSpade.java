package com.firebearsstudio.arcaneindustry.items;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSpade;

public class ItemArcaneSpade extends ItemSpade {

	public ItemArcaneSpade(String unlocalizedName, ToolMaterial material) {
		super(material);
		
		this.setUnlocalizedName(unlocalizedName);
	}
}
