package jjbat_000.playeressentials;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.Listener;

public class PlayerListener implements Listener {
		private Core core;   //initializes core

	 public PlayerListener(Core core) {  //registers core
		 this.core = core;
		 
		 }
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onJoin(PlayerJoinEvent event) {
	        PEPlayer pePlayer = new PEPlayer(core, event.getPlayer());
	        core.pePlayers.put(event.getPlayer().getUniqueId(), pePlayer);
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pe loadrank " + event.getPlayer());
        System.out.println("Successfully loaded rank for " + event.getPlayer());
		
	}
	
	
	
	

}
