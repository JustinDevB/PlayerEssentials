package jjbat_000.playeressentials;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
//import org.bukkit.Bukkit;
//import org.bukkit.ChatColor;
import org.bukkit.entity.Player;


//import org.bukkit.event.EventHandler;
//import org.bukkit.event.EventPriority;
//import org.bukkit.event.player.PlayerJoinEvent;
import jjbat_000.playeressentials.util.MessageType;
import jjbat_000.playeressentials.util.MessageUtil;


/* This class will register stuff about a player.
 * Only register methods for a player in here.
 */

public class PEPlayer {
	private Rank rank = Rank.DEFAULT;
	private Player player;
	public HashMap<UUID, PEPlayer> pePlayers = new HashMap<>();
    Core core;

	
	public PEPlayer(Core core, Player player) {
		this.core = core;
		this.player = player;
				
	}
	public void loadRank() {
        if (player.hasPermission("playeressentials.admin")) {
            rank = Rank.ADMIN;
        } else if (player.hasPermission("playeressentials.moderator")) {
            rank = Rank.MODERATOR;
        } else if (player.hasPermission("playeressentials.owner")) {
            rank = Rank.OWNER;
        } else if (player.hasPermission("playeressentials.guide")) {
            rank = Rank.GUIDE;
        } else if (player.hasPermission("playeressentials.donator")) {
            rank = Rank.DONATOR;
        }
    }
	
	public Rank getRank() {
		return rank;
	}
	
	
	public enum Rank {                  //lists all of our ranks
        ADMIN(ChatColor.DARK_RED),
        MODERATOR(ChatColor.DARK_GREEN),
        HELPER(ChatColor.DARK_PURPLE),
        GUIDE(ChatColor.YELLOW),
        DONATOR(ChatColor.GREEN),
        DEFAULT(ChatColor.GRAY),
        OWNER(ChatColor.GOLD);
        

        

        private ChatColor color;

        private Rank(ChatColor color) {               //sets up colors
            this.color = color;
        }

        public ChatColor getColor() {
            return color;
        }
    }
	
	
	public Player getPlayer() {
        return this.player;
    }

	public UUID getUUID() {
        return getPlayer().getUniqueId();
    }
	
	public void sendMessage(MessageType type, String message) {
        getPlayer().sendMessage(MessageUtil.translate(type.getFormat() + message));
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
