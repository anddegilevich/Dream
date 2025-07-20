package and.degilevich.dream.shared.feature.album.component.details.api.preview.provider

import and.degilevich.dream.shared.feature.album.component.details.api.component.model.AlbumDetailsUIState
import and.degilevich.dream.shared.feature.artist.design.api.preview.provider.ArtistLabelUIDataPreviewProvider

object AlbumDetailsUIStatePreviewProvider {
    fun provide(): AlbumDetailsUIState {
        return AlbumDetailsUIState(
            name = "Album",
            iconUrl = "",
            artists = ArtistLabelUIDataPreviewProvider.provideList(),
            type = "Albumn",
            year = "2000"
        )
    }
}