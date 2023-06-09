package it.dbruni.spawn.managers;

import ch.jalu.configme.Comment;
import ch.jalu.configme.SettingsHolder;
import ch.jalu.configme.properties.Property;
import ch.jalu.configme.properties.PropertyInitializer;

public class Configuration implements SettingsHolder {

    @Comment("Play sound on join (https://www.digminecraft.com/lists/sound_list_pc.php)")
    public static Property<Boolean> PLAY_SOUND = PropertyInitializer.newProperty("settings.join-sound.enabled", false);
    public static Property<String> SOUND_STRING = PropertyInitializer.newProperty("settings.join-sound.sound", "NOTE_PLING");
    public static Property<Integer> VOLUME = PropertyInitializer.newProperty("settings.join-sound.volume", 10);
    public static Property<Integer> PITCH = PropertyInitializer.newProperty("settings.join-sound.pitch", 10);
    @Comment("Send message on player join/quit")
    public static Property<Boolean> BC_ON_JOIN = PropertyInitializer.newProperty("settings.join-message.enabled", false);
    public static Property<String> JOIN_MESSAGE = PropertyInitializer.newProperty("settings.join-message.join", "&a+ &f(%player%)");
    public static Property<String> QUIT_MESSAGE = PropertyInitializer.newProperty("settings.join-message.quit", "&c- &f(%player%)");
    @Comment("Send title on join | Default: false")
    public static Property<Boolean> TITLE_ON_JOIN = PropertyInitializer.newProperty("settings.join-title.enabled", false);
    public static Property<String> TITLE = PropertyInitializer.newProperty("settings.join-title.title", "&cWelcome to my new improved");
    public static Property<String> SUBTITLE = PropertyInitializer.newProperty("settings.join-title.subtitle", "&cWelcome to my new improved");
    public static Property<Integer> TITLE_FADEIN = PropertyInitializer.newProperty("settings.join-title.fadein", 20);
    public static Property<Integer> TITLE_STAY = PropertyInitializer.newProperty("settings.join-title.stay", 50);
    public static Property<Integer> TITLE_FADEOUT = PropertyInitializer.newProperty("settings.join-title.fadeout", 20);

    @Comment("Change the gamemode on join | Default: false")
    public static Property<Boolean> CHANGE_GAMEMODE_ON_JOIN = PropertyInitializer.newProperty("settings.change-gamemode-on-join", false);

    @Comment("Gamemode type on spawn | Default: false")
    public static Property<String> GAMEMODE_SPAWN = PropertyInitializer.newProperty("settings.gamemode", "SURVIVAL");

    @Comment("Teleport to spawn the player for each join | Default: true")
    public static Property<Boolean> SPAWN_ON_JOIN = PropertyInitializer.newProperty("settings.spawn-on-join", false);

    @Comment("Teleport to spawn the player for the first join | Default: true")
    public static Property<Boolean> SPAWN_ON_FIRST_JOIN = PropertyInitializer.newProperty("settings.spawn-on-first-join", true);

    @Comment("Teleport message")
    public static Property<String> TELEPORT_MESSAGE = PropertyInitializer.newProperty("settings.teleport-message", "&aTeleported to spawn!");

    @Comment("Spawn coords")
    public static Property<String> CORDS_WORLD = PropertyInitializer.newProperty("spawn.world", "world");
    public static Property<Double> CORD_X = PropertyInitializer.newProperty("spawn.x", 0.0);
    public static Property<Double> CORD_Y = PropertyInitializer.newProperty("spawn.y", 0.0);
    public static Property<Double> CORD_Z = PropertyInitializer.newProperty("spawn.z", 0.0);
    public static Property<Double> CORD_PITCH = PropertyInitializer.newProperty("spawn.pitch", 0.0);
    public static Property<Double> CORD_YAW = PropertyInitializer.newProperty("spawn.yaw", 0.0);
}
