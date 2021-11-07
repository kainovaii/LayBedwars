package de.laycraft.LaySimple;

import de.laycraft.LaySimple.CommandAPI.Command;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class CommandTest extends Command {
    public CommandTest(LaySimple laySimple) {
        super("testbetter", "bettercommands.test", "Test", "testbetters");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

        if (args.length > 0 && args[0].equalsIgnoreCase("remove")) {

            sender.sendMessage(ChatColor.GREEN + "Command removed");
            return;
        }

        sender.sendMessage(ChatColor.GOLD + "It's work =)");
    }
}
