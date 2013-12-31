BukkitSimpleItemLottery
================
* **Name** - SILOT or BukkitSimpleItemLottery or Simple Item Lottery
* **Purpose** - A simple item lottery plugin, the prize is the item that you are holding.

# Commands
* **/silot byplayers|byplayer|players|player (winnersCount)** - Start item lottery with exact numbers of winners. Example: /silot byplayers 10
* **/silot byprob|prob (prob)** - Start item lottery with probability for players to get the prize. Example: /silot byprob 50
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
