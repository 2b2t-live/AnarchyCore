package com.tbttk.anarchycore.Utils;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.WrappedChatComponent;

public class TabUtil implements Listener{

	private ProtocolManager protocolManager;
	
	public TabUtil() {
	    this.protocolManager = ProtocolLibrary.getProtocolManager();
		System.out.println("Loaded Tab Util!");
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerJoin(PlayerJoinEvent e) {
	    PacketContainer pc = this.protocolManager.createPacket(PacketType.Play.Server.PLAYER_LIST_HEADER_FOOTER);
	    pc.getChatComponents().write(0, WrappedChatComponent.fromText(fixColors("\n                 &7&l&o2BUILDERS                    \n                    &7&l&o2TOOLS                    \nLIVE\n\n          &6If you find any issues, contact noc@tbttk.com\n")))
	    .write(1, WrappedChatComponent.fromText(fixColors("\n\n\n&6If you find a dupe, please report ASAP!\n&7play-on.2b2t.live")));
	    try
			{
			  this.protocolManager.sendServerPacket(e.getPlayer(), pc);
		}catch (Exception ex){
		  ex.printStackTrace();
		}
	}

	  private String fixColors(String s)
	  {
	    return ChatColor.translateAlternateColorCodes('&', s);
	  }
}
