package hk.coms.wtako.BukkitSimpleItemLottery.commands.silot;

import java.text.MessageFormat;

import hk.coms.wtako.BukkitSimpleItemLottery.Main;
import hk.coms.wtako.BukkitSimpleItemLottery.methods.ByPlayers;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Command_byplayers {
    
    private Main plugin;
    private int winnersCount;

    public Command_byplayers(Main plugin) {
        this.plugin = plugin;
    }
    
    public boolean execute(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            this.plugin.getLogger().info(this.plugin.getConfig().getString("commandForPlayersOnly"));
            return true;
        }
        
        Player[] playersList = Bukkit.getOnlinePlayers();
        
        try {
            winnersCount = Integer.parseInt(args[1]);
            if (winnersCount <= 0 || winnersCount > (playersList.length - 1) ) {  // Presenter won't get the prize
                throw new Exception("wrongWinnersValue");
            }
        } catch (Exception ex) {
            String msg = this.plugin.getConfig().getString("message.wrongValueByPlayers");
            msg = MessageFormat.format(msg, playersList.length - 1);
            sender.sendMessage(msg);
            return false;
        }

        Player presenter = (Bukkit.getServer().getPlayer(sender.getName()));
        ItemStack prize = presenter.getItemInHand();
        
        if (prize.getAmount() <= 0) {
            sender.sendMessage(this.plugin.getConfig().getString("message.cannotGiveAwayAir"));
            return true;
        } else {
            ByPlayers lottery = new ByPlayers(presenter, playersList, prize);
            Player[] winnersList = lottery.startLottery(winnersCount);
            sender.sendMessage(this.plugin.getConfig().getString("message.followingPlayersGotThePrize"));
            String msg = "";
            for (int i = 0; i < winnersList.length; i++) {
                winnersList[i].sendMessage(this.plugin.getConfig().getString("message.youGotThePrize"));
                msg += winnersList[i].getName()+", ";
            }
            sender.sendMessage(msg);
            return true;
        }
    }
}
