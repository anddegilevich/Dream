package and.degilevich.dream.shared.feature.album.component.releases.api.preview.provider

import and.degilevich.dream.shared.feature.album.component.releases.api.component.model.AlbumReleasesUIState
import and.degilevich.dream.shared.feature.album.design.api.model.AlbumCardUIData
import and.degilevich.dream.shared.foundation.primitive.collections.persistentList.buildPersistentList

@Suppress("MagicNumber")
object AlbumReleasesUIStatePreviewProvider {

    fun provide(): AlbumReleasesUIState {
        return AlbumReleasesUIState(
            isLoading = false,
            releases = buildPersistentList {
                for (i in 1..10) {
                    add(
                        AlbumCardUIData.Companion.empty().copy(
                            id = i.toString(),
                            name = "Album $i",
                            artists = "Artist $i"
                        )
                    )
                }
            }
        )
    }
}