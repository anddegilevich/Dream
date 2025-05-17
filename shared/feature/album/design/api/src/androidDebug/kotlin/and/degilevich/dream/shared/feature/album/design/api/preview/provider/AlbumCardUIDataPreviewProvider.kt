package and.degilevich.dream.shared.feature.album.design.api.preview.provider

import and.degilevich.dream.shared.feature.album.design.api.model.AlbumCardUIData

object AlbumCardUIDataPreviewProvider {

    fun provide(): AlbumCardUIData {
        return AlbumCardUIData.empty().copy(
            name = "Album",
            artists = "Artist"
        )
    }
}