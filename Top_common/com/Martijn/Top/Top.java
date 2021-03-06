package com.Martijn.Top;

import java.io.File;

import net.minecraft.creativetab.CreativeTabs;

import com.Martijn.Top.block.ModBlocks;
import com.Martijn.Top.configuration.ConfigurationHander;
import com.Martijn.Top.core.handler.LocalizationHandler;
import com.Martijn.Top.core.proxy.CommonProxy;
import com.Martijn.Top.creativetab.TabTop;
import com.Martijn.Top.item.ModItems;
import com.Martijn.Top.lib.Reference;
import com.Martijn.Top.world.generator.TopWorldGenerator;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Top
 * 
 * Top
 * 
 * @author Martijn
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

@Mod(
		modid= Reference.MOD_ID ,
		name = Reference.MOD_NAME,
		version = Reference.VERSION)

@NetworkMod(
		channels = {Reference.CHANNEL_NAME},
		serverSideRequired = false,
		clientSideRequired = true)

public class Top {
	
	TopWorldGenerator worldGenerator = new TopWorldGenerator();
	
	@SidedProxy(
			clientSide = Reference.CLIENT_PROXY_LOCATION,
			serverSide = Reference.COMMON_PROXY_LOCATION)
	public static CommonProxy proxy;
	
	public static CreativeTabs TabTop = new TabTop(CreativeTabs.getNextID(), Reference.MOD_ID);
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event){		
		LocalizationHandler.loadLanguages();
		
		ConfigurationHander.init(new File(event.getModConfigurationDirectory().getAbsolutePath() + File.separator + Reference.CHANNEL_NAME + File.separator + Reference.MOD_ID + ".cfg"));
		
		ModBlocks.BlocksInit();
		
		ModItems.ItemInit();
		
		GameRegistry.registerWorldGenerator(worldGenerator);
	}
	@Init
	public void init(FMLInitializationEvent event){
		
	}
	@PostInit
	public void postInit(FMLPostInitializationEvent event){
		
	}

}
