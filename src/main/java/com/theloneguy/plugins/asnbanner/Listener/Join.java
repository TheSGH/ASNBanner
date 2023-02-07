package com.theloneguy.plugins.asnbanner.Listener;

import com.theloneguy.plugins.asnbanner.ConfigManager.C_Main;
import com.theloneguy.plugins.asnbanner.apiRequest.Request;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

import java.util.List;

public class Join implements Listener {

    @EventHandler
    public void onJoin(AsyncPlayerPreLoginEvent e) {


        String ip = e.getAddress().toString().replace("/", "");

        String asn = Request.doRequest(ip);

        if (asn == null) {

            e.disallow(AsyncPlayerPreLoginEvent.Result.KICK_FULL, "Error, Please Try Again Later !");

        }

        List<?> lst = C_Main.getBannedASN_List();


        if (!lst.contains(asn)) {
            e.allow();
        } else {
            e.disallow(AsyncPlayerPreLoginEvent.Result.KICK_FULL, "You are Banned !");
        }


    }


}
