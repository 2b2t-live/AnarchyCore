package com.tbttk.anarchycore.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.tbttk.anarchycore.Main;

public class ElytraCommand implements CommandExecutor{
	
	public ElytraCommand() {
		System.out.println("Loaded Bypass Command!");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] arg) {
		
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("AnarchyCore.Admin.ElytraFly")) {
				if(arg.length == 1) {
					if(arg[0].equalsIgnoreCase("bypass")) {
						if (!Main.bypass.containsKey(p.getUniqueId())) {
							Main.bypass.put(p.getUniqueId(), true);
							p.sendMessage(ChatColor.GOLD + "Added {" + ChatColor.YELLOW+p.getUniqueId()+ChatColor.GOLD + "} to the bypass array");
						}else {
							if(Main.bypass.containsKey(p.getUniqueId())) {
								Main.bypass.remove(p.getUniqueId());
								p.sendMessage(ChatColor.GOLD + "Removed {" + ChatColor.YELLOW+p.getUniqueId()+ChatColor.GOLD + "} from the bypass array");
							}
						}
				    	}else if(arg[0].equalsIgnoreCase("notif")) {
				    		if (!Main.notif.containsKey(p.getUniqueId())){
					            Main.notif.put(p.getUniqueId(), true);
					            p.sendMessage(ChatColor.GOLD + "Added {" + ChatColor.YELLOW+p.getUniqueId()+ChatColor.GOLD + "} to the array!");
				            }else {
				            if(Main.notif.containsKey(p.getUniqueId())) {
					            Main.notif.remove(p.getUniqueId());
					            p.sendMessage(ChatColor.GOLD + "Removed {" + ChatColor.YELLOW+p.getUniqueId()+ChatColor.GOLD + "} from the array");
				            }
			            }
			    	}
				}else {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&eUsage &6/elytra (bypass / notif)"));
				}
			}else {
				sender.sendMessage(ChatColor.RED + "You don't have permission to do this.");
			}
		} else {
			sender.sendMessage(ChatColor.RED + "This command can only be executed by a player!");
		}
		return true;
	}
	public static Boolean A() {
		return true;
	}
}
