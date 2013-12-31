package hk.coms.wtako.BukkitSimpleItemLottery.commands.silot;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class Command_help {
    
    public boolean execute(CommandSender sender, Command cmd, String label, String[] args) {
        sender.sendMessage("Bukkit Simple Item Lottery v0.0.1a");
        sender.sendMessage("Author: Saren");
        sender.sendMessage("The prize will be you item you are holding.");
        sender.sendMessage("------------------------");
        sender.sendMessage("/silot byplayers (winnersCount)");
        sender.sendMessage("Function: There must be exact numbers of winners.");
        sender.sendMessage("Example: '/silot byplayers 10', even if you have 1000 players online, the will only be 10 winners.");
        sender.sendMessage("------------------------");
        sender.sendMessage("/silot byprob (prob)");
        sender.sendMessage("Function: A player will have (prob)% chance to be a winner.");
        sender.sendMessage("Example: '/silot byprob 50', everyone has 50% chance to be a winner.");
        sender.sendMessage("------------------------");
        sender.sendMessage("/silot reload");
        sender.sendMessage("Function: Reloads the plugin.");
        return true;
    }
}
