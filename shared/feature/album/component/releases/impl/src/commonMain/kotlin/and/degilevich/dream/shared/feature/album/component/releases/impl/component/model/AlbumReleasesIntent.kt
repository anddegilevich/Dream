package and.degilevich.dream.shared.feature.album.component.releases.impl.component.model

import and.degilevich.dream.shared.foundation.abstraction.id.Identifier

sealed interface AlbumReleasesIntent {
    data class OnAlbumClicked(val id: Identifier) : AlbumReleasesIntent
}