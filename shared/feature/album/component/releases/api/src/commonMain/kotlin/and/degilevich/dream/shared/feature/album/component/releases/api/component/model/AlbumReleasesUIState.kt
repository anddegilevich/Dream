package and.degilevich.dream.shared.feature.album.component.releases.api.component.model

import and.degilevich.dream.shared.feature.album.design.api.model.AlbumCardUIData
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
data class AlbumReleasesUIState(
    val isLoading: Boolean,
    val releases: ImmutableList<AlbumCardUIData>
) {
    companion object : EmptyFactory<AlbumReleasesUIState> {
        override fun empty(): AlbumReleasesUIState {
            return AlbumReleasesUIState(
                isLoading = false,
                releases = persistentListOf()
            )
        }
    }
}
