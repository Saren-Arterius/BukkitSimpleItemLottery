package hk.coms.wtako.BukkitSimpleItemLottery.methods;

import java.util.Random;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ByPlayers {
    
    private Player[] playersList;
    private ItemStack prize;
    private Player presenter;

    public ByPlayers(Player presenter, Player[] playersList, ItemStack prize) {
        this.presenter = presenter;
        this.playersList = playersList;
        this.prize = prize;
    }
    
    public Player[] startLottery(int winnersCount) {
        Player[] winnersList = new Player[winnersCount];
        Random generator = new Random(); 
        int i = 0;
        
        while (i < winnersCount) {
            int randNum = generator.nextInt(playersList.length);
            if ( (playersList[randNum] != null) && (playersList[randNum] != presenter) ) { // Presenter won't get the prize
                try {
                    winnersList[i] = playersList[randNum];
                    playersList[randNum].getInventory().addItem(prize);
                } catch (Exception ex) {
                    // who cares?
                } finally {
                    playersList[randNum] = null;
                    i++;
                }
            }
        }
        
        return winnersList;
    }
}
