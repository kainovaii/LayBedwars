package de.laycraft.LaySimple.commands;

import de.laycraft.LaySimple.CommandAPI.Command;
import de.laycraft.LaySimple.Iventory.InventoryEvent;
import de.laycraft.LaySimple.LaySimple;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LaySimpleCommand extends Command {
    LaySimple main;

    public LaySimpleCommand(LaySimple laySimple) {
        super("laysimple", "laysimple.plugins", "Command for plugins", "ls");
        this.main = laySimple;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

        Player player = (Player) sender;

        player.sendMessage("§m§6------------------------------------");
        player.sendMessage("§eEnvironnement: §b " + main.getConfig().getString("informations.environnement"));
        player.sendMessage("§eServeur: §b " +  main.getConfig().getString("informations.server"));
        player.sendMessage("§ePlugins externes: §b VaultAPI");
        player.sendMessage("§ePlugins internes: §b LaySimple §f7584-15245");
        player.sendMessage("§m§6------------------------------------");
    }
}