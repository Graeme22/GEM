package netherore.common;

import gemlead.common.GEM_Lead;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;
import netherore.common.NetherOre;

public class NetherOreGenerator implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId){
			case -1:
			    generateNether(world, random, chunkX * 16, chunkZ * 16);
			    break;
			case 0:
			    generateSurface(world, random, chunkX * 16, chunkZ * 16);
			    break;
			case 1:
			    generateEnd(world, random, chunkX * 16, chunkZ * 16);
			    break;
		}
	}

	private void generateEnd(World world, Random random, int i, int j) {}

	private void generateSurface(World world, Random random, int i, int j) {}

	private void generateNether(World world, Random random, int i, int j) {
        for (int q=0;q<=1;q++) {
            int posX = i + random.nextInt(16);
            int posY = random.nextInt(108) + 10;
            int posZ = j + random.nextInt(16);
            (new WorldGenMinable(NetherOre.netheroreDiamond.blockID,8,Block.netherrack.blockID)).generate(world,random,posX,posY,posZ);
        }
        for (int q=0;q<=3;q++) {
            int posX = i + random.nextInt(16);
            int posY = random.nextInt(108) + 10;
            int posZ = j + random.nextInt(16);
            (new WorldGenMinable(NetherOre.netheroreEmerald.blockID,2,Block.netherrack.blockID)).generate(world,random,posX,posY,posZ);
        }
        for (int q=0;q<=2;q++) {
            int posX = i + random.nextInt(16);
            int posY = random.nextInt(108) + 10;
            int posZ = j + random.nextInt(16);
            (new WorldGenMinable(NetherOre.netheroreGold.blockID,6,Block.netherrack.blockID)).generate(world,random,posX,posY,posZ);
        }
        for (int q=0;q<=20;q++) {
            int posX = i + random.nextInt(16);
            int posY = random.nextInt(108) + 10;
            int posZ = j + random.nextInt(16);
            (new WorldGenMinable(NetherOre.netheroreIron.blockID,10,Block.netherrack.blockID)).generate(world,random,posX,posY,posZ);
        }
        for (int q=0;q<=4;q++) {
            int posX = i + random.nextInt(16);
            int posY = random.nextInt(108) + 10;
            int posZ = j + random.nextInt(16);
            (new WorldGenMinable(NetherOre.netheroreLapis.blockID,3,Block.netherrack.blockID)).generate(world,random,posX,posY,posZ);
        }
        for (int q=0;q<=8;q++) {
            int posX = i + random.nextInt(16);
            int posY = random.nextInt(108) + 10;
            int posZ = j + random.nextInt(16);
            (new WorldGenMinable(NetherOre.netheroreRedstone.blockID,6,Block.netherrack.blockID)).generate(world,random,posX,posY,posZ);
        }
	}

}