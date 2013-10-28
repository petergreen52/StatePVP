package fire.StatePVP.main;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;

public class SettingsManager {

	private SettingsManager() {}
	
	private static SettingsManager instance = new SettingsManager();
	
	public static SettingsManager getInstance() {
		return instance;
	}
	//----------------------------------------------------------------
	Plugin p;
	FileConfiguration config;
	File cfile;
	FileConfiguration data;
	File dfile;
	
	/**
	 * Sort of the fake constructor run in onEnable in the main class.
	 * @param p
	 */
	public void setup(Plugin p) {
		if (!p.getDataFolder().exists()) {
			try {
				p.getDataFolder().createNewFile();
			} catch (IOException e) {
				Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create Plugin folder.");
			}
		}
		// special for the config file (I think)
		config = p.getConfig();
		// needed for a file if that files has defaults
		config.options().copyDefaults(true);
		
		// holds the FILE
		cfile = new File(p.getDataFolder(), "config.yml");
		dfile = new File(p.getDataFolder(), "data.yml");
		
		// needed if the file doesn't have defaults
		if (!dfile.exists()) {
			try {
				dfile.createNewFile();
			} catch (IOException e) {
				Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create data file.");
			}
		}
	
		// initializes DATA from FILE (everything except config)
		data = YamlConfiguration.loadConfiguration(dfile);
		
		saveConfig();
		saveData();
	}
	
	//===========CONFIG=============
	/**
	 * Returns the CONFIG 
	 * @return
	 */
	public FileConfiguration getConfig() {
		return config;
	}
	
	/**
	 * Saves the config out to the file.
	 */
	public void saveConfig() {
		try {
			config.save(cfile);
		} catch (IOException e) {
			Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save config.yml.");
		}
	}
	
	/**
	 * Pulls in a new config from the file.
	 */
	public void reloadConfig() {
		config = YamlConfiguration.loadConfiguration(cfile);
	}
	
	//===============DATA===============
	public FileConfiguration getData() {
		return data;
	}
	
	public void saveData() {
		try {
			data.save(dfile);
		} catch (IOException e) {
			Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save data.yml.");
			}
	}
	
	public void reloadData() {
		data = YamlConfiguration.loadConfiguration(dfile);
	}
	
	//=============PLUGIN DESCRIPTION===========
	/**
	 * Returns the description of the config (I think)
	 * @return
	 */
	public PluginDescriptionFile getDesc() {
		return p.getDescription();
	}
}
