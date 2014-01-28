package netherore2.common;

import gem.common.GEM;
import gemamethyst.common.GEM_Amethyst;
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

@Mod(modid="GEMNetherores2",name="GEM Netherores 2",version="1.1.1")
@NetworkMod(clientSideRequired=true)
public class NetherOre2 {

	@Instance(value="GEMNetherores2")
	public static NetherOre2 instance;	
	@SidedProxy(clientSide="netherore2.common.client.ClientProxy",serverSide="netherore2.common.CommonProxy")
    public static CommonProxy proxy;
	
	public static Block netheroreAmethyst,netheroreCopper,netheroreLead,netheroreRuby,netheroreSilver,netheroreTin,netheroreTitanium,netheroreTopaz;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
	    netheroreAmethyst = (new BlockOre(2542)).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("netheroreAmethyst").setTextureName("netherores2:amethyst_netherore").setCreativeTab(GEM.tabGEM);
	    netheroreCopper = (new BlockOre(2543)).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("netheroreCopper").setTextureName("netherores2:copper_netherore").setCreativeTab(GEM.tabGEM);
	    netheroreLead = (new BlockOre(2544)).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("netheroreLead").setTextureName("netherores2:lead_netherore").setCreativeTab(GEM.tabGEM);
	    netheroreRuby = (new BlockOre(2545)).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("netheroreRuby").setTextureName("netherores2:ruby_netherore").setCreativeTab(GEM.tabGEM);
	    netheroreSilver = (new BlockOre(2546)).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("netheroreSilver").setTextureName("netherores2:silver_netherore").setCreativeTab(GEM.tabGEM);
	    netheroreTin = (new BlockOre(2547)).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("netheroreTin").setTextureName("netherores2:tin_netherore").setCreativeTab(GEM.tabGEM);
	    netheroreTitanium = (new BlockOre(2548)).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("netheroreTitanium").setTextureName("netherores2:titanium_netherore").setCreativeTab(GEM.tabGEM);
	    netheroreTopaz = (new BlockOre(2549)).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("netheroreTopaz").setTextureName("netherores2:topaz_netherore").setCreativeTab(GEM.tabGEM);
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event) {
		proxy.registerRenderers();
		LanguageRegistry.addName(netheroreAmethyst,"Amethyst Netherore");
		LanguageRegistry.addName(netheroreCopper,"Copper Netherore");
		LanguageRegistry.addName(netheroreLead,"Lead Netherore");
		LanguageRegistry.addName(netheroreRuby,"Ruby Netherore");
		LanguageRegistry.addName(netheroreSilver,"Silver Netherore");
		LanguageRegistry.addName(netheroreTin,"Tin Netherore");
		LanguageRegistry.addName(netheroreTitanium,"Titanium Netherore");
		LanguageRegistry.addName(netheroreTopaz,"Topaz Netherore");
		
		GameRegistry.registerBlock(netheroreAmethyst,"netheroreDiamond");
		GameRegistry.registerBlock(netheroreCopper,"netheroreEmerald");
		GameRegistry.registerBlock(netheroreLead,"netheroreGold");
		GameRegistry.registerBlock(netheroreRuby,"netheroreIron");
		GameRegistry.registerBlock(netheroreSilver,"netheroreLapis");
		GameRegistry.registerBlock(netheroreTin,"netheroreRedstone");
		GameRegistry.registerBlock(netheroreTitanium,"netheroreTitanium");
		GameRegistry.registerBlock(netheroreTopaz,"netheroreTopaz");
		
		GameRegistry.registerWorldGenerator(new NetherOreGenerator());
		
		GameRegistry.addSmelting(NetherOre2.netheroreAmethyst.blockID,new ItemStack(GEM_Amethyst.amethyst),0.5F);
		GameRegistry.addSmelting(NetherOre2.netheroreCopper.blockID,new ItemStack(GEM_Copper.ingotCopper),0.3F);
		GameRegistry.addSmelting(NetherOre2.netheroreLead.blockID,new ItemStack(GEM_Lead.ingotLead),0.1F);
		GameRegistry.addSmelting(NetherOre2.netheroreRuby.blockID,new ItemStack(GEM_Ruby.ruby),0.5F);
		GameRegistry.addSmelting(NetherOre2.netheroreSilver.blockID,new ItemStack(GEM_Silver.ingotSilver),0.9F);
		GameRegistry.addSmelting(NetherOre2.netheroreTin.blockID,new ItemStack(GEM_Tin.ingotTin),0.1F);
		GameRegistry.addSmelting(NetherOre2.netheroreTitanium.blockID,new ItemStack(GEM_Titanium.ingotTitanium),0.5F);
		GameRegistry.addSmelting(NetherOre2.netheroreTopaz.blockID,new ItemStack(GEM_Topaz.topaz),0.5F);

		MinecraftForge.setBlockHarvestLevel(NetherOre2.netheroreAmethyst,"pickaxe",2);
		MinecraftForge.setBlockHarvestLevel(NetherOre2.netheroreCopper,"pickaxe",1);
		MinecraftForge.setBlockHarvestLevel(NetherOre2.netheroreLead,"pickaxe",1);
		MinecraftForge.setBlockHarvestLevel(NetherOre2.netheroreRuby,"pickaxe",2);
		MinecraftForge.setBlockHarvestLevel(NetherOre2.netheroreSilver,"pickaxe",2);
		MinecraftForge.setBlockHarvestLevel(NetherOre2.netheroreTin,"pickaxe",1);
		MinecraftForge.setBlockHarvestLevel(NetherOre2.netheroreTitanium,"pickaxe",1);
		MinecraftForge.setBlockHarvestLevel(NetherOre2.netheroreTopaz,"pickaxe",2);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {}
	
}