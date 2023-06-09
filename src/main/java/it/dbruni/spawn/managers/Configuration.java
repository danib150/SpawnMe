package it.dbruni.spawn.managers;

import ch.jalu.configme.Comment;
import ch.jalu.configme.SettingsHolder;
import ch.jalu.configme.properties.Property;
import ch.jalu.configme.properties.PropertyInitializer;

public class Configuration implements SettingsHolder {

    @Comment("Send title on join | Default: false")
    public static Property<Boolean> TITLE_ON_JOIN = PropertyInitializer.newProperty("settings.join-title.enabled", false);
    public static Property<String> TITLE = PropertyInitializer.newProperty("settings.join-title.title", "&cWelcome to my new improved");
    public static Property<String> SUBTITLE = PropertyInitializer.newProperty("settings.join-title.subtitle", "&cWelcome to my new improved");

    @Comment("Change the gamemode on join | Default: false")
    public static Property<Boolean> CHANGE_GAMEMODE_ON_JOIN = PropertyInitializer.newProperty("settings.change-gamemode-on-join", false);

    @Comment("Gamemode type on spawn | Default: false")
    public static Property<String> GAMEMODE_SPAWN = PropertyInitializer.newProperty("settings.gamemode", "SURVIVAL");

    @Comment("Teleport to spawn the player for each join | Default: true")
    public static Property<Boolean> SPAWN_ON_JOIN = PropertyInitializer.newProperty("settings.spawn-on-join", false);

    @Comment("Teleport to spawn the player for the first join | Default: true")
    public static Property<Boolean> SPAWN_ON_FIRST_JOIN = PropertyInitializer.newProperty("settings.spawn-on-first-join", true);

    @Comment("Spawn coords")
    public static Property<Integer> CORD_X = PropertyInitializer.newProperty("spawn.x", 0);
    public static Property<Integer> CORD_Y = PropertyInitializer.newProperty("spawn.y", 0);
    public static Property<Integer> CORD_Z = PropertyInitializer.newProperty("spawn.z", 0);
    public static Property<Integer> CORD_PITCH = PropertyInitializer.newProperty("spawn.pitch", 0);
    public static Property<Integer> CORD_YAW = PropertyInitializer.newProperty("spawn.yaw", 0);
}
