package de.laycraft.LaySimple;

import de.laycraft.LaySimple.CommandAPI.CommandManager;
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
        getServer().getPluginManager().registerEvents(new ScoreboardEvent(this), this);
        getServer().getPluginManager().registerEvents(new ChatEvent(this), this);
        commandManager = new CommandManager(this);
        commandManager.registerCommand(new CommandTest(this));
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
}
