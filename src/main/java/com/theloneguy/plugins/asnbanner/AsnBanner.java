package com.theloneguy.plugins.asnbanner;

import com.theloneguy.plugins.asnbanner.ConfigManager.C_Main;
import com.theloneguy.plugins.asnbanner.Listener.Join;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class AsnBanner extends JavaPlugin {

    public static AsnBanner plugin;
    public static Logger logger;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        logger = this.getLogger();
        new C_Main().init();

        getConfig().options().copyDefaults(true);
        saveDefaultConfig();


        if (!getConfig().getBoolean("enable")) {


            logger.log(Level.SEVERE, "Plugin is Disabled, Change config & restart To enable !");


            getServer().getPluginManager().disablePlugin(this);

            return;
        }

        this.getServer().getPluginManager().registerEvents(new Join(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
