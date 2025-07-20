package and.degilevich.dream.shared.feature.album.component.details.api.preview.provider

import and.degilevich.dream.shared.feature.album.component.details.api.component.model.AlbumDetailsUIState

object AlbumDetailsUIStatePreviewProvider {
    fun provide(): AlbumDetailsUIState {
        return AlbumDetailsUIState(
            name = "Album",
            iconUrl = ""
        )
    }
}