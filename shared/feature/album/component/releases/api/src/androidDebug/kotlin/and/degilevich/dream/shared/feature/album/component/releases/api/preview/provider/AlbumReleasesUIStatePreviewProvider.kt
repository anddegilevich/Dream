package and.degilevich.dream.shared.feature.album.component.releases.api.preview.provider

import and.degilevich.dream.shared.feature.album.component.releases.api.component.model.AlbumReleasesUIState
import and.degilevich.dream.shared.feature.album.design.api.model.AlbumCardUIData
import kotlinx.collections.immutable.toImmutableList

@Suppress("MagicNumber")
object AlbumReleasesUIStatePreviewProvider {

    fun provide(): AlbumReleasesUIState {
        return AlbumReleasesUIState(
            isLoading = false,
            releases = buildList {
                for (i in 1..10) {
                    add(
                        AlbumCardUIData.Companion.empty().copy(
                            id = i.toString(),
                            name = "Album $i",
                            artists = "Artist $i"
                        )
                    )
                }
            }.toImmutableList()
        )
    }
}