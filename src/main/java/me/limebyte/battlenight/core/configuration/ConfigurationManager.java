package me.limebyte.battlenight.core.configuration;

import org.bukkit.configuration.file.FileConfiguration;

import me.limebyte.battlenight.core.BattleNight;

/**
 * @author LimeByte.
 * Creative Commons Attribution-NonCommercial-NoDerivs 3.0 Unported
 * http://creativecommons.org/licenses/by-nc-nd/3.0/
 */
public class ConfigurationManager {
	
    public static BattleNight plugin;
	
	private static Configuration main;
	private static Configuration classes;
	private static Configuration tracks;
	private static Configuration arenas;
	private static Configuration players;
	
    public static void initialize() {
    	plugin = BattleNight.getInstance();
    	
    	main = 		new Configuration(plugin, "Config.yml");
    	classes = 	new Configuration(plugin, "Classes.yml");
    	tracks = 	new Configuration(plugin, "Tracks.yml");
    	arenas = 	new Configuration(plugin, "Arenas.dat", "PluginData");
    	players = 	new Configuration(plugin, "Players.dat", "PluginData");
    	
    	main.init();
    	classes.init();
    	tracks.init();
    	arenas.init();
    	players.init();
    }
    
    public static void save(Config config) {
        switch (config) {
            case MAIN:
                main.save();
                break;
            case CLASSES:
                classes.save();
                break;
            case TRACKS:
                tracks.save();
                break;
            case ARENAS:
                arenas.save();
                break;
            case PLAYERS:
                players.save();
                break;
            default:
                saveAll();
                break;
        }
    }
    
    public static void saveAll() {
    	main.save();
    	classes.save();
    	tracks.save();
    	arenas.save();
    	players.save();
    }
    
    public static void reload(Config config) {
        switch (config) {
            case MAIN:
                main.reload();
                break;
            case CLASSES:
                classes.reload();
                break;
            case TRACKS:
                tracks.reload();
                break;
            case ARENAS:
                arenas.reload();
                break;
            case PLAYERS:
                players.reload();
                break;
            default:
                reloadAll();
                break;
        }
    }
    
    public static void reloadAll() {
    	main.reload();
    	classes.reload();
    	tracks.reload();
    	arenas.reload();
    	players.reload();
    }
    
    public static FileConfiguration get(Config config) {
        switch (config) {
            case MAIN:
                return main.get();
            case CLASSES:
                return classes.get();
            case TRACKS:
                return tracks.get();
            case ARENAS:
                return arenas.get();
            case PLAYERS:
                return players.get();
            default:
                return null;
        }
    }
	
}