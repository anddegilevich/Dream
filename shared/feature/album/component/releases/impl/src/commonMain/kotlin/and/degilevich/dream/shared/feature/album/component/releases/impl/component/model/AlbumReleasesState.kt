package and.degilevich.dream.shared.feature.album.component.releases.impl.component.model

import and.degilevich.dream.shared.feature.album.model.artifact.api.data.AlbumSimplifiedData
import kotlinx.serialization.Serializable

@Serializable
data class AlbumReleasesState(
    val isLoading: Boolean,
    val releases: List<AlbumSimplifiedData>
)