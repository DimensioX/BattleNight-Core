package me.limebyte.battlenight.core.battle;

import me.limebyte.battlenight.core.BattleNight;

import org.bukkit.Location;

public enum Waypoint {
    RED_LOUNGE("redlounge", "Red Lounge"),
    BLUE_LOUNGE("bluelounge", "Blue Lounge"),
    RED_SPAWN("redspawn", "Red Spawn"),
    BLUE_SPAWN("bluespawn", "Blue Spawn"),
    SPECTATOR("spectator", "Spectator"),
    EXIT("exit", "Exit");

    private String name;
    private String displayName;

    Waypoint(String name, String displayName) {
        this.name = name;
        this.displayName = displayName;
    }

    public String getName() {
        return name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public Location getLocation() {
        return BattleNight.getCoords(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
