package poker

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.CallLogging
import io.ktor.request.receiveParameters
import io.ktor.response.respondText
import io.ktor.routing.post
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import poker.model.GameState

fun main() {
    embeddedServer(Netty, getPort()) {
        val player = PlayerLogic()

        install(CallLogging)

        routing {
            post("/") {
                val parameters = call.receiveParameters()

                val action = parameters["action"]
                val result = when (action) {
                    "bet_request" -> {
                        val gameStateJson = parameters["game_state"]

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

                call.respondText(result)
            }
        }
    }.start(wait = true)
}

private fun getPort() = System.getenv("PORT")?.let { Integer.parseInt(it) } ?: 2345
