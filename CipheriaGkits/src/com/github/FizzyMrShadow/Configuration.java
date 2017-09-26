package com.github.FizzyMrShadow;


import org.bukkit.ChatColor;

public class Configuration {

    public static Main plugin;

    public Configuration(Main instance) {
        plugin = instance;
    }
    
    public void setupConfiguration() {
        plugin.getServer().getLogger().info("Configuration has been checked");
        plugin.config.options().header(plugin.getName() + " sexified by Aries Clark | https://ariesc.me");
        plugin.config.options().copyDefaults(true);
        plugin.saveConfig();
    }

    // CUSTOMIZATION & LANG

    public static String getLang(String hook, String string){
        return ChatColor.translateAlternateColorCodes('&', plugin.config.getString(hook + ".Language." + string));
    }
    
    public static void addLang(String hook, String string, String message){
        if (!string.isEmpty() && !message.isEmpty()) {
            plugin.config.addDefault(hook + ".Language." + string, message);
            plugin.config.options().copyDefaults(true);
            plugin.saveConfig();
        }
        else {
            return;
        }
    }
    
    public static void addConfig(String hook, String path, Object value){
        plugin.config.addDefault(hook + "." + path, value);
        plugin.config.options().copyDefaults(true);
        plugin.saveConfig();
    }

    public static void setConfig(String hook, String path, Object value){
        plugin.config.set(hook + "." + path, value);
        plugin.saveConfig();
    }

    public static Object getConfig(String hook, String path){
        return plugin.config.get(hook + "." + path);
    }

}
