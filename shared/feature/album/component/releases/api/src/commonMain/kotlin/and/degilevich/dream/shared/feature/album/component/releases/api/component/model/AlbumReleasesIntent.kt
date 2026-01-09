package and.degilevich.dream.shared.feature.album.component.releases.api.component.model

import and.degilevich.dream.shared.foundation.abstraction.id.Identifier

sealed interface AlbumReleasesIntent {
    data class OnAlbumClicked(val id: Identifier) : AlbumReleasesIntent
}