package fire.StatePVP.main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTemplate {
	
	private final String PERMISSION = "spvp.template";
	
	public CommandTemplate(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			if (sender.hasPermission(PERMISSION)) {
				commandPlayer(sender, cmd, label, args);
			} else {
				sender.sendMessage(ChatColor.RED + "You don't have permission to use this command.");
			}
		} else {
			commandConsole(sender, cmd, label, args);
		}
	}
	
	private boolean commandPlayer(CommandSender sender, Command cmd, String label, String[] args) {
		
		return false;
	}
	
	private boolean commandConsole(CommandSender sender, Command cmd, String label, String[] args) {
		
		return false;
	}
}
