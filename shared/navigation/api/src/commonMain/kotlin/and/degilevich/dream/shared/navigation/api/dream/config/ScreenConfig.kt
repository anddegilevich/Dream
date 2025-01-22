package and.degilevich.dream.shared.navigation.api.dream.config

import kotlinx.serialization.Serializable

@Serializable
sealed interface ScreenConfig {
    @Serializable
    data object ArtistList : ScreenConfig

    @Serializable
    data class ArtistDetails(
        val artistId: String
    ) : ScreenConfig
}