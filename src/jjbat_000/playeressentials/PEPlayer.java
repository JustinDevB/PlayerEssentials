package jjbat_000.playeressentials;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.entity.Player;

import jjbat_000.playeressentials.util.MessageType;
import jjbat_000.playeressentials.util.MessageUtil;

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
	
	public void sendMessage(MessageType type, String message) {
        getPlayer().sendMessage(MessageUtil.translate(type.getFormat() + message));
    }
	
	
	
	

}
