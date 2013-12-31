package hk.coms.wtako.BukkitSimpleItemLottery.commands;

import hk.coms.wtako.BukkitSimpleItemLottery.Main;
import hk.coms.wtako.BukkitSimpleItemLottery.commands.silot.Command_byplayers;
import hk.coms.wtako.BukkitSimpleItemLottery.commands.silot.Command_byprob;
import hk.coms.wtako.BukkitSimpleItemLottery.commands.silot.Command_help;
import hk.coms.wtako.BukkitSimpleItemLottery.commands.silot.Command_reload;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Command_silot implements CommandExecutor {

    private Main plugin;
    public Command_silot(Main plugin) {
        this.plugin = plugin;
    }
    
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("silot")) {

            if (args.length == 0) {
                return false;
                
            } else if (args[0].equalsIgnoreCase("reload")) {
                Command_reload command = new Command_reload(this.plugin);
                return command.execute(sender, cmd, label, args);
                
            } else if (args[0].equalsIgnoreCase("byprob")) {
                Command_byprob command = new Command_byprob(this.plugin);
                return command.execute(sender, cmd, label, args);
                
            } else if ((args[0].equalsIgnoreCase("byplayer")) || (args[0].equalsIgnoreCase("byplayers"))) {
                Command_byplayers command = new Command_byplayers(this.plugin);
                return command.execute(sender, cmd, label, args);
                
            } else if ((args[0].equalsIgnoreCase("?")) || (args[0].equalsIgnoreCase("help"))) {
                Command_help command = new Command_help();
                return command.execute(sender, cmd, label, args);
                
            }
        }
        return false;
    }

}
