package fire.StatePVP.main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandLeave {
	
	private static final String PERMISSION = "spvp.leave";
	
	public static boolean command(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			if (sender.hasPermission(PERMISSION)) {
				return commandPlayer(sender, cmd, label, args);
			} else {
				sender.sendMessage(ChatColor.RED + "You don't have permission to use this command.");
				return false;
			}
		} else {
			return commandConsole(sender, cmd, label, args);
		}
	}
	
	private static boolean commandPlayer(CommandSender p, Command cmd, String label, String[] args) {
		
		return false;
	}
	
	private static boolean commandConsole(CommandSender sender, Command cmd, String label, String[] args) {
		
		return false;
	}
}
