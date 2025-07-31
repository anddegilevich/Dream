package and.degilevich.dream.shared.feature.search.design.api.preview.provider

import and.degilevich.dream.shared.feature.search.design.api.model.card.AlbumSearchCardUIData
import and.degilevich.dream.shared.feature.search.design.api.model.card.ArtistSearchCardUIData
import and.degilevich.dream.shared.feature.search.design.api.model.card.SearchCardUIData
import and.degilevich.dream.shared.feature.search.design.api.model.card.TrackSearchCardUIData
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

object SearchCardUIDataPreviewProvider {
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
                id = "1",
                name = "Artist"
            ),
            AlbumSearchCardUIData.empty().copy(
                id = "2",
                name = "Album",
                artistName = "Artist"
            ),
            TrackSearchCardUIData.empty().copy(
                id = "3",
                name = "Track",
                artistName = "Artist"
            )
        )
    }
}