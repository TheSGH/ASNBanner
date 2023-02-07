package com.theloneguy.plugins.asnbanner.ConfigManager;

import com.theloneguy.plugins.asnbanner.AsnBanner;

import java.util.List;

public class C_Main {

    private static List<?> Banned_asnList;

    public static List<?> getBannedASN_List() {
        return Banned_asnList;
    }

    public void init() {
        Banned_asnList = AsnBanner.plugin.getConfig().getStringList("list");
    }

    public void reload() {
    }
}
