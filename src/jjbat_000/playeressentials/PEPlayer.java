package jjbat_000.playeressentials;


import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;



import jjbat_000.playeressentials.util.MessageType;
import jjbat_000.playeressentials.util.MessageUtil;


/* This class will register stuff about a player.
 * Only register methods for a player in here.
 */

public class PEPlayer {
	private Rank rank = Rank.DEFAULT;
	private Player player;
	
	public void onJoin(PlayerJoinEvent e) {
		e.getPlayer().getName();
		loadRank();
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
        } else if (player.hasPermission("legendsofevon.donator")) {
            rank = Rank.DONATOR;
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
	
	
	

}
