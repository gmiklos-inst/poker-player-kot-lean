package poker

import poker.model.GameState
import poker.model.Player
import kotlin.random.Random

class PlayerLogic {
    private fun bigBlindMultiplicator(bigBlind: Int): Float = when {
        bigBlind < 10 -> 2.0f
        bigBlind < 25 -> 1f
        else -> 0.5f
    }

    private fun activePlayerMultiplicator(activePlayers: Int): Int {
        return when (activePlayers) {
            2 -> 60
            3 -> 25
            else -> 100
        }
    }

    private fun pairMultiplicator(rank: String?) = when (rank) {
        "2" -> 2
        "3" -> 3
        "4" -> 4
        "5" -> 5
        "6" -> 6
        "7" -> 7
        "8" -> 8
        "9" -> 9
        "10" -> 10
        "J" -> 20
        "Q" -> 70
        "K" -> 80
        "A" -> 100
        else -> 1
    }

    fun Player.hasPairInHand() = this.holeCards
            .groupBy { it.rank }
            .map { (rank, values) -> rank to values.size }
            .maxBy { it.second }
            ?.let { (rank, count) -> if (count > 1) rank else null }


    fun betRequest(gameState: GameState): Int {
        val activePlayers = gameState.players.count { it.status == "active" }
        val ourPlayer = gameState.players.find { it.id == gameState.inAction } ?: throw RuntimeException("Could not find our own player")

        val bigBlind = gameState.smallBlind * 2
        val stackInBigBlind = ourPlayer.stack / bigBlind

        val chance = activePlayerMultiplicator(activePlayers) * bigBlindMultiplicator(stackInBigBlind) * pairMultiplicator(ourPlayer.hasPairInHand())

        return if (Random.nextInt(0, 100) < chance) { 1000 } else { 0 }
    }

    fun showdown() {
    }

    fun version(): String {
        return "John McPoker"
    }
}
