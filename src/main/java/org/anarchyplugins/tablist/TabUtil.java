package org.anarchyplugins.tablist;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;

public class TabUtil {

    public static TextComponent formatTps(double tps) {
        ChatColor color;
        if (tps > 16.0) {
            color = ChatColor.GREEN;
        } else if (tps > 10.0) {
            color = ChatColor.YELLOW;
        } else {
            color = ChatColor.RED;
        }

        double roundedTps = Math.min(Math.round(tps * 100.0) / 100.0, 20.0);
        String tpsString = (tps > 20.0 ? "*" : "") + (roundedTps > 19.75 ? 20.0 : roundedTps);

        TextComponent text = new TextComponent(tpsString);
        text.setColor(color);

        return text;
    }

    public static TextComponent getTps() {
        return formatTps(Bukkit.getServer().getTPS()[0]);
    }

    public static String GetFormattedInterval(long ms) {
        long seconds = ms / 1000L % 60L;
        long minutes = ms / 60000L % 60L;
        long hours = ms / 3600000L % 24L;
        long days = ms / 86400000L;
        return String.format("%dd %02dh %02dm %02ds", days, hours, minutes, seconds);
    }
}