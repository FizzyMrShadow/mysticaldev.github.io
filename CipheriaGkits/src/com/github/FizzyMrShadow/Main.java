package com.github.FizzyMrShadow;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;

public class Main extends org.bukkit.plugin.java.JavaPlugin implements org.bukkit.event.Listener
{
	public String colorConvert(String string)
	{
		return ChatColor.translateAlternateColorCodes('&', string);
	}

	String prefix = "§e§Cipheria §d§lGkits &§&§»§7";

	public void onEnable()
	{
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(this, this);
		ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();

		console.sendMessage(ChatColor.GOLD + "-=-=-=-=-=-");
		console.sendMessage(ChatColor.YELLOW + "CipheriaGkits");
		console.sendMessage(ChatColor.GOLD + "Made By Stylinq");
		console.sendMessage(ChatColor.GOLD + "-=-=-=-=-=-");
	}

	public void onDisable()
	{
		System.out.print("prefix Has been disabled!");
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{
		Player player = (Player)sender;


		if (commandLabel.equalsIgnoreCase("gkits")) {
			createMenu(player);
		}



		return false;
	}

	@EventHandler
	public void onInvClick(InventoryClickEvent event) {
		ItemStack item = event.getCurrentItem();


		if (event.getInventory().getName() == "§f*§e*§f*§e*§f* §e§lCipheria Gkits §f*§e*§f*§e*§f*") {
			if (item.hasItemMeta()) {
				if (item.getItemMeta().getDisplayName().contains("§e§lSavage")) {
					Bukkit.getServer().dispatchCommand(event.getWhoClicked(), "kit gkit2" + event.getWhoClicked());
					event.setCancelled(true);
				}
				if (!item.getItemMeta().getDisplayName().contains("§e§lFallen")) return;
				Bukkit.getServer().dispatchCommand(event.getWhoClicked(), "kit gkit1" + event.getWhoClicked());
				event.setCancelled(true);
			}
		}
		else {}
	}
	
	
	public ItemStack createItem(String name, Material mat, ArrayList<String> arrayLore) {
		ItemStack item = new ItemStack(Material.mat);
		ItemMeta meta = item.getItemMeta();
		
		item1Meta.setDisplayName(name);
		item1Meta.setLore(lore);
	}




	public void createMenu(Player player)
	{
		Inventory inv = Bukkit.getServer().createInventory(null, 45, "§f*§e*§f*§e*§f* §e§lCipheria Gkits §f*§e*§f*§e*§f*");

		ArrayList<String> item1Lore = new ArrayList<String>();
		item1Lore.add("§9Please stand back.");
		
		inv.setItem(0, createItem("Awesome Item", Material.DIAMOND, item1Lore);
		
		ArrayList<String> item2Lore = new ArrayList<String>();
		item1Lore.add("§9Watch out, we wouldn't want you to get hurt.");
		
		inv.setItem(1, createItem("Awesome Second Item", Material.NETHER_STAR, item2Lore);

		player.openInventory(inv);
	}
}
