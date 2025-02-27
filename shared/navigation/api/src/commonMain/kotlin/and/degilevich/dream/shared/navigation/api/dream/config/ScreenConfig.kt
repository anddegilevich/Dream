package and.degilevich.dream.shared.navigation.api.dream.config

import and.degilevich.dream.shared.navigation.api.dream.args.ArtistDetailsNavArgs
import kotlinx.serialization.Serializable

@Serializable
sealed interface ScreenConfig {
    @Serializable
    data object ArtistList : ScreenConfig

    @Serializable
    data class ArtistDetails(
        val navArgs: ArtistDetailsNavArgs
    ) : ScreenConfig
}