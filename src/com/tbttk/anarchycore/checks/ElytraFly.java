package com.tbttk.anarchycore.checks;

import java.text.DecimalFormat;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import com.tbttk.anarchycore.Main;

public class ElytraFly implements Listener{
	
	public ElytraFly() {
		System.out.println("Loaded ElytraFly Module!");
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerMove(PlayerMoveEvent event) {
        if(event.getPlayer().isGliding()) {
            Vector x = event.getTo().toVector();
            Vector y = event.getFrom().toVector();
            Vector z = x.subtract(y);
            if(Main.notif.containsKey(event.getPlayer().getUniqueId())) {
        		event.getPlayer().sendMessage(" ");
        		DecimalFormat format = new DecimalFormat("#.00");
        		String a = format.format(Math.abs(z.getX()));
        		String b = format.format(Math.abs(z.getZ()));
        		String c = format.format(z.getY());
                event.getPlayer().sendMessage(ChatColor.GREEN + "["+a+"] ["+b+"] ["+c+"]" + ChatColor.YELLOW + " --- " + ChatColor.GOLD + "[1]<1 || [2]<1 & [3]==0");
        	}
        	if(!Main.bypass.containsKey(event.getPlayer().getUniqueId())) {
	            if(event.getPlayer().getWorld().getName().equals("world")) {
		            if(Math.abs(z.getX()) > 1 || Math.abs(z.getZ()) > 1 && z.getY() == 0) {
		            	event.setCancelled(true);
		            }
	            }else{
	            	if(Math.abs(z.getX()) > 0.405 || Math.abs(z.getZ()) > 0.405 && z.getY() == 0 || Math.abs(z.getY()) > 0.185) {
	            		event.setCancelled(true);
		            	}
		            }
	            }
        	}
        }
	public static Boolean A() {
		return true;
	}
}
