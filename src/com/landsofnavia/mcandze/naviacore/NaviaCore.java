package com.landsofnavia.mcandze.naviacore;

import org.bukkit.Server;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.landsofnavia.mcandze.naviacore.plugins.NaviaManager;

public class NaviaCore extends JavaPlugin{
	private NaviaManager manager;
	private PluginManager pm;
	public String pluginName = "Core";
	public static Server server;
	
	@Override
	public void onEnable(){
		server = getServer();
		this.manager = new NaviaManager();
		this.pm = getServer().getPluginManager();
	}
	
	@Override
	public void onDisable(){
		// ADD PLUGINS HERE
		if (manager.isUsingNaviaBank()){
			pm.disablePlugin(pm.getPlugin("NaviaBank"));
			LogIt.logInfo(pluginName, "Disabled NaviaBank");
		}
		if (manager.isUsingNaviaChar()){
			pm.disablePlugin(pm.getPlugin("NaviaChar"));
			LogIt.logInfo(pluginName, "Disabled NaviaChar");
		}
		if (manager.isUsingNaviaChat()){
			pm.disablePlugin(pm.getPlugin("NaviaChat"));
			LogIt.logInfo(pluginName, "Disabled NaviaChat");
		}
	}
	
	

	public NaviaManager getManager(){
		return this.manager;
	}
	
	public PluginManager getPluginManager(){
		return pm;
	}
	
	
}
