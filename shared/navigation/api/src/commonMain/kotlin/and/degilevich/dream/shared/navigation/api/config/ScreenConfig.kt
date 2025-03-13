package and.degilevich.dream.shared.navigation.api.config

import and.degilevich.dream.shared.navigation.api.args.ArtistDetailsNavArgs
import kotlinx.serialization.Serializable

@Serializable
sealed interface ScreenConfig {

    // Artist
    @Serializable
    data object ArtistList : ScreenConfig

    @Serializable
    data class ArtistDetails(
        val navArgs: ArtistDetailsNavArgs
    ) : ScreenConfig

    // User
    @Serializable
    data object Profile : ScreenConfig
}