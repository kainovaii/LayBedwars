package de.laycraft.LaySimple.commands;

import de.laycraft.LaySimple.CommandAPI.Command;
import de.laycraft.LaySimple.Iventory.InventoryEvent;
import de.laycraft.LaySimple.Iventory.IventoryGame;
import de.laycraft.LaySimple.LaySimple;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand extends Command {

    public SpawnCommand(LaySimple laySimple) {
        super("spawn", "laysimple.spawn", "Command for teleport to spawn");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

        Player player = (Player) sender;

        Location spawn = new Location(player.getWorld(), 161, 185, -13);

        player.teleport(spawn);
    }
}
