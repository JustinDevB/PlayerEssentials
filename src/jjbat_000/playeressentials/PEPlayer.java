package jjbat_000.playeressentials;

import java.util.UUID;

import org.bukkit.entity.Player;
import jjbat_000.playeressentials.Core;

/* This class will register stuff about a player.
 * Only register methods for a player in here.
 */

public class PEPlayer {
	
	private Player player;
	
	public Player getPlayer() {
        return this.player;
    }

	public UUID getUUID() {
        return getPlayer().getUniqueId();
    }
	
	

}
