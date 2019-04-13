package poker

import poker.model.GameState
import kotlin.random.Random

class Player {
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

    fun betRequest(gameState: GameState): Int {
        val activePlayers = gameState.players.count { it.status == "active" }

        val bigBlind = gameState.smallBlind * 2
        val ourPlayer = gameState.players.find { it.id == gameState.inAction } ?: throw RuntimeException("Could not find our own player")

        val stackInBigBlind = ourPlayer.stack / bigBlind

        val chance = activePlayerMultiplicator(activePlayers) * bigBlindMultiplicator(stackInBigBlind)

        return if (Random.nextInt(0, 100) < chance) { 1000 } else { 0 }
    }

    fun showdown() {
    }

    fun version(): String {
        return "John McPoker"
    }
}
