BukkitSimpleItemLottery
================
* **Name** - SILOT or BukkitSimpleItemLottery or Simple Item Lottery
* **Purpose** - A simple item lottery plugin, what item you are holding is what exactly the prize is.

# Commands
* **/silot byplayers (winnersCount)** - Start item lottery with exact numbers of winners. 

  Alias: byplayer, players, player
  Example: "/silot byplayers 10", even if you have 1000 players online, the will only be 10 winners.

* **/silot byprob (prob)** - Start item lottery with probability for players to get the prize. 
  Alias: prob
  Example: "/silot byprob 50", everyone will have 50% chance to get the prize.
* **/silot reload** - Reloads the plugin.
* **/silot help|?** - Get about and help messages.

# config.yml

    setting:
        broadcastLotteryResults: True # Display lottery results publicly, or to you only.
    message:
        # Your localizations
    
# permissions

    silot.*:
        description: Gives access to all BukkitSimpleItemLottery commands.
        default: op
        children:
            silot.use: true
            silot.reload: true
    silot.use:
        description: Gives access to lottery commands.
        default: op
    silot.reload:
        description: Allows player to reload BukkitSimpleItemLottery.
        default: op
