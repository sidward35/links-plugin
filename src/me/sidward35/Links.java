package me.sidward35;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class Links extends JavaPlugin{
	ListenerClass lc;
	@Override
	public void onEnable(){
		lc = new ListenerClass(this);
		getConfig().addDefault("links", "");
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	@Override
	public void onDisable(){
		saveConfig();
	}
	
	@EventHandler
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("links") && sender instanceof Player){
			Player player = (Player)sender;
			player.sendMessage("Here are the server links, "+player.getName()+":\n");
			String links=lc.configGetter.getConfig().getString("links");
			player.sendMessage(ChatColor.GREEN + links);
			return true;
		}
		return false;
	}
}
