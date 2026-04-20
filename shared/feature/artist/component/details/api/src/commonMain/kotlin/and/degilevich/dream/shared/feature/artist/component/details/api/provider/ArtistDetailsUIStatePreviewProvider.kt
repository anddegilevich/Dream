package and.degilevich.dream.shared.feature.artist.component.details.api.provider

import and.degilevich.dream.shared.feature.album.design.api.provider.AlbumCardUIDataPreviewProvider
import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistDetailsUIState
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.Skeleton
import and.degilevich.dream.shared.foundation.compose.preview.LabeledPreviewParameterProvider

class ArtistDetailsUIStatePreviewProvider : LabeledPreviewParameterProvider<ArtistDetailsUIState>() {

    override val labeledValues = listOf(
        "Skeleton" to provideSkeleton(),
        "Default" to provideDefault()
    )

    fun provideSkeleton(): ArtistDetailsUIState {
        return ArtistDetailsUIState.empty()
    }

    fun provideDefault(): ArtistDetailsUIState {
        return ArtistDetailsUIState(
            info = Skeleton.Value(ArtistInfoLayoutUIDataPreviewProvider().provide()),
            albums = Skeleton.Value(AlbumCardUIDataPreviewProvider().provideList())
        )
    }
}