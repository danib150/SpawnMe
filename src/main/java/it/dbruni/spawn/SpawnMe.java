package it.dbruni.spawn;

import ch.jalu.configme.SettingsManager;
import ch.jalu.configme.SettingsManagerBuilder;
import it.dbruni.spawn.managers.Configuration;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

@Getter
public class SpawnMe extends JavaPlugin {

    @Getter private static SpawnMe instance;
    private SettingsManager settingsManager;

    @Override
    public void onEnable() {
        instance = this;
        File file = new File(this.getName() + "/" + "config.yml");
        settingsManager = SettingsManagerBuilder
                .withYamlFile(file)
                .configurationData(Configuration.class)
                .useDefaultMigrationService()
                .create();
    }

    @Override
    public void onDisable() {
    }
}
