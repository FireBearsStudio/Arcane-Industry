package com.firebearsstudio.arcaneindustry.mob;

import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import com.firebearsstudio.arcaneindustry.Main;

public class EntitySalamander {

	
	public static void mainRegistry() {
		registerEntity();
	}
	
	public static void registerEntity() {
		
		createEntity(EntitySalamanderMob.class, "Salamander", 0x000000, 0xFA9C19);
	}
	
	public static void createEntity(Class entityClass, String entityName, int solidColor, int spotColor) {
		int randomID = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(entityClass, entityName, randomID);
		EntityRegistry.registerModEntity(entityClass, entityName, randomID, Main.MOD_ID, 64, 1, true);
		EntityRegistry.addSpawn(entityClass, 2, 0, 1, EnumCreatureType.CREATURE, BiomeGenBase.forest);
		
		createEgg(randomID, solidColor, spotColor);
	}
	
	static void createEgg(int randomId, int solidColor, int spotColor) {
		EntityList.entityEggs.put(Integer.valueOf(randomId), new EntityList.EntityEggInfo(randomId, solidColor, spotColor));
	}
}
