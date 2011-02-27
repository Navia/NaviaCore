package com.landsofnavia.mcandze.naviacore;

import java.util.logging.Logger;

import org.bukkit.plugin.Plugin;

public class LogIt {
	
	private static Logger log = Logger.getLogger("Minecraft");
	
	public static void logInfo(String plugin, String message){
		log.info(bracketize(plugin, message));
	}
	
	public static void logWarning(String plugin, String message){
		log.warning(bracketize(plugin, message));
	}
	
	private static String bracketize(String plugin, String message){
		return "[Navia][" + plugin + "] " + message; 
	}
}
