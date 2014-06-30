package jjbat_000.playeressentials;

import java.util.HashMap;
import java.util.UUID;
import java.util.logging.Logger;

import jjbat_000.playeressentials.mondocommand.MondoCommand;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;

import jjbat_000.playeressentials.commands.*;

/* Main class where everything will be registered.
 * Only register events in here
 */


public class Core extends JavaPlugin implements Listener {
	public static Logger logger;
	public MondoCommand mcmd;
	public HashMap<UUID, PEPlayer> pePlayers = new HashMap<>();
	
	public void onEnable() {
		try {
		logger = getLogger();
		
		 //Command registering
        mcmd = new MondoCommand();
        mcmd.autoRegisterFrom(new Commands(this));
        getCommand("playeressentials").setExecutor(mcmd);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
}
	
	public void onDisable() {
		
	}
	
	/**
     * Used to match a UUID to a PEPlayer
     * @param Player's UUID
     * @return Player matching the UUID
     */
	 public PEPlayer getPEPlayer(UUID uuid) {
	        return pePlayers.get(uuid);
	    }
	
	
	
	

}
