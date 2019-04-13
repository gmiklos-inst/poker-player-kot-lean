package poker

import poker.model.GameState
import kotlin.random.Random

class Player {
    fun betRequest(gameState: GameState): Int {
        val activePlayers = gameState.players.count { it.status == "active" }

        val chance = when (activePlayers) {
            2 -> 60
            3 -> 25
            else -> 100
        }

        return if (Random.nextInt(0, 100) < chance) { 1000 } else { 0 }
    }

    fun showdown() {
    }

    fun version(): String {
        return "Kotlin Player 0.0.1"
    }
}
