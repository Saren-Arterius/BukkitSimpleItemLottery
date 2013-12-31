package hk.coms.wtako.BukkitSimpleItemLottery.methods;

import hk.coms.wtako.BukkitSimpleItemLottery.Main;

public class Reload {
    
    private Main plugin;

    public Reload(Main plugin) {
        this.plugin = plugin;
    }
    
    public boolean execute() {
        this.plugin.saveDefaultConfig();
        this.plugin.getConfig().options().copyDefaults(true);
        this.plugin.reloadConfig();
        return true;
    }

}
