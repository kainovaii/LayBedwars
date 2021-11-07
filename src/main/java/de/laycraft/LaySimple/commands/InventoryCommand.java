package de.laycraft.LaySimple.commands;

import de.laycraft.LaySimple.CommandAPI.Command;
import de.laycraft.LaySimple.Iventory.InventoryEvent;
import de.laycraft.LaySimple.Iventory.IventoryGame;
import de.laycraft.LaySimple.LaySimple;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InventoryCommand extends Command {

    public InventoryCommand(LaySimple laySimple) {
        super("menu", "laysimple.basic", "Command for open custom gui");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

        Player player = (Player) sender;

        if (args.length > 0 && args[0].equalsIgnoreCase("test")) {
            new InventoryEvent().open(player);
            return;
        }

        if (args.length > 0 && args[0].equalsIgnoreCase("game")) {
            new IventoryGame().open(player);
            return;
        }

        player.sendMessage("§b§lLaySimple §f» §cUsage /menu <name>");
    }
}
