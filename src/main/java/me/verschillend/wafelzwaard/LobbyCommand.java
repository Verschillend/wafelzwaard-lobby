package me.verschillend.wafelzwaard;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class LobbyCommand implements CommandExecutor {

    private final JavaPlugin plugin;

    public LobbyCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("§cOnly players can use this command.");
            return true;
        }

        sender.sendMessage(Component.text("§8Sending you to the lobby..."));

        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("Connect");
        out.writeUTF("lobby");

        player.sendPluginMessage(plugin, "bungeecord:main", out.toByteArray());

        return true;
    }
}
