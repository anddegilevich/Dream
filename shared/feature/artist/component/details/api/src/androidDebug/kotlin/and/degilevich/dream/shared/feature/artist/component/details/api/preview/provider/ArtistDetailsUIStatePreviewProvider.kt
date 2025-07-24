package and.degilevich.dream.shared.feature.artist.component.details.api.preview.provider

import and.degilevich.dream.shared.feature.album.design.api.preview.provider.AlbumCardUIDataPreviewProvider
import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistDetailsUIState
import and.degilevich.dream.shated.feature.track.design.api.preview.provider.TrackCardUIDataPreviewProvider

object ArtistDetailsUIStatePreviewProvider {

    fun provide(): ArtistDetailsUIState {
        return ArtistDetailsUIState(
            name = "Artist",
            iconUrl = "",
            topTracks = TrackCardUIDataPreviewProvider.provideList(),
            albums = AlbumCardUIDataPreviewProvider.provideList()
        )
    }
}