package com.firebearsstudio.arcaneindustry.tileentity;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class ArcaneTileEntities {

	public static void init() {
		GameRegistry.registerTileEntity(GrinderTileEntity.class, "arcaneindustry_tile_entity_grinder");
		GameRegistry.registerTileEntity(InscriberTileEntity.class, "arcaneindustry_tile_entity_inscriber");
	}
}
