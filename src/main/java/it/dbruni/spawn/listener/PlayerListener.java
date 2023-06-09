package it.dbruni.spawn.listener;

import ch.jalu.configme.SettingsManager;
import com.iridium.iridiumcolorapi.IridiumColorAPI;
import it.dbruni.spawn.SpawnMe;
import it.dbruni.spawn.managers.Configuration;
import it.dbruni.spawn.managers.SpawnManager;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Objects;

public class PlayerListener implements Listener {

    SettingsManager settingsManager = SpawnMe.getInstance().getSettingsManager();

    @EventHandler
    public void onJoinTitle(PlayerJoinEvent event) {
        if (!settingsManager.getProperty(Configuration.TITLE_ON_JOIN)) return;

        String formattedTitle = IridiumColorAPI.process(settingsManager.getProperty(Configuration.TITLE));
        String formattedSubtitle = IridiumColorAPI.process(settingsManager.getProperty(Configuration.SUBTITLE));

        Player player = event.getPlayer().getPlayer();
        Objects.requireNonNull(player).sendTitle(formattedTitle, formattedSubtitle, 2, 2,2);
    }

    @EventHandler
    public void onJoinTeleport(PlayerJoinEvent event) {
        if (!settingsManager.getProperty(Configuration.SPAWN_ON_JOIN)) return;

        SpawnManager spawnManager = new SpawnManager();

        Player player = event.getPlayer();
        player.teleport(spawnManager.getLocation());
    }


    @EventHandler
    public void onFirstJoinTeleport(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (settingsManager.getProperty(Configuration.SPAWN_ON_JOIN)
                || !settingsManager.getProperty(Configuration.SPAWN_ON_FIRST_JOIN)
                || !player.hasPlayedBefore()) return;

        SpawnManager spawnManager = new SpawnManager();

        player.teleport(spawnManager.getLocation());

    }

    @EventHandler
    public void onJoinChangeGamemode(PlayerJoinEvent event) {
        if (!settingsManager.getProperty(Configuration.CHANGE_GAMEMODE_ON_JOIN)) return;
        Player player = event.getPlayer();
        player.setGameMode(GameMode.valueOf(settingsManager.getProperty(Configuration.GAMEMODE_SPAWN)));
    }

}
