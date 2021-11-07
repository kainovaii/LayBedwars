package de.laycraft.LaySimple.listerners;

import de.laycraft.LaySimple.LaySimple;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {
    LaySimple main;
    public JoinEvent(LaySimple laySimple) {
        this.main = laySimple;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event)
    {
        Player player = event.getPlayer();
        Location spawn = new Location(player.getWorld(), 161, 185, -13);

        player.setGameMode(GameMode.SURVIVAL);
        player.teleport(spawn);
    }
}
