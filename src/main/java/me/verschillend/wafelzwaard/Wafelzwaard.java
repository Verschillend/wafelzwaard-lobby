package me.verschillend.wafelzwaard;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Wafelzwaard extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Plugin enabled");

        getServer().getMessenger().registerOutgoingPluginChannel(this, "bungeecord:main");

        this.getCommand("lobby").setExecutor(new LobbyCommand(this));
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin disabled");
    }
}
