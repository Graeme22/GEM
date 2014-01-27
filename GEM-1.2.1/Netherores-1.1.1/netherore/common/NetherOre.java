package netherore.common;

import gem.common.GEM;
import gemamethyst.common.GEM_Amethyst;
import gemcopper.common.CopperGenerator;
import gemcopper.common.GEM_Copper;
import gemlead.common.GEM_Lead;
import gemruby.common.GEM_Ruby;
import gemsilver.common.GEM_Silver;
import gemtin.common.GEM_Tin;
import gemtitanium.common.GEM_Titanium;
import gemtopaz.common.GEM_Topaz;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid="GEMNetherores",name="GEM Netherores",version="1.1.1")
@NetworkMod(clientSideRequired=true)
public class NetherOre {

	@Instance(value="GEMNetherores")
	public static NetherOre instance;	
	@SidedProxy(clientSide="netherore.common.client.ClientProxy",serverSide="netherore.common.CommonProxy")
    public static CommonProxy proxy;
	
	public static Block netheroreDiamond,netheroreEmerald,netheroreGold,netheroreIron,netheroreLapis,netheroreRedstone;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
	    netheroreDiamond = (new BlockOre(2536)).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("netheroreDiamond").setTextureName("netherores:diamond_netherore").setCreativeTab(GEM.tabGEM);
	    netheroreEmerald = (new BlockOre(2537)).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("netheroreEmerald").setTextureName("netherores:emerald_netherore").setCreativeTab(GEM.tabGEM);
	    netheroreGold = (new BlockOre(2538)).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("netheroreGold").setTextureName("netherores:gold_netherore").setCreativeTab(GEM.tabGEM);
	    netheroreIron = (new BlockOre(2539)).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("netheroreIron").setTextureName("netherores:iron_netherore").setCreativeTab(GEM.tabGEM);
	    netheroreLapis = (new BlockOre(2540)).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("netheroreLapis").setTextureName("netherores:lapis_netherore").setCreativeTab(GEM.tabGEM);
	    netheroreRedstone = (new BlockOre(2541)).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("netheroreRedstone").setTextureName("netherores:redstone_netherore").setCreativeTab(GEM.tabGEM);
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event) {
		proxy.registerRenderers();
		LanguageRegistry.addName(netheroreDiamond,"Diamond Netherore");
		LanguageRegistry.addName(netheroreEmerald,"Emerald Netherore");
		LanguageRegistry.addName(netheroreGold,"Gold Netherore");
		LanguageRegistry.addName(netheroreIron,"Iron Netherore");
		LanguageRegistry.addName(netheroreLapis,"Lapis Netherore");
		LanguageRegistry.addName(netheroreRedstone,"Redstone Netherore");
		
		GameRegistry.registerBlock(netheroreDiamond,"netheroreDiamond");
		GameRegistry.registerBlock(netheroreEmerald,"netheroreEmerald");
		GameRegistry.registerBlock(netheroreGold,"netheroreGold");
		GameRegistry.registerBlock(netheroreIron,"netheroreIron");
		GameRegistry.registerBlock(netheroreLapis,"netheroreLapis");
		GameRegistry.registerBlock(netheroreRedstone,"netheroreRedstone");
		
		GameRegistry.registerWorldGenerator(new NetherOreGenerator());
		
		GameRegistry.addSmelting(NetherOre.netheroreDiamond.blockID,new ItemStack(Item.diamond),1.0F);
		GameRegistry.addSmelting(NetherOre.netheroreEmerald.blockID,new ItemStack(Item.emerald),0.9F);
		GameRegistry.addSmelting(NetherOre.netheroreGold.blockID,new ItemStack(Item.ingotGold),1.0F);
		GameRegistry.addSmelting(NetherOre.netheroreIron.blockID,new ItemStack(Item.ingotIron),0.4F);
		GameRegistry.addSmelting(NetherOre.netheroreLapis.blockID,new ItemStack(Item.dyePowder,9),0.5F);
		GameRegistry.addSmelting(NetherOre.netheroreRedstone.blockID,new ItemStack(Item.redstone,9),0.2F);

		MinecraftForge.setBlockHarvestLevel(NetherOre.netheroreDiamond,"pickaxe",2);
		MinecraftForge.setBlockHarvestLevel(NetherOre.netheroreEmerald,"pickaxe",2);
		MinecraftForge.setBlockHarvestLevel(NetherOre.netheroreGold,"pickaxe",2);
		MinecraftForge.setBlockHarvestLevel(NetherOre.netheroreIron,"pickaxe",1);
		MinecraftForge.setBlockHarvestLevel(NetherOre.netheroreLapis,"pickaxe",2);
		MinecraftForge.setBlockHarvestLevel(NetherOre.netheroreRedstone,"pickaxe",2);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {}
	
}