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
    broadcastLotteryResults: True
    
    message:
        # Your localizations
# permissions

    fuck.*:
        description: Gives access to all BukkitHelloWorld commands.
        children:
            fuck.qualifiedToFuck: true
            fuck.allowsSelfFucking: true
            fuck.allowsLimitsOverriding: true
            fuck.reload: true
    fuck.qualifiedToFuck:
        description: Allows you to fuck somebody.
        default: op
    fuck.allowsSelfFucking:
        description: Allows you to fuck yourself.
        default: op
    fuck.allowsLimitsOverriding:
        description: Allows you to override the limits.
        default: op
    fuck.reload:
        description: Allows you to reload your penis.
        default: op
