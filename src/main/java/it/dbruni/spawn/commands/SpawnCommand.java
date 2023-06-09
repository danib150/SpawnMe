package it.dbruni.spawn.commands;

import it.dbruni.spawn.managers.SenderUtils;
import it.dbruni.spawn.managers.SpawnManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(ChatColor.RED + "You must be a player!");
            return true;
        }

        SenderUtils senderUtils = new SenderUtils(player);

        if (!senderUtils.hasPermission("spawnme.spawn")) {
            return true;
        }

        SpawnManager spawnManager = new SpawnManager();
        player.teleport(spawnManager.getLocation());
        player.sendMessage(ChatColor.GREEN + "Teleported to spawn!");

        return true;
    }
}
