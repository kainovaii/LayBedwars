package de.laycraft.LaySimple;

import de.laycraft.LaySimple.InventoryAPI.InventoryAPI;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryEvent extends InventoryAPI {

    public InventoryEvent() {
        super(45, "§cTestInv");

        setItem(22, new ItemStack(Material.IRON_SWORD), e -> e.getWhoClicked().sendMessage("test"));
    }

    @Override
    public void onOpen(InventoryOpenEvent event) {
        event.getPlayer().sendMessage(ChatColor.GOLD + "You opened the inventory");
    }

    @Override
    public void onClose(InventoryCloseEvent event) {
        event.getPlayer().sendMessage(ChatColor.GOLD + "You closed the inventory");
    }

    @Override
    public void onClick(InventoryClickEvent event) {
        // do something
    }
}
