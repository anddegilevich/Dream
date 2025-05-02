package and.degilevich.dream.shared.feature.artist.component.list.impl.store.model

import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData
import kotlinx.serialization.Serializable

@Serializable
data class ArtistListState(
    val isLoading: Boolean,
    val artists: List<ArtistData>
)