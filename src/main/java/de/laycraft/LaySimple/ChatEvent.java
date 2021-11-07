package de.laycraft.LaySimple;

import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.PlaceholderHook;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ChatEvent implements Listener {
    LaySimple main;

    public ChatEvent(LaySimple layScoreboard) {
        this.main = layScoreboard;
    }

    @EventHandler
    public void chatFormat(AsyncPlayerChatEvent event){
        Player player = event.getPlayer();

        String currentGroup = Arrays.toString(main.getPermissions().getPlayerGroups(player));

        if (currentGroup.equals("[admin]")) {
            event.setFormat("§4Admin §4" + player.getName() + " §8» §r" + event.getMessage());
        }

        if (currentGroup.equals("[default]")) {
            event.setFormat("§7Joueur §7" + player.getName() + " §8» §r" + event.getMessage());
        }
    }
}
