package hk.coms.wtako.BukkitSimpleItemLottery.commands;

import java.text.MessageFormat;

import hk.coms.wtako.BukkitSimpleItemLottery.Main;
import hk.coms.wtako.BukkitSimpleItemLottery.methods.ByPlayers;
import hk.coms.wtako.BukkitSimpleItemLottery.methods.ByProb;
import hk.coms.wtako.BukkitSimpleItemLottery.methods.Reload;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Command_silot implements CommandExecutor {

    private Main plugin;
    private int winnersCount;
    private int prob;
    
    public Command_silot(Main plugin) {
        this.plugin = plugin;
    }
    
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("silot")) {
            
            if (args.length == 0) {
                return false;
                
            } else if (args[0].equalsIgnoreCase("reload")) {
                Reload reload = new Reload(this.plugin);
                reload.execute();
                this.plugin.getLogger().info(this.plugin.getConfig().getString("message.pluginReloadedConsole"));
                if (sender instanceof Player) {
                    sender.sendMessage(this.plugin.getConfig().getString("message.pluginReloadedPlayer"));
                }
                return true;
                
            } else if (args[0].equalsIgnoreCase("byprob")) {
                
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
                } else {
                    ByProb lottery = new ByProb(presenter, playersList, prize);
                    Player[] winnersList = lottery.startLottery(prob);
                    sender.sendMessage(this.plugin.getConfig().getString("message.followPlayersGotThePrize"));
                    String msg = "";
                    for (int i = 0; i < winnersList.length; i++) {
                        if (winnersList[i] != null) {
                            winnersList[i].sendMessage("");
                            msg += winnersList[i].getName()+", ";
                        }
                    }
                    sender.sendMessage(msg);
                    return true;
                }
                
            } else if (args[0].equalsIgnoreCase("byplayers")) {
                
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
                } else {
                    ByPlayers lottery = new ByPlayers(presenter, playersList, prize);
                    Player[] winnersList = lottery.startLottery(winnersCount);
                    sender.sendMessage(this.plugin.getConfig().getString("message.followPlayersGotThePrize"));
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
        return false;
    }

}
