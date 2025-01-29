package and.degilevich.dream.shared.feature.artist.component.details.impl.store.model

import and.degilevich.dream.shared.feature.artist.model.core.ArtistData
import and.degilevich.dream.shared.navigation.api.dream.config.ScreenConfig
import kotlinx.serialization.Serializable

@Serializable
data class ArtistDetailsState(
    val config: ScreenConfig.ArtistDetails,
    val isLoading: Boolean = false,
    val artist: ArtistData = ArtistData.empty(),
    val similarArtists: List<ArtistData> = emptyList()
)
