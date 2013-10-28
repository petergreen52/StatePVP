package fire.StatePVP.main;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class StatePVP extends JavaPlugin {

	SettingsManager settings = SettingsManager.getInstance();
	
	public void onEnable() {
		settings.setup(this);
		Bukkit.getServer().getPluginManager().registerEvents(new Listeners(), this);
		Bukkit.getServer().getLogger().info("[StatePVP] Enabled");
	}
	
	public void onDisable() {
		//Bukkit.getServer().getLogger().info("");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("spvp") || cmd.getName().equalsIgnoreCase("spvp help")) {
			return CommandHelp.command(sender, cmd, label, args);
		}
		if (cmd.getName().equalsIgnoreCase("spvp join")) {
			return CommandJoin.command(sender, cmd, label, args);
		}
		return false;
	}
}
