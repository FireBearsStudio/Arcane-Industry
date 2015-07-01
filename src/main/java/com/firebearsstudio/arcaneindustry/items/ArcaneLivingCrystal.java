package com.firebearsstudio.arcaneindustry.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ArcaneLivingCrystal extends BasicItem {

	public ArcaneLivingCrystal(String unlocalizedName) {
		super(unlocalizedName);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
        return true;
    }
}
