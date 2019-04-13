package poker

import org.json.JSONObject
import kotlin.random.Random

class Player {
    fun betRequest(game_state: JSONObject): Int {

        val allInMap = mutableMapOf<Int, Int>()
        allInMap[1] = 100
        allInMap[2] = 60
        allInMap[3] = 25

        val allIn = Random.nextInt(0, 100)

        return if(allIn < 40) { 1000 } else { 0 }
    }

    fun showdown() {
    }

    fun version(): String {
        return "Kotlin Player 0.0.1"
    }
}
