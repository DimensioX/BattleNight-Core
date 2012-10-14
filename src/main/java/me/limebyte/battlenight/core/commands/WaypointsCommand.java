package me.limebyte.battlenight.core.commands;

import java.util.ArrayList;
import java.util.List;

import me.limebyte.battlenight.core.BattleNight;
import me.limebyte.battlenight.core.Other.Waypoint;
import me.limebyte.battlenight.core.chat.ListPage;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class WaypointsCommand extends BattleNightCommand {

    public WaypointsCommand(CommandSender sender, String[] args) {
        super(sender, args);
    }

    @Override
    public boolean onPerformed() {
        List<String> lines = new ArrayList<String>();
        Waypoint[] waypoints = Waypoint.values();

        lines.add(ChatColor.WHITE + "Setup points: " + BattleNight.numSetupPoints() + "/" + waypoints.length);
        for (Waypoint wp : waypoints) {
            lines.add(getWaypointColour(wp) + wp.getDisplayName() + ChatColor.WHITE + " (/bn set " + wp.getName() + "...)");
        }

        ListPage page = new ListPage("BattleNight Waypoints", lines);
        getSender().sendMessage(page.getPage());
        return true;
    }

    @Override
    public String getUsage() {
        return "/bn waypoints";
    }

    @Override
    public String getConsoleUsage() {
        return "/bn waypoints";
    }

    private static ChatColor getWaypointColour(Waypoint waypoint) {
        return BattleNight.pointSet(waypoint) ? ChatColor.GREEN : ChatColor.RED;
    }

    @Override
    public CommandMap getCommandMap() {
        return CommandMap.WAYPOINTS;
    }

}