package me.limebyte.battlenight.core;

import java.util.logging.Logger;

import me.limebyte.battlenight.core.battle.Battle;
import me.limebyte.battlenight.core.battle.Team;
import me.limebyte.battlenight.core.battle.Team.TeamColour;
import me.limebyte.battlenight.core.battle.modes.TeamDeathMatch;
import me.limebyte.battlenight.core.configuration.ConfigurationManager;
import me.limebyte.battlenight.core.managers.ClassManager;
import me.limebyte.battlenight.core.managers.CommandManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author LimeByte.
 * Creative Commons Attribution-NonCommercial-NoDerivs 3.0 Unported
 * http://creativecommons.org/licenses/by-nc-nd/3.0/
 */
public class BattleNight extends JavaPlugin {

	private static BattleNight instance;
    public PluginDescriptionFile pdFile;
    public Logger log;
    private static ClassManager classManager;
    private static Battle battle;

    @Override
    public void onEnable() {

    	instance = this;
    	
    	// Get plugin.yml and logger
    	pdFile = getDescription();
    	log = getLogger();
    	
    	// Register events
    	
    	// Configuration
    	ConfigurationManager.initialize();
    	
    	// Classes
    	classManager = new ClassManager();
    	classManager.loadClasses();
    	classManager.saveClasses();
    	
        // Link classes
        battle = new Battle(new TeamDeathMatch(new Team("Orange", TeamColour.ORANGE), new Team("Lime", TeamColour.LIME)));
        
        // Load command class
        CommandManager cmdExecutor = new CommandManager();
        getCommand("bn").setExecutor(cmdExecutor);

        // Print enable message to the console
        log.info("Version " + pdFile.getVersion() + " enabled!");
        log.info("Made by LimeByte.");
    }

    @Override
    public void onDisable() {
        // Print disable message to the console
        log.info("Version " + pdFile.getVersion() + " disabled.");
    }
    
    
    @Override @Deprecated
    public FileConfiguration getConfig() {
        return null;
    }
    
    public static ClassManager getClassManager() {
        return classManager;
    }
    
    public static Battle getBattle() {
    	return battle;
    }
    
    public static BattleNight getInstance() {
    	return instance;
    }

}
