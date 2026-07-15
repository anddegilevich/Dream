package and.degilevich.dream.shared.feature.artist.component.details.impl.component.model

import and.degilevich.dream.shared.feature.album.ui.api.model.AlbumCardUIData
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.Skeleton
import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList

@Immutable
data class ArtistDetailsUIState(
    val info: Skeleton<ArtistInfoLayoutUIData>,
    val albums: Skeleton<ImmutableList<AlbumCardUIData>>
) {
    companion object : EmptyFactory<ArtistDetailsUIState> {
        override fun empty(): ArtistDetailsUIState {
            return ArtistDetailsUIState(
                info = Skeleton.Loading,
                albums = Skeleton.Loading
            )
        }
    }
}
