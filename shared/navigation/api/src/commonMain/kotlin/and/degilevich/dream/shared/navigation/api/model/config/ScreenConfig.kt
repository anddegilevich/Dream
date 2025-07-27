package and.degilevich.dream.shared.navigation.api.model.config

import and.degilevich.dream.shared.navigation.api.model.args.AlbumDetailsNavArgs
import and.degilevich.dream.shared.navigation.api.model.args.ArtistDetailsNavArgs
import and.degilevich.dream.shared.navigation.api.model.args.TrackDetailsNavArgs
import kotlinx.serialization.Serializable

@Serializable
sealed interface ScreenConfig {

    // Common
    @Serializable
    data object Splash : ScreenConfig

    @Serializable
    data object Dashboard : ScreenConfig

    // Artist

    @Serializable
    data class ArtistDetails(
        val navArgs: ArtistDetailsNavArgs
    ) : ScreenConfig

    // Album
    @Serializable
    data class AlbumDetails(
        val navArgs: AlbumDetailsNavArgs
    ) : ScreenConfig

    // Track
    @Serializable
    data class TrackDetails(
        val navArgs: TrackDetailsNavArgs
    ) : ScreenConfig

    // User
    @Serializable
    data object Profile : ScreenConfig

    // Search
    @Serializable
    data object Search : ScreenConfig
}