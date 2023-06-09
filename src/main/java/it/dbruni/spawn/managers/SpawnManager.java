package it.dbruni.spawn.managers;

import ch.jalu.configme.SettingsManager;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Location;

public class SpawnManager {

    private final SettingsManager settingsManager;
    @Getter private static Location location;

    public SpawnManager(SettingsManager settingsManager) {
        this.settingsManager = settingsManager;
    }

    public void updateLocation() {
        String world = settingsManager.getProperty(Configuration.CORDS_WORLD);
        double x = settingsManager.getProperty(Configuration.CORD_X);
        double y = settingsManager.getProperty(Configuration.CORD_Y);
        double z = settingsManager.getProperty(Configuration.CORD_Z);
        double yaw = settingsManager.getProperty(Configuration.CORD_YAW);
        double pitch = settingsManager.getProperty(Configuration.CORD_PITCH);

        setLocation(world, x, y, z, yaw, pitch);
    }

    public void setLocation(String world, double x, double y, double z, double yaw, double pitch) {
        location = new Location(Bukkit.getWorld(world), x, y, z, (float) yaw, (float) pitch);
    }

}
