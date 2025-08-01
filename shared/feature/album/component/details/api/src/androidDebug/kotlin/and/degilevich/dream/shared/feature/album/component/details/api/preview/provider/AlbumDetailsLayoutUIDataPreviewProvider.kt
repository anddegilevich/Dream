package and.degilevich.dream.shared.feature.album.component.details.api.preview.provider

import and.degilevich.dream.shared.feature.album.component.details.api.component.model.AlbumDetailsLayoutUIData

object AlbumDetailsLayoutUIDataPreviewProvider {
    fun provide(): AlbumDetailsLayoutUIData {
        return AlbumDetailsLayoutUIData.empty().copy(
            name = "Album",
            type = "Album",
            year = "2000",
        )
    }
}