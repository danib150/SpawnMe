package it.dbruni.spawn.commands.mainCommand.subCommands;

import it.dbruni.spawn.commands.mainCommand.CommandArguments;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class UnknownArg extends CommandArguments {
    public UnknownArg() {
        super("", 0);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        sender.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "[!] " + ChatColor.WHITE + "Unknown subcommand type /spawnme help for a list of subcommand.");
    }
}
