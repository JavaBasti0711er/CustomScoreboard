package de.javabasti.scoreboard.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import de.javabasti.scoreboard.ScoreboardOblivion;
import net.md_5.bungee.api.ChatColor;

public class SetupScoreboard {
	ScoreboardOblivion m;
	File file;
	YamlConfiguration ymlconfig;

	public SetupScoreboard() {
		this.file = new File(ScoreboardOblivion.getInstance().getDataFolder(), "Scoreboard.yml");
		if (!this.file.exists()) {
			ScoreboardOblivion.getInstance().saveResource("Scoreboard.yml", false);
		}
		this.ymlconfig = YamlConfiguration.loadConfiguration(this.file);
	}

	public void load() {
		this.file = new File(ScoreboardOblivion.getInstance().getDataFolder(), "Scoreboard.yml");
		if (!this.file.exists()) {
			ScoreboardOblivion.getInstance().saveResource("Scoreboard.yml", false);
		}
		this.ymlconfig = YamlConfiguration.loadConfiguration(this.file);
	}

	public void save() {
		this.file = new File(ScoreboardOblivion.getInstance().getDataFolder(), "Scoreboard.yml");
		if (!this.file.exists()) {
			ScoreboardOblivion.getInstance().saveResource("Scoreboard.yml", false);
		}
		try {
			ymlconfig.save(file);
		} catch (IOException e) {

		}
		this.ymlconfig = YamlConfiguration.loadConfiguration(this.file);
	}

	public YamlConfiguration getConfiguration() {
		return this.ymlconfig;
	}

	public File getFile() {
		return this.file;
	}

	public String getString(String str) {
		if (this.ymlconfig.contains(str)) {
			return ChatColor.translateAlternateColorCodes('&', this.ymlconfig.getString(str));
		}
		return ChatColor.translateAlternateColorCodes('&', "&cString: " + str + " doesnt exist!");
	}

	public int getInt(String str) {
		if (this.ymlconfig.contains(str)) {
			return this.ymlconfig.getInt(str);
		}
		return 0;
	}

	public Boolean getBoolean(String str) {
		if (this.ymlconfig.contains(str)) {
			return this.ymlconfig.getBoolean(str);
		}
		return null;
	}

	public List<String> getStringList(String str) {
		if (this.ymlconfig.contains(str)) {
			return this.ymlconfig.getStringList(str);
		}
		return null;
	}

	public ConfigurationSection getConfigurationSection(String str) {
		if (this.ymlconfig.contains(str)) {
			return this.ymlconfig.getConfigurationSection(str);
		}
		return null;
	}

	public Boolean contains(String str) {
		if (this.ymlconfig.contains(str)) {
			return true;
		}
		return false;
	}

}