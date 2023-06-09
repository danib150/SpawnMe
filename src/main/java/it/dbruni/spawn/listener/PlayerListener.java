package it.dbruni.spawn.listener;

import ch.jalu.configme.SettingsManager;
import com.iridium.iridiumcolorapi.IridiumColorAPI;
import it.dbruni.spawn.SpawnMe;
import it.dbruni.spawn.managers.Configuration;
import it.dbruni.spawn.managers.SpawnManager;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener {

    SettingsManager settingsManager = SpawnMe.getInstance().getSettingsManager();

    @EventHandler
    public void onFirstJoinTeleport(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage(null);

        if (settingsManager.getProperty(Configuration.PLAY_SOUND)) {
            Sound sound = Sound.valueOf(settingsManager.getProperty(Configuration.SOUND_STRING));

            int volume = settingsManager.getProperty(Configuration.VOLUME);
            int pitch = settingsManager.getProperty(Configuration.PITCH);

            player.playSound(player, sound, volume, pitch);
        }

        if (settingsManager.getProperty(Configuration.CHANGE_GAMEMODE_ON_JOIN))
            player.setGameMode(GameMode.valueOf(settingsManager.getProperty(Configuration.GAMEMODE_SPAWN)));

        if (settingsManager.getProperty(Configuration.TITLE_ON_JOIN)) {
            String formattedTitle = IridiumColorAPI.process(settingsManager.getProperty(Configuration.TITLE));
            String formattedSubtitle = IridiumColorAPI.process(settingsManager.getProperty(Configuration.SUBTITLE));

            int fadein = settingsManager.getProperty(Configuration.TITLE_FADEIN);
            int stay = settingsManager.getProperty(Configuration.TITLE_STAY);
            int fadeout = settingsManager.getProperty(Configuration.TITLE_FADEOUT);

            player.sendTitle(formattedTitle, formattedSubtitle, fadein, stay, fadeout);
        }

        if (settingsManager.getProperty(Configuration.SPAWN_ON_JOIN))
            player.teleport(SpawnManager.getLocation());


        if (settingsManager.getProperty(Configuration.BC_ON_JOIN))
            Bukkit.broadcastMessage(IridiumColorAPI.process(settingsManager.getProperty(Configuration.JOIN_MESSAGE).replace("%player%", event.getPlayer().getName())));

        if (!settingsManager.getProperty(Configuration.SPAWN_ON_FIRST_JOIN) || !player.hasPlayedBefore()) return;
        player.teleport(SpawnManager.getLocation());

    }

    @EventHandler
    public void onQuitMessage(PlayerQuitEvent event) {
        event.setQuitMessage(null);
        if (!settingsManager.getProperty(Configuration.BC_ON_JOIN)) return;
        Bukkit.broadcastMessage(IridiumColorAPI.process(settingsManager.getProperty(Configuration.QUIT_MESSAGE).replace("%player%", event.getPlayer().getName())));
    }
}
