package hk.coms.wtako.BukkitSimpleItemLottery.commands.silot;

import hk.coms.wtako.BukkitSimpleItemLottery.Main;
import hk.coms.wtako.BukkitSimpleItemLottery.methods.ByProb;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Command_byprob {
    
    private Main plugin;
    private int prob;

    public Command_byprob(Main plugin) {
        this.plugin = plugin;
    }
    
    public boolean execute(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            this.plugin.getLogger().info(this.plugin.getConfig().getString("commandForPlayersOnly"));
            return true;
        }
        
        Player[] playersList = Bukkit.getOnlinePlayers();
        
        try {
            prob = Integer.parseInt(args[1]);
            if (prob <= 0 || prob > 100) {
                throw new Exception("wrongProbValue");
            }
        } catch (Exception ex) {
            sender.sendMessage(this.plugin.getConfig().getString("message.wrongValueByProb"));
            return false;
        }

        Player presenter = (Bukkit.getServer().getPlayer(sender.getName()));
        ItemStack prize = presenter.getItemInHand();
        
        if (prize.getAmount() <= 0) {
            sender.sendMessage(this.plugin.getConfig().getString("message.cannotGiveAwayAir"));
            return true;
        } else {
            ByProb lottery = new ByProb(presenter, playersList, prize);
            Player[] winnersList = lottery.startLottery(prob);
            
            String msg = "";
            for (int i = 0; i < winnersList.length; i++) {
                if (winnersList[i] != null) {
                    winnersList[i].sendMessage(this.plugin.getConfig().getString("message.youGotThePrize"));
                    msg += winnersList[i].getName()+", ";
                }
            }
            
            if (this.plugin.getConfig().getBoolean("setting.broadcastLotteryResults")) {
                this.plugin.getServer().broadcastMessage(this.plugin.getConfig().getString("message.followingPlayersGotThePrize"));
                this.plugin.getServer().broadcastMessage(msg);
            } else {
                sender.sendMessage(this.plugin.getConfig().getString("message.followingPlayersGotThePrize"));
                sender.sendMessage(msg);
            }

            return true;
        }
    }
}
