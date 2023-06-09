package it.dbruni.spawn.commands.mainCommand.subCommands;

import ch.jalu.configme.SettingsManager;
import it.dbruni.spawn.SpawnMe;
import it.dbruni.spawn.commands.mainCommand.CommandArguments;
import it.dbruni.spawn.managers.Configuration;
import it.dbruni.spawn.managers.SpawnManager;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawn extends CommandArguments {
    public SetSpawn() {
        super("setspawn", 1);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(ChatColor.RED + "You must be a player to configure spawn location.");
            return;
        }
        SpawnManager spawnManager = new SpawnManager();
        Location location = player.getLocation();
        double x, y, z, yaw, pitch;
        x = location.getX();
        y = location.getY();
        z = location.getZ();
        yaw = location.getYaw();
        pitch = location.getPitch();

        spawnManager.setLocation(location.getWorld().getName(), x, y, z, yaw, pitch);

        SettingsManager settingsManager = SpawnMe.getInstance().getSettingsManager();
        settingsManager.setProperty(Configuration.CORD_X, x);
        settingsManager.setProperty(Configuration.CORD_Y, y);
        settingsManager.setProperty(Configuration.CORD_Z, z);
        settingsManager.setProperty(Configuration.CORD_PITCH, pitch);
        settingsManager.setProperty(Configuration.CORD_YAW, yaw);

        settingsManager.save();

        sender.sendMessage(ChatColor.YELLOW + "Configured spawn for your current position.");
    }
}
