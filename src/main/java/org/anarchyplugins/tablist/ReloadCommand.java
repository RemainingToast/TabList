package org.anarchyplugins.tablist;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class ReloadCommand implements CommandExecutor {
    TabListMain pl;
    public ReloadCommand(TabListMain pl) {
        this.pl = pl;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof ConsoleCommandSender) {
            pl.reloadConfig();
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aReloaded Config"));
        }

        if (sender instanceof Player && sender.isOp()) {
            pl.reloadConfig();
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aReloaded Config"));
        }

        return true;
    }
}
