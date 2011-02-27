package com.landsofnavia.mcandze.naviacore.permissions;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.landsofnavia.mcandze.naviacore.LogIt;
import com.landsofnavia.mcandze.naviacore.NaviaCore;
import com.nijiko.permissions.PermissionHandler;
import com.nijikokun.bukkit.Permissions.Permissions;

public class PermissionChecker {
	
	public static PermissionHandler permissions = null;
	
	public static void initialize(NaviaCore instance){
		Plugin test = instance.getServer().getPluginManager().getPlugin("Permissions");
		if (test != null){
			permissions = ((Permissions)test).Security;
			return;
		}
		LogIt.logWarning(instance.pluginName, "No permissions system enabled. Disabling all Navia plugins.");
		instance.getPluginManager().disablePlugin(instance);
	}
	
	public static boolean canPlayerUse(Player player, String node){
		if (isUsingPermissions()){
			if (permissions.has(player, node)){
				return true;
			}
			return false;
		}
		return true;
	}
	
	public static String getPrefix(Player player){
		if (isUsingPermissions()){
			return permissions.getGroupPrefix(permissions.getGroup(player.getName()));
		}
		return "";
	}
	
	public static String getGroup(Player player){
		if (isUsingPermissions()){
			return permissions.getGroup(player.getName());
		}
		return "";
	}
	
	
	
	public static boolean isUsingPermissions(){
		return permissions != null;
	}
}
