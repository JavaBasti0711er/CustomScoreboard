package de.javabasti.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import de.javabasti.scoreboard.events.JoinEvent;
import de.javabasti.scoreboard.utils.SetupScoreboard;
import net.md_5.bungee.api.ChatColor;

public class ScoreboardOblivion extends JavaPlugin {

	public static ScoreboardOblivion instance;
	public SetupScoreboard setupScoreboard;

	public static ScoreboardOblivion getInstance() {
		return instance;
	}

	@Override
	public void onEnable() {
		instance = this;
		this.setupScoreboard = new SetupScoreboard();
		Bukkit.getConsoleSender().sendMessage(colorize("&8-----------------------------"));
		Bukkit.getConsoleSender().sendMessage(colorize("&6Author: " + getDescription().getAuthors()));
		Bukkit.getConsoleSender().sendMessage(colorize("&6Version: " + getDescription().getVersion()));
		Bukkit.getConsoleSender().sendMessage(colorize("&6If anything not working ->"));
		Bukkit.getConsoleSender().sendMessage(colorize("&6message me on Discord: JavaBasti#2246"));
		Bukkit.getConsoleSender().sendMessage(colorize("&8-----------------------------"));
		
		Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);

	}

	public String colorize(String msg) {
		return ChatColor.translateAlternateColorCodes('&', msg);
	}
}
