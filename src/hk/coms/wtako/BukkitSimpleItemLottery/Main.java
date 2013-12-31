package hk.coms.wtako.BukkitSimpleItemLottery;

import hk.coms.wtako.BukkitSimpleItemLottery.commands.Command_silot;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

	public void onEnable() {
	    this.saveDefaultConfig();
	    this.getConfig().options().copyDefaults(true);
	    this.getLogger().info("Hello bloody java world!");
	    
	    getCommand("silot").setExecutor(new Command_silot(this));
	}
	
	public void onDisable() {
	    this.getLogger().info("Good-bye bloody chalon!");
	}
    
}
