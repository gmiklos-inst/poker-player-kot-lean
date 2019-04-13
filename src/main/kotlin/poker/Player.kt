package poker

import org.json.JSONObject
import kotlin.random.Random

class Player {
    fun betRequest(game_state: JSONObject): Int {
        val activePlayers = numberOfActivePlayers(game_state)

        val chance = when (activePlayers) {
            2 -> 60
            3 -> 25
            else -> 100
        }

        return if (Random.nextInt(0, 100) < chance) { 1000 } else { 0 }
    }

    private fun numberOfActivePlayers(game_state: JSONObject): Int {
        val players = game_state.getJSONArray("players")

        var count = 0

        for (index in 0 until players.length()) {
            val player = players.getJSONObject(index)

            if (player.getString("status") == "active") {
                count++
            }
        }
        return count
    }

    fun showdown() {
    }

    fun version(): String {
        return "Kotlin Player 0.0.1"
    }
}
