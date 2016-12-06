package io.github.rypofalem.achievement;

import org.bukkit.Achievement;
import org.bukkit.World.Environment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.plugin.java.JavaPlugin;

public class AchievementFixPlugin extends JavaPlugin implements Listener{
	
	public void onEnable(){
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
	public void onPlayerTeleport(PlayerTeleportEvent event){
		if(event.getCause() != TeleportCause.END_PORTAL) return;
		if(event.getTo().getWorld().getEnvironment() != Environment.THE_END) return;
		Player player = event.getPlayer();
		if(Achievement.END_PORTAL.hasParent()){
			if(!player.hasAchievement(Achievement.END_PORTAL.getParent())) return;
		}
		player.awardAchievement(Achievement.END_PORTAL);
	}
}