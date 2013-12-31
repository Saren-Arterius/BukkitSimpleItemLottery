package hk.coms.wtako.BukkitSimpleItemLottery.commands.silot;

import hk.coms.wtako.BukkitSimpleItemLottery.Main;
import hk.coms.wtako.BukkitSimpleItemLottery.methods.Reload;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_reload {
    
    private Main plugin;

    public Command_reload(Main plugin) {
        this.plugin = plugin;
    }
    
    public boolean execute(CommandSender sender, Command cmd, String label, String[] args) {
        
        if (sender.hasPermission("silot.reload")) {
            Reload reload = new Reload(this.plugin);
            reload.execute();
            this.plugin.getLogger().info(this.plugin.getConfig().getString("message.pluginReloadedConsole"));
            if (sender instanceof Player) {
                sender.sendMessage(this.plugin.getConfig().getString("message.pluginReloadedPlayer"));
            } 
        } else {
            sender.sendMessage(this.plugin.getConfig().getString("message.notPermitted"));
        }
        return true;
        
    }
}
