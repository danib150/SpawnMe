package it.dbruni.spawn;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public class SpawnMe extends JavaPlugin {

    @Getter private static SpawnMe instance;

    @Override
    public void onEnable() {
        instance = this;
    }

    @Override
    public void onDisable() {

    }
}
