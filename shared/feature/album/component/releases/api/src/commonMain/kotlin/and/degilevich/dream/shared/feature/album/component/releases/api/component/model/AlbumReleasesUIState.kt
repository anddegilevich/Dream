package and.degilevich.dream.shared.feature.album.component.releases.api.component.model

import and.degilevich.dream.shared.feature.album.design.api.model.AlbumCardUIData
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.Skeleton
import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList

@Immutable
data class AlbumReleasesUIState(
    val releases: Skeleton<ImmutableList<AlbumCardUIData>>
) {
    companion object : EmptyFactory<AlbumReleasesUIState> {
        override fun empty(): AlbumReleasesUIState {
            return AlbumReleasesUIState(
                releases = Skeleton.Loading
            )
        }
    }
}
