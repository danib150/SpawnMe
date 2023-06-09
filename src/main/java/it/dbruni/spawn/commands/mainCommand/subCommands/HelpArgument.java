package it.dbruni.spawn.commands.mainCommand.subCommands;

import it.dbruni.spawn.SpawnMe;
import it.dbruni.spawn.commands.mainCommand.CommandArguments;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class HelpArgument extends CommandArguments {
    public HelpArgument() {
        super("help", 1);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        sender.sendMessage(ChatColor.RED + "Plugin ver: " + SpawnMe.getInstance().getDescription().getVersion());
        addSubCommand(sender, "setspawn", "Set the spawn on your location.");
        addSubCommand(sender, "help", "Print a list of subcommands.");
        addSubCommand(sender, "reload", "Reload configuration.");
        sender.sendMessage(ChatColor.GREEN + "/spawn" + ChatColor.WHITE + " - " + "Teleport to spawn location.");
    }

    private void addSubCommand(CommandSender sender, String arg, String desc) {
        sender.sendMessage(ChatColor.GREEN + "/spawnme " + arg + ChatColor.WHITE + " - " + desc);
    }
}
