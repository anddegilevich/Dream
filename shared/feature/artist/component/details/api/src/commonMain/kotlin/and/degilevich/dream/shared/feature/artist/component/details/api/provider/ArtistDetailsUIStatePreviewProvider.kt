package and.degilevich.dream.shared.feature.artist.component.details.api.provider

import and.degilevich.dream.shared.feature.album.design.api.provider.AlbumCardUIDataPreviewProvider
import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistDetailsUIState
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.Skeleton
import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class ArtistDetailsUIStatePreviewProvider : PreviewParameterProvider<ArtistDetailsUIState> {

    override val values: Sequence<ArtistDetailsUIState> = sequenceOf(
        provideSkeleton(),
        provide()
    )

    fun provideSkeleton(): ArtistDetailsUIState {
        return ArtistDetailsUIState.empty()
    }

    fun provide(): ArtistDetailsUIState {
        return ArtistDetailsUIState(
            info = Skeleton.Value(ArtistInfoLayoutUIDataPreviewProvider().provide()),
            albums = Skeleton.Value(AlbumCardUIDataPreviewProvider().provideList())
        )
    }
}