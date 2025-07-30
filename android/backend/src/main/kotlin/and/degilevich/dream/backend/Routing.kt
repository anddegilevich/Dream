package and.degilevich.dream.backend

import and.degilevich.dream.shared.core.service.api.model.data.artist.ArtistFollowersOutput
import and.degilevich.dream.shared.core.service.api.model.data.artist.ArtistOutput
import and.degilevich.dream.shared.core.service.api.model.method.getArtists.GetArtistsResponse
import io.ktor.server.application.Application
import io.ktor.server.response.respond
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

fun Application.configureRouting() {
    routing {
        get("/artists{...}") {
            call.respond(
                GetArtistsResponse(
                    artists = listOf(
                        ArtistOutput(
                            id = "1",
                            name = "Name",
                            type = "type",
                            popularity = 1,
                            genres = listOf("rock"),
                            followers = ArtistFollowersOutput(
                                total = 10
                            ),
                            images = emptyList()
                        )
                    )
                )
            )
        }
    }
}