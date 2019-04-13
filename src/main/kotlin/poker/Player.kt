package poker

import org.json.JSONObject

class Player {
    fun betRequest(game_state: JSONObject): Int {
        val allIn = Random.nextInt(0, 100)

        return if(allIn <= 10) { 1000 } else { 0 }
    }

    fun showdown() {
    }

    fun version(): String {
        return "Kotlin Player 0.0.1"
    }
}
