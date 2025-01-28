package and.degilevich.dream.shared.feature.artist.component.list.impl.store.model

import and.degilevich.dream.shared.feature.artist.model.core.ArtistData

internal data class ArtistListState(
    val isLoading: Boolean = false,
    val artists: List<ArtistData> = emptyList()
)