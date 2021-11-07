package de.laycraft.LaySimple;

import de.laycraft.LaySimple.commands.GamemodeCommand;
import de.laycraft.LaySimple.commands.InventoryCommand;
import de.laycraft.LaySimple.CommandAPI.CommandManager;
import de.laycraft.LaySimple.commands.LaySimpleCommand;
import de.laycraft.LaySimple.commands.SpawnCommand;
import de.laycraft.LaySimple.listerners.ChatEvent;
import de.laycraft.LaySimple.listerners.JoinEvent;
import de.laycraft.LaySimple.listerners.ScoreboardEvent;
import net.milkbowl.vault.chat.Chat;
import org.bukkit.event.Listener;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import net.milkbowl.vault.permission.Permission;


public final class LaySimple extends JavaPlugin implements Listener {
    private static Permission perms = null;
    private static Chat chat = null;
    private CommandManager commandManager;

    @Override
    public void onEnable() {
        setupEvent();
        setupCommand();
        setupPermissions();
    }

    private void setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
    }

    private boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return chat != null;
    }

    public static Permission getPermissions() {
        return perms;
    }

    public static Chat getChat() { return chat; }

    public void setupCommand()
    {
        commandManager = new CommandManager(this);
        commandManager.registerCommand(new InventoryCommand(this));
        commandManager.registerCommand(new GamemodeCommand(this));
        commandManager.registerCommand(new SpawnCommand(this));
        commandManager.registerCommand(new LaySimpleCommand(this));
    }

    public void setupEvent()
    {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new ScoreboardEvent(this), this);
        getServer().getPluginManager().registerEvents(new ChatEvent(this), this);
        getServer().getPluginManager().registerEvents(new JoinEvent(this), this);
    }
}
