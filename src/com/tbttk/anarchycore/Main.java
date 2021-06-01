package com.tbttk.anarchycore;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.tbttk.anarchycore.Utils.TabUtil;
import com.tbttk.anarchycore.checks.ElytraFly;
import com.tbttk.anarchycore.checks.Flight;
import com.tbttk.anarchycore.commands.ElytraCommand;

public class Main extends JavaPlugin implements Listener{
	public static String Prefix = ChatColor.translateAlternateColorCodes('&', "&9Core> &7");
	public static String Join = ChatColor.translateAlternateColorCodes('&', "&9Join> &7");
	public static String Leave = ChatColor.translateAlternateColorCodes('&', "&9Leave> &7");
	public static String Perm = ChatColor.translateAlternateColorCodes('&', "&9Permissions> &7");
	public static String Staff = ChatColor.translateAlternateColorCodes('&', "&9Staff> &7");
	
	public static HashMap<UUID, Boolean> notif = new HashMap<UUID, Boolean>();
	public static HashMap<UUID, Boolean> bypass = new HashMap<UUID, Boolean>();
	
	public static Main instance;
	
	@Override
    public void onEnable() {

		//
//        configFile = new File(getDataFolder(), "config.yml");
//
//        try {
//            firstRun();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        config = new YamlConfiguration();
//        loadYamls();

		System.out.println("Called onEnable!");
        this.getServer().getPluginManager().registerEvents(new ElytraFly(), this);
        this.getServer().getPluginManager().registerEvents(new Flight(), this);
        this.getServer().getPluginManager().registerEvents(new DeathMsgs(), this);
        this.getServer().getPluginManager().registerEvents(new TabUtil(), this);
        this.getCommand("elytra").setExecutor(new ElytraCommand());
    }
	@Override
	public void onDisable() {
		System.out.println("Called onDisable!");
		notif.clear();
		bypass.clear();
	}
	
	public static Main getInstance() {
		return instance;
	}
}
