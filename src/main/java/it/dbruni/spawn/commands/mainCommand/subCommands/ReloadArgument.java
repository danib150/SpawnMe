package it.dbruni.spawn.commands.mainCommand.subCommands;

import ch.jalu.configme.SettingsManager;
import it.dbruni.spawn.SpawnMe;
import it.dbruni.spawn.commands.mainCommand.CommandArguments;
import it.dbruni.spawn.managers.Configuration;
import it.dbruni.spawn.managers.SpawnManager;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class ReloadArgument extends CommandArguments {
    public ReloadArgument() {
        super("reload", 1);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        SpawnManager spawnManager = SpawnMe.getInstance().getSpawnManager();
        SettingsManager settingsManager = SpawnMe.getInstance().getSettingsManager();
        settingsManager.reload();
        System.out.println(settingsManager.getProperty(Configuration.CORD_Y));
        spawnManager.updateLocation();
        sender.sendMessage(ChatColor.YELLOW + "Configuration reloaded.");
    }
}
