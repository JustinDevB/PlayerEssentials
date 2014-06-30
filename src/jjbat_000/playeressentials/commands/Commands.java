package jjbat_000.playeressentials.commands;

import jjbat_000.playeressentials.mondocommand.CallInfo;
import jjbat_000.playeressentials.mondocommand.dynamic.Sub;
import jjbat_000.playeressentials.Core;
import jjbat_000.playeressentials.PEPlayer;
import jjbat_000.playeressentials.util.LocationUtil;
import jjbat_000.playeressentials.util.MessageType;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Date;

//This is the class that we'll register commands in.

public class Commands {
	private Core core;   //initializes core

 public Commands(Core core) {  //registers core
	 this.core = core;
	 
	 }
 


@Sub(permission = "playeressentials.admin", description = "get a uuid of a player",
         minArgs = 1, usage = "<player>", allowConsole = true)     //initializes SubHandler
 public void getUUID(CallInfo call) {
     String pname = call.getArg(0);      //tells it that we want pname to be equal to whatever name you type in chat
     @SuppressWarnings("deprecation")
	Player p = Bukkit.getPlayer(pname);   //tells it that p is = to whoever we typed in chat
     if (p != null) {                      //executes if the player is online
      call.reply("UUID = " + p.getUniqueId().toString() );   //gets the UUID and converts it to a string
    // } else {
     //    call.reply(p + " isn't online!");   //what happens if the player isn't online. Currently doesn't support offline players, so no point in having this...
     //}

     }
           
   }

}
