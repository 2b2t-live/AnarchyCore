package com.tbttk.anarchycore;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathMsgs implements Listener{
	
	public DeathMsgs() {
		System.out.println("Loaded DeathMsgs Module!");
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
    public void onDeath(PlayerDeathEvent event) {
		if(event.getDeathMessage().equals(event.getEntity().getName() + " died")) {
			event.setDeathMessage("");
		}else {
			event.setDeathMessage(ChatColor.DARK_AQUA + event.getEntity().getName() + ChatColor.DARK_RED + event.getDeathMessage().replace(event.getEntity().getName()+"", ""));
			if(event.getEntity().getKiller() instanceof Player) {
				if(event.getDeathMessage().contains(event.getEntity().getKiller().getDisplayName())) {
					event.setDeathMessage(ChatColor.DARK_AQUA + event.getEntity().getName() + ChatColor.DARK_RED + event.getDeathMessage().replace(event.getEntity().getName()+"", "").replace(event.getEntity().getKiller().getDisplayName(), "") + ChatColor.DARK_AQUA + event.getEntity().getKiller().getDisplayName());
				}
			}
		}
	}
}
