package com.theloneguy.plugins.asnbanner.Listener;

import com.theloneguy.plugins.asnbanner.AsnBanner;
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

            e.disallow(AsyncPlayerPreLoginEvent.Result.KICK_FULL, "Error Check Console !");

        }

        List<?> lst = AsnBanner.plugin.getConfig().getList("list");


        if (lst.contains(asn)) {
            e.allow();
        } else {
            e.disallow(AsyncPlayerPreLoginEvent.Result.KICK_FULL, "You are Banned !");
        }

        e.disallow(AsyncPlayerPreLoginEvent.Result.KICK_FULL, "Error Check Console !");


    }


}
