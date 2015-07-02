package com.firebearsstudio.arcaneindustry.mob;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.firebearsstudio.arcaneindustry.Main;

@SideOnly(Side.CLIENT)
public class RenderSalamanderMob extends RenderLiving {

	static final ResourceLocation mobTextures = new ResourceLocation(Main.MOD_ID + ":textures/entity/Salamander.png");
	
	public RenderSalamanderMob(RenderManager p_i46153_1_,
			ModelBase par1ModelBase, float par2) {
		super(p_i46153_1_, par1ModelBase, par2);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return mobTextures;
	}

}
