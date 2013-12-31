package hk.coms.wtako.BukkitSimpleItemLottery.methods;

import java.util.Random;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ByProb {

    private Player[] playersList;
    private ItemStack prize;
    private Player presenter;

    public ByProb(Player presenter, Player[] playersList, ItemStack prize) {
        this.presenter = presenter;
        this.playersList = playersList;
        this.prize = prize;
    }
    
    public Player[] startLottery(int prob) {
        Player[] winnersList = new Player[playersList.length];
        Random generator = new Random(); 

        for (int i = 0; i < playersList.length; i++) {
            int randNum = generator.nextInt(100);
            
            if ( (randNum <= prob) && (playersList[i] != presenter) ) { // Presenter won't get the prize
                try {
                    playersList[i].getInventory().addItem(prize);
                    winnersList[i] = playersList[i];
                } catch (Exception ex) {
                    // nobody cares
                }
            }
        }
        
        return winnersList;
    }
}
