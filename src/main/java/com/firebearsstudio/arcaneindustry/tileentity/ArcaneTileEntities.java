package com.firebearsstudio.arcaneindustry.tileentity;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModTileEntities {

	public static void init() {
		GameRegistry.registerTileEntity(GrinderTileEntity.class, "arcaneindustry_tile_entity_grinder");
	}
}
