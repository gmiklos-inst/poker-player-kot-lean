package poker

import poker.model.GameState
import poker.model.Player
import kotlin.random.Random

class PlayerLogic {
    private fun bigBlindMultiplicator(bigBlind: Int): Float = when {
        bigBlind < 10 -> 2.0f
        bigBlind < 25 -> 1f
        else -> 0.3f
    }

    private fun activePlayerMultiplicator(activePlayers: Int): Int {
        return when (activePlayers) {
            2 -> 60
            3 -> 25
            else -> 100
        }
    }

    val weights = arrayOf("2","3","4","5","6","7","8","9","10","J","Q","K","A")

    fun rankWeight(rank: String) = weights.indexOf(rank)

    private fun pairMultiplicator(rank: String?) = when (rank) {
        "2" -> 10
        "3" -> 10
        "4" -> 10
        "5" -> 10
        "6" -> 10
        "7" -> 10
        "8" -> 10
        "9" -> 10
        "10" -> 10
        "J" -> 20
        "Q" -> 70
        "K" -> 80
        "A" -> 100
        else -> 1
    }

    private fun rankMultiplicator(rank: String?) = when (rank) {
        "2" -> 0.2f
        "3" -> 0.3f
        "4" -> 0.4f
        "5" -> 0.5f
        "6" -> 0.6f
        "7" -> 0.7f
        "8" -> 0.8f
        "9" -> 0.9f
        "10" -> 1f
        "J" -> 1.2f
        "Q" -> 1.5f
        "K" -> 2f
        "A" -> 3f
        else -> 1f
    }


    fun Player.hasPairInHand() = if (this.holeCards[0].rank == this.holeCards[1].rank) {
        this.holeCards[0].rank
    } else {
        null
    }

    fun Player.largerRank() = if (rankWeight(this.holeCards[0].rank) >= rankWeight(this.holeCards[1].rank)) {
        this.holeCards[0].rank
    } else {
        this.holeCards[1].rank
    }

    fun betRequest(gameState: GameState): Int {
        val activePlayers = gameState.players.count { it.status == "active" }
        val ourPlayer = gameState.players.find { it.id == gameState.inAction } ?: throw RuntimeException("Could not find our own player")

        val bigBlind = gameState.smallBlind * 2
        val stackInBigBlind = ourPlayer.stack / bigBlind

        val chance = activePlayerMultiplicator(activePlayers) * bigBlindMultiplicator(stackInBigBlind) * pairMultiplicator(ourPlayer.hasPairInHand()) * rankMultiplicator(ourPlayer.largerRank())

        return if (Random.nextInt(0, 100) < chance) { 1000 } else { 0 }
    }

    fun showdown() {
    }

    fun version(): String {
        return "John McPoker v2"
    }
}
