package com.landsofnavia.mcandze.naviacore;

import org.bukkit.event.server.PluginEvent;
import org.bukkit.event.server.ServerListener;

import com.landsofnavia.mcandze.naviacore.plugins.NaviaPlugin;

public class NaviaServerListener extends ServerListener{
	NaviaCore naviaCore;
	
	public NaviaServerListener(NaviaCore instance){
		this.naviaCore = instance;
	}
	
	@Override
	public void onPluginEnabled(PluginEvent event){
		try {
			NaviaPlugin plugin = NaviaPlugin.valueOf(event.getPlugin().getDescription().getName().toUpperCase());
			switch(plugin){
			// ADD PLUGINS HERE
			case NAVIACHAT: naviaCore.getManager().setUsingNaviaChat(true);
			case NAVIACHAR: naviaCore.getManager().setUsingNaviaChar(true);
			case NAVIABANK: naviaCore.getManager().setUsingNaviaBank(true);
			}
		} catch (Exception e){
			
		}
	}

	@Override
	public void onPluginDisabled(PluginEvent event) {
		try {
			NaviaPlugin plugin = NaviaPlugin.valueOf(event.getPlugin().getDescription().getName().toUpperCase());
			switch(plugin){
			// ADD PLUGINS HERE
			case NAVIACHAT: naviaCore.getManager().setUsingNaviaChat(false);
			case NAVIACHAR: naviaCore.getManager().setUsingNaviaChar(false);
			case NAVIABANK: naviaCore.getManager().setUsingNaviaBank(false);
			}
		} catch (Exception e){
			
		}
	}
	
	
}
