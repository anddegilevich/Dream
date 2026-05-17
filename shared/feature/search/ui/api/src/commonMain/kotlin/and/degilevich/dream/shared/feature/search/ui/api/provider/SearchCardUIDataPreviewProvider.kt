package and.degilevich.dream.shared.feature.search.ui.api.provider

import and.degilevich.dream.shared.feature.search.ui.api.model.card.AlbumSearchCardUIData
import and.degilevich.dream.shared.feature.search.ui.api.model.card.ArtistSearchCardUIData
import and.degilevich.dream.shared.feature.search.ui.api.model.card.SearchCardUIData
import and.degilevich.dream.shared.feature.search.ui.api.model.card.TrackSearchCardUIData
import and.degilevich.dream.shared.foundation.abstraction.id.identifier
import and.degilevich.dream.shared.foundation.compose.preview.LabeledPreviewParameterProvider
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

class SearchCardUIDataPreviewProvider : LabeledPreviewParameterProvider<SearchCardUIData>() {

    override val labeledValues = listOf(
        "Track" to provideTrack(),
        "Artist" to provideArtist(),
        "Album" to provideAlbum()
    )

    fun provideArtist(): ArtistSearchCardUIData {
        return ArtistSearchCardUIData.empty().copy(
            name = "Artist"
        )
    }

    fun provideAlbum(): AlbumSearchCardUIData {
        return AlbumSearchCardUIData.empty().copy(
            name = "Album",
            artistName = "Artist"
        )
    }

    fun provideTrack(): TrackSearchCardUIData {
        return TrackSearchCardUIData.empty().copy(
            name = "Track",
            artistName = "Artist"
        )
    }

    fun provideList(): ImmutableList<SearchCardUIData> {
        return persistentListOf(
            ArtistSearchCardUIData.empty().copy(
                id = identifier(value = "1"),
                name = "Artist"
            ),
            AlbumSearchCardUIData.empty().copy(
                id = identifier(value = "2"),
                name = "Album",
                artistName = "Artist"
            ),
            TrackSearchCardUIData.empty().copy(
                id = identifier(value = "3"),
                name = "Track",
                artistName = "Artist"
            )
        )
    }
}