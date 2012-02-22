package me.limebyte.battlenight.core.Listeners;

import me.limebyte.battlenight.core.BattleNight;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class PotionListener implements Listener {

	// Get Main Class
	public static BattleNight plugin;
	public PotionListener(BattleNight instance) {
		plugin = instance;
	}
	
	@EventHandler(priority = EventPriority.NORMAL)
	public void onPotionSplash(PotionSplashEvent event) {
			Entity entity = event.getEntity();
			if(entity instanceof Player) {
				Player thrower = (Player) entity;
				String throwerName = thrower.getName();
				if (plugin.BattleUsersTeam.containsKey(throwerName) && plugin.playersInLounge) {
					event.setCancelled(true);
				}
			}
	}
	
	@EventHandler(priority = EventPriority.NORMAL)
	public void onPotionDrink(PlayerInteractEvent event) {
		if(event.getAction().equals(Action.RIGHT_CLICK_AIR)) {
			Player player = event.getPlayer();
			String playerName = player.getName();
			if(player.getItemInHand().equals(Material.POTION)) {
				if (plugin.BattleUsersTeam.containsKey(playerName) && plugin.playersInLounge) {
						event.setCancelled(true);
				}
			}
		}
	}
	
}