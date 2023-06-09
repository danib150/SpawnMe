package it.dbruni.spawn.managers;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;


public class SenderUtils {

    private final CommandSender sender;

    public SenderUtils(CommandSender sender) {
        this.sender = sender;
    }

    public boolean hasPermission(String perm) {
        if (!sender.hasPermission(perm)) {
            sender.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "[!] " + ChatColor.WHITE + "Required: " + ChatColor.WHITE + ChatColor.UNDERLINE + perm + "!");
            return false;
        }
        return true;
    }
}
