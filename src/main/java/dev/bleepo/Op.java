package dev.bleepo;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class Op implements CommandExecutor {
    private final Main plugin;

    public Op(final Main plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (command.getName().equals("op") && sender instanceof Player) {
            if (args.length < 1) {
                sender.sendMessage(ChatColor.RED + "Invalid Syntax. /op <player>");
                return true;
            }
            final Player player = Bukkit.getPlayer(args[0]);
            if (player == null) {
                sender.sendMessage(ChatColor.AQUA + "[Bleepo'sOpGuard] " + ChatColor.RED + "That player is not whitelisted to be opped!");
                return true;
            }
            final UUID uuid = player.getUniqueId();
            if (this.plugin.getConfig().getStringList("ops").contains(uuid.toString())) {
                player.setOp(true);
                sender.sendMessage("Opped " + player.getDisplayName());
            }
            else {
                this.plugin.getLogger().info(ChatColor.AQUA + "[Bleepo'sOpGuard] " + ChatColor.RED + "That player is not whitelisted to be opped!");
            }
        }
        return true;
    }
}
