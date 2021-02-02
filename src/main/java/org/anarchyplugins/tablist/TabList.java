package org.anarchyplugins.tablist;

import net.md_5.bungee.api.chat.ComponentBuilder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.List;

public class TabList implements Runnable {
    TabListMain pl;

    public TabList(TabListMain pl) {
        this.pl = pl;
    }

    public void run() {
        try {
            if (Bukkit.getOnlinePlayers().size() == 0) {
                return;
            }

            for (Player player : Bukkit.getOnlinePlayers()) {
                StringBuilder head = new StringBuilder();
                StringBuilder footer = new StringBuilder();
                List<String> headerlist = pl.getConfig().getStringList("header");
                List<String> footerlist = pl.getConfig().getStringList("footer");

                for (int i = 0; i < headerlist.size(); i++) {
                    if (i == (headerlist.size() - 1)) {
                        head.append(headerlist.get(i));
                    } else {
                        head.append(headerlist.get(i)).append("\n");
                    }
                }

                for (int i = 0; i < footerlist.size(); i++) {
                    if (i == (footerlist.size() - 1)) {
                        footer.append(footerlist.get(i));
                    } else {
                        footer.append(footerlist.get(i)).append("\n");
                    }
                }

                player.setPlayerListHeaderFooter(new ComponentBuilder(TabListMain.parseText(player, head.toString())).create(), new ComponentBuilder(TabListMain.parseText(player, footer.toString())).create());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
