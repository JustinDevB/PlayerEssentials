package jjbat_000.playeressentials.commands;

import jjbat_000.playeressentials.mondocommand.CallInfo;
import jjbat_000.playeressentials.mondocommand.dynamic.Sub;
import jjbat_000.playeressentials.Core;
//import jjbat_000.playeressentials.PEPlayer;


import jjbat_000.playeressentials.PEPlayer;

//import jjbat_000.playeressentials.util.LocationUtil;
//import jjbat_000.playeressentials.util.MessageType;
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

@Sub(permission = "playeressentials.admin", description = "get a players IP",
         minArgs = 1, usage = "<player>", allowConsole = true)
public void getIP(CallInfo call) {
	String pname = call.getArg(0);
	@SuppressWarnings("deprecation")
	Player p = Bukkit.getPlayer(pname);
	if (p != null) {
		call.reply("IP of " + p.getPlayer().getName() + " is = " + p.getPlayer().getAddress());
	} else {
		call.reply(p + " isn't online!");
	}
}


//Try to figure this one out on your own :P I'm not helping unless you really need it.

@Sub(permission = "playeressentials.admin", description = "Get the first time a player joined the server.",
         minArgs = 1, usage = "<player>", allowConsole = true)
public void firstJoined(CallInfo call) {
        if (call.numArgs() == 1) {
         String pname = call.getArg(0);
        @SuppressWarnings("deprecation")
          Player t = Bukkit.getPlayer(pname);
         @SuppressWarnings("deprecation")
       Player p = Bukkit.getPlayer(pname);
         if (t != null) {
        	 call.reply("First joined = " + new Date(p.getFirstPlayed()).toString());
         }
 }
    
}

    @Sub(permission = "playeressentials.admin", description = "Get a players current rank",
    		minArgs = 1, usage = "<player>", allowConsole = true)
    public void getRank(CallInfo call) {
    	if (call.numArgs() == 1) {
    		String pname = call.getArg(0);
    		@SuppressWarnings("deprecation")
    		Player t = Bukkit.getPlayer(pname);
    		PEPlayer target = core.getPEPlayer(t.getUniqueId());
    		
    		if (t != null) {
    			call.reply(t.getPlayer().getName() + "'s rank is: " + target.getRank());
    		}
    	}
    }

}
