package com.tbttk.anarchycore.checks;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class Flight implements Listener{

	public ArrayList<Player> inAir = new ArrayList<Player>();
	public HashMap<Player, Location> origin = new HashMap<Player, Location>();
	public HashMap<Player, Integer> warnings = new HashMap<Player, Integer>();
	public ArrayList<Player> AC = new ArrayList<Player>();
	  
	public Flight() {
		System.out.println("Loaded Flight Module!");
	}
	
	  @EventHandler
	  public void onPlayerMove(PlayerMoveEvent e)
	  {
	    Player p = e.getPlayer();
	    Location loc = p.getLocation();
	    World w = loc.getWorld();
	    Block under = w.getBlockAt(new Location(w, loc.getBlockX(), loc.getBlockY() - 1, loc.getBlockZ()));
	    Block under2 = w.getBlockAt(new Location(w, loc.getBlockX(), loc.getBlockY() - 2, loc.getBlockZ()));
	    if ((under.getType() == Material.AIR) && (under2.getType() == Material.AIR))
	    {
	      if (!inAir.contains(p))
	      {
	        inAir.add(p);
	        if (!origin.containsKey(p)) {
	          origin.put(p, loc);
	        }
	      }
	      if ((((Location)origin.get(p)).distance(loc) >= 4.0D) && 
	        (((Location)origin.get(p)).getY() <= loc.getY())) {
	    	  if(!e.getPlayer().isGliding() || !p.getAllowFlight()) {
	    		  if(!p.isOp()  && !p.hasPermission("AnarchyCore.Fly.Bypass") || p.getGameMode() == GameMode.SURVIVAL) {
		    		  e.setCancelled(true);
	    			  p.kickPlayer(ChatColor.translateAlternateColorCodes('&', "&6You have been disconnected!"));
	    		  }
	    	  }
	      }
	    }
	    else if (inAir.contains(p))
	    {
	      inAir.remove(p);
	      origin.remove(p);
	    }
	  }
	  
	public static Boolean A() {
		return true;
	}
}
