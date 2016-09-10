package me.sidward35;

import org.bukkit.event.Listener;

public class ListenerClass implements Listener{
	public Links configGetter;
	
	public ListenerClass(Links plugin){
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		configGetter=plugin;
	}
}
