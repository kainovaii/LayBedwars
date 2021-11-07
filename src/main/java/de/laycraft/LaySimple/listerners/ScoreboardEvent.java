package de.laycraft.LaySimple.listerners;

import de.laycraft.LaySimple.LaySimple;
import de.laycraft.LaySimple.ScoreboardAPI.ScoreboardAPI;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ScoreboardEvent implements Listener {

    private final Map<UUID, ScoreboardAPI> boards = new HashMap<>();
    private LaySimple main;

    public ScoreboardEvent(LaySimple layScoreboard)
    {
        this.main = layScoreboard;

        main.getServer().getScheduler().runTaskTimer(main, () -> {
            for (ScoreboardAPI board : this.boards.values()) {
                updateBoard(board);
            }
        }, 0, 20);

    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        ScoreboardAPI board = new ScoreboardAPI(player);

        board.updateTitle("§f● §c§lLayCraft §f●");

        this.boards.put(player.getUniqueId(), board);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();

        ScoreboardAPI board = this.boards.remove(player.getUniqueId());

        if (board != null) {
            board.delete();
        }
    }

    public void updateBoard(ScoreboardAPI board) {
        String currentGroup = Arrays.toString(main.getPermissions().getPlayerGroups(board.getPlayer()));
        String currentPlayer =  board.getPlayer().getName();

        if (currentGroup.equals("[admin]")) {
            board.updateLines(
                    "",
                    "§7Nom§f: §b" + currentPlayer,
                    "§7Grade§f: §4Admin",
                    "",
                    "§cEuros§f: §c00.0",
                    "§7Lobby§f: §b#1",
                    "",
                    "§7 www.laycraft.fr"
            );
        }

        if (currentGroup.equals("[moderator]")) {
            board.updateLines(
                    "",
                    "§7Nom§f: §b" + currentPlayer,
                    "§7Grade§f: §cModérateur",
                    "",
                    "§cEuros§f: §c00.0",
                    "§7Lobby§f: §b#1",
                    "",
                    "§7 www.laycraft.fr"
            );
        }

        if (currentGroup.equals("[helper]")) {
            board.updateLines(
                    "",
                    "§7Nom§f: §b" + currentPlayer,
                    "§7Grade§f: §cHelper",
                    "",
                    "§cEuros§f: §c00.0",
                    "§7Lobby§f: §b#1",
                    "",
                    "§7 www.laycraft.fr"
            );
        }

        if (currentGroup.equals("[default]")) {
            board.updateLines(
                    "",
                    "§7Nom§f: §b" + currentPlayer,
                    "§7Grade§f: §7Joueur",
                    "",
                    "§cEuros§f: §c00.0",
                    "§7Lobby§f: §b#1",
                    "",
                    "§7 www.laycraft.fr"
            );
        }
    };
}