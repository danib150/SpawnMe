package it.dbruni.spawn;

import ch.jalu.configme.SettingsManager;
import ch.jalu.configme.SettingsManagerBuilder;
import it.dbruni.spawn.commands.SpawnCommand;
import it.dbruni.spawn.commands.mainCommand.SpawnMeCommand;
import it.dbruni.spawn.listener.PlayerListener;
import it.dbruni.spawn.managers.Configuration;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.logging.Level;

/*
* Ananas shouldn't go on pizza
* */
@Getter
public class SpawnMe extends JavaPlugin {

    @Getter private static SpawnMe instance;
    private SettingsManager settingsManager;

    @Override
    public void onEnable() {
        instance = this;

        Bukkit.getLogger().log(Level.FINE, "Enabling " + this.getName() + " version " + this.getDescription().getVersion() + " by " + this.getDescription().getAuthors().get(0));
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Made " + ChatColor.WHITE + "in" + ChatColor.RED + " Italy!");
        File file = new File(this.getName() + "/" + "config.yml");
        settingsManager = SettingsManagerBuilder
                .withYamlFile(file)
                .configurationData(Configuration.class)
                .useDefaultMigrationService()
                .create();
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new PlayerListener(), this);

        getCommand("spawnme").setExecutor(new SpawnCommand());
        getCommand("spawnme").setExecutor(new SpawnMeCommand());
    }


    @Override
    public void onDisable() {
        Bukkit.getLogger().log(Level.FINE, "Disabling, Goodbye!");
    }

}
