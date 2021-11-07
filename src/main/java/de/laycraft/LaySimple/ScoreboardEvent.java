package de.laycraft.LaySimple;

import de.laycraft.LaySimple.ScoreboardAPI.ScoreboardAPI;

import org.bukkit.ChatColor;
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

        board.updateTitle(ChatColor.RED + "§b§lLayCraft");

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

        board.updateLines(
                "",
                "§6§l➢ §f§l" + board.getPlayer().getName(),
                "",
                "§6§l➢ " + currentGroup,
                "",
                "§bwww.laycraft.fr"
        );
    };
}