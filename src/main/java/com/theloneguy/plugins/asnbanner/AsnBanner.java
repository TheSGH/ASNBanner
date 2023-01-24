package com.theloneguy.plugins.asnbanner;

import com.theloneguy.plugins.asnbanner.Listener.Join;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class AsnBanner extends JavaPlugin {

    public static AsnBanner plugin;
    public static Logger logger;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        logger = getLogger();

        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        this.getServer().getPluginManager().registerEvents(new Join(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
