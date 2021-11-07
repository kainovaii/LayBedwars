package de.laycraft.LaySimple.commands;

import de.laycraft.LaySimple.CommandAPI.Command;
import de.laycraft.LaySimple.Iventory.InventoryEvent;
import de.laycraft.LaySimple.Iventory.IventoryGame;
import de.laycraft.LaySimple.LaySimple;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommand extends Command {

    public GamemodeCommand(LaySimple laySimple) {
        super("gamemode", "laysimple.gamemode", "Command for gamemode", "gm");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

        Player player = (Player) sender;

        if (args.length > 0 && args[0].equalsIgnoreCase("creative")) {
            player.setGameMode(GameMode.CREATIVE);
            player.sendMessage("§7Mode de jeu §bcréatif §7defini pour §b" + player.getName());

            return;
        }

        if (args.length > 0 && args[0].equalsIgnoreCase("survival")) {
            player.setGameMode(GameMode.SURVIVAL);
            player.sendMessage("§7Mode de jeu §bsurvie §7defini pour §b" + player.getName());
            return;
        }

        if (args.length > 0 && args[0].equalsIgnoreCase("spectator")) {
            player.setGameMode(GameMode.SPECTATOR);
            player.sendMessage("§7Mode de jeu §bspéctateur §7defini pour §b" + player.getName());
            return;
        }

        player.sendMessage("§b§lLaySimple §f» §cUsage /gm <creative : survival : spectator>");
    }
}
