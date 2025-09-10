package me.verschillend.wafelzwaard;

import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Constructor;
import java.util.List;

public final class Wafelzwaard extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        PluginCommand lobbyCommand = createCommand("lobby");
        lobbyCommand.setExecutor(new LobbyCommand(this));
        lobbyCommand.setDescription("Sends player to lobby server");
        lobbyCommand.setPermission("wafelzwaard.lobby");
        lobbyCommand.setAliases(List.of("hub"));
        getServer().getCommandMap().register("wafelzwaard", lobbyCommand);
        getLogger().info("Plugin enabled");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin disabled");
    }

    private PluginCommand createCommand(String name) {
        try {
            Constructor<PluginCommand> c = PluginCommand.class.getDeclaredConstructor(String.class, Plugin.class);
            c.setAccessible(true);
            return c.newInstance(name, this);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create command: " + name, e);
        }
    }
}
