package de.laycraft.LaySimple.listerners;

import de.laycraft.LaySimple.LaySimple;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.Arrays;

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
            event.setFormat("§c⚠ §4Admin §4" + player.getName() + " §8» §r" + event.getMessage());
        }
        if (currentGroup.equals("[moderator]")) {
            event.setFormat("§c⚠ §cModérateur §c" + player.getName() + " §8» §r" + event.getMessage());
        }
        if (currentGroup.equals("[helper]")) {
            event.setFormat("§c⚠ §cHelper §c" + player.getName() + " §8» §r" + event.getMessage());
        }
        if (currentGroup.equals("[default]")) {
            event.setFormat("§c⚠ §7Joueur §7" + player.getName() + " §8» §r" + event.getMessage());
        }
    }
}
