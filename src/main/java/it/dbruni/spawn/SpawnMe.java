package it.dbruni.spawn;

import ch.jalu.configme.SettingsManager;
import ch.jalu.configme.SettingsManagerBuilder;
import it.dbruni.spawn.commands.SpawnCommand;
import it.dbruni.spawn.commands.mainCommand.SpawnMeCommand;
import it.dbruni.spawn.listener.PlayerListener;
import it.dbruni.spawn.managers.Configuration;
import it.dbruni.spawn.managers.SpawnManager;
import lombok.Getter;
import org.bukkit.Bukkit;
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
    private SpawnManager spawnManager;
    @Override
    public void onEnable() {
        instance = this;

        Bukkit.getLogger().log(Level.FINE, "Enabling " + this.getName() + " version " + this.getDescription().getVersion() + " by " + "dbruni");
        Bukkit.getConsoleSender().sendMessage("§4Made " + "§fin" + " §cItaly!");
        File file = new File("plugins" +  "/" + this.getName() + "/" + "config.yml");
        settingsManager = SettingsManagerBuilder
                .withYamlFile(file)
                .configurationData(Configuration.class)
                .useDefaultMigrationService()
                .create();
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new PlayerListener(), this);

        spawnManager = new SpawnManager(settingsManager);
        spawnManager.updateLocation();

        getCommand("spawnme").setExecutor(new SpawnMeCommand());
        getCommand("spawn").setExecutor(new SpawnCommand());
    }


    @Override
    public void onDisable() {
        Bukkit.getLogger().log(Level.FINE, "Disabling, Goodbye!");
    }

}
