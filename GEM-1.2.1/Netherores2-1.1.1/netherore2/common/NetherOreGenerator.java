package netherore2.common;

import gemamethyst.common.GEM_Amethyst;
import gemcopper.common.GEM_Copper;
import gemlead.common.GEM_Lead;
import gemruby.common.GEM_Ruby;
import gemsilver.common.GEM_Silver;
import gemtin.common.GEM_Tin;
import gemtitanium.common.GEM_Titanium;
import gemtopaz.common.GEM_Topaz;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;
import netherore2.common.NetherOre2;

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
        for (int q=0;q<=4;q++) {
            int posX = i + random.nextInt(16);
            int posY = random.nextInt(108) + 10;
            int posZ = j + random.nextInt(16);
            (new WorldGenMinable(NetherOre2.netheroreAmethyst.blockID,5,Block.netherrack.blockID)).generate(world,random,posX,posY,posZ);
        }
        for (int q=0;q<=20;q++) {
            int posX = i + random.nextInt(16);
            int posY = random.nextInt(108) + 10;
            int posZ = j + random.nextInt(16);
            (new WorldGenMinable(NetherOre2.netheroreCopper.blockID,9,Block.netherrack.blockID)).generate(world,random,posX,posY,posZ);
        }
        for (int q=0;q<=18;q++) {
            int posX = i + random.nextInt(16);
            int posY = random.nextInt(108) + 10;
            int posZ = j + random.nextInt(16);
            (new WorldGenMinable(NetherOre2.netheroreLead.blockID,10,Block.netherrack.blockID)).generate(world,random,posX,posY,posZ);
        }
        for (int q=0;q<=4;q++) {
            int posX = i + random.nextInt(16);
            int posY = random.nextInt(108) + 10;
            int posZ = j + random.nextInt(16);
            (new WorldGenMinable(NetherOre2.netheroreRuby.blockID,5,Block.netherrack.blockID)).generate(world,random,posX,posY,posZ);
        }
        for (int q=0;q<=2;q++) {
            int posX = i + random.nextInt(16);
            int posY = random.nextInt(108) + 10;
            int posZ = j + random.nextInt(16);
            (new WorldGenMinable(NetherOre2.netheroreSilver.blockID,7,Block.netherrack.blockID)).generate(world,random,posX,posY,posZ);
        }
        for (int q=0;q<=18;q++) {
            int posX = i + random.nextInt(16);
            int posY = random.nextInt(108) + 10;
            int posZ = j + random.nextInt(16);
            (new WorldGenMinable(NetherOre2.netheroreTin.blockID,10,Block.netherrack.blockID)).generate(world,random,posX,posY,posZ);
        }
        for (int q=0;q<=6;q++) {
            int posX = i + random.nextInt(16);
            int posY = random.nextInt(108) + 10;
            int posZ = j + random.nextInt(16);
            (new WorldGenMinable(NetherOre2.netheroreTitanium.blockID,8,Block.netherrack.blockID)).generate(world,random,posX,posY,posZ);
        }
        for (int q=0;q<=4;q++) {
            int posX = i + random.nextInt(16);
            int posY = random.nextInt(108) + 10;
            int posZ = j + random.nextInt(16);
            (new WorldGenMinable(NetherOre2.netheroreTopaz.blockID,5,Block.netherrack.blockID)).generate(world,random,posX,posY,posZ);
        }
	}

}