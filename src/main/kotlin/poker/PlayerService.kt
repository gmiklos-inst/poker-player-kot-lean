package poker

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.wasabifx.wasabi.app.AppConfiguration
import org.wasabifx.wasabi.app.AppServer
import poker.model.GameState

fun main() {
    val server = AppServer(AppConfiguration(getPort()))
    val player = PlayerLogic()

    server.post("/", {
        val action = request.bodyParams["action"]
        val result = when (action) {
            "bet_request" -> {
                val gameStateJson = request.bodyParams["game_state"] as? String

                if (gameStateJson == null) {
                    "Missing game_state!"
                } else {
                    val gameState = jacksonObjectMapper().readValue(gameStateJson, GameState::class.java)
                    player.betRequest(gameState).toString()
                }
            }
            "showdown" -> {
                player.showdown()
                "OK"
            }
            "version" -> player.version()
            else -> "Unknown action '$action'!"
        }

        response.send(result)
    })

    server.start()
}

private fun getPort(): Int {
    val port = System.getenv("PORT") ?: "2345"

    return Integer.parseInt(port)
}
