package de.laycraft.LaySimple.Iventory;

import de.laycraft.LaySimple.InventoryAPI.InventoryAPI;
import de.laycraft.LaySimple.InventoryAPI.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.ItemStack;

public class IventoryGame extends InventoryAPI {
    private boolean preventClose = false;

    public IventoryGame() {

        super(45, "§6§l★ §b§lGame modes §6§l★");



        setItem(22, new ItemBuilder(Material.BARRIER).name("§6Faction §8— §cHors ligne").addLore(
                "",
                "§7Description",
                "§fOrbos nascitur inanes nascitur",
                "§fqua quicquid homines caelibes.",
                "",
                "§f● §e0 §fJoueurs en jeux",
                "",
                "§cDeveloppeur: KainoVaii",
                "",
                "§f➠ §7Cliquez pour rejoindre"
        ).build(), e -> {
            this.preventClose = !this.preventClose;
        });
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

    }
}
