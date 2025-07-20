package and.degilevich.dream.shared.feature.album.component.details.api.preview.provider

import and.degilevich.dream.shared.feature.album.component.details.api.component.model.AlbumDetailsUIState
import and.degilevich.dream.shared.feature.artist.design.api.preview.provider.ArtistLabelUIDataPreviewProvider
import and.degilevich.dream.shated.feature.track.design.api.preview.provider.TrackCardUIDataPreviewProvider

object AlbumDetailsUIStatePreviewProvider {
    fun provide(): AlbumDetailsUIState {
        return AlbumDetailsUIState(
            name = "Album",
            iconUrl = "",
            artists = ArtistLabelUIDataPreviewProvider.provideList(),
            type = "Albumn",
            year = "2000",
            tracks = TrackCardUIDataPreviewProvider.provideList()
        )
    }
}