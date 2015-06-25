package com.firebearsstudio.arcaneindustry.world;

import java.util.Random;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import com.firebearsstudio.arcaneindustry.blocks.ArcaneBlocks;

public class ArcaneWorldGen implements IWorldGenerator {

	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.getDimensionId()) {
		case 0: //Overworld
			this.runGenerator(this.gen_green_gem_ore, world, rand, chunkX, chunkZ, 20, 0, 64);
			this.runGenerator(this.gen_red_gem_ore, world, rand, chunkX, chunkZ, 20, 0, 32);
			this.runGenerator(this.gen_blue_gem_ore, world, rand, chunkX, chunkZ, 20, 0, 16);
			break;
		case -1: //Nether
			
			break;
		case 1: //End
			
			break;
		}
	}
	
	private WorldGenerator gen_green_gem_ore; //Generates Green Gem Ore(used in Overworld)
	private WorldGenerator gen_red_gem_ore; //Generates Red Gem Ore(used in Overworld)
	private WorldGenerator gen_blue_gem_ore; //Generates Blue Gem Ore(used in Overworld)
	
	public ArcaneWorldGen() {
		this.gen_green_gem_ore = new WorldGenMinable(ArcaneBlocks.greenGemOre.getDefaultState(), 8);
		this.gen_red_gem_ore = new WorldGenMinable(ArcaneBlocks.redGemOre.getDefaultState(), 8);
		this.gen_blue_gem_ore = new WorldGenMinable(ArcaneBlocks.blueGemOre.getDefaultState(), 8);
	}
	
	private void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn,
			int minHeight, int maxHeight) {
		if(minHeight < 0 || maxHeight > 256 || minHeight > maxHeight) {
			throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");
		}
		int heightDiff = maxHeight - minHeight + 1;
		for(int i = 0; i < chancesToSpawn; i++) {
			int x = chunk_X * 16 + rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightDiff);
			int z = chunk_Z * 16 + rand.nextInt(16);
			generator.generate(world, rand, new BlockPos(x, y, z));
		}
	}
}
