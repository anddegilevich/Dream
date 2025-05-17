package and.degilevich.dream.shared.feature.album.component.releases.api.component.model

sealed interface AlbumReleasesIntent {
    data class OnAlbumClicked(
        val id: String
    ) : AlbumReleasesIntent
}