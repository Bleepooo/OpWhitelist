package dev.bleepo;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    public void onEnable() {
        saveDefaultConfig();
        getCommand("op").setExecutor((CommandExecutor)new Op(this));
        getLogger().info("Plugin Loaded");
    }

    public void onDisable() {
    }
}
