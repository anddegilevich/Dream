package and.degilevich.dream.shared.feature.artist.component.details.api.preview.provider

import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistDetailsUIState
import and.degilevich.dream.shared.feature.artist.design.api.model.ArtistCardUIData
import and.degilevich.dream.shared.foundation.primitive.collections.persistentList.buildPersistentList

@Suppress("MagicNumber")
object ArtistDetailsUIStatePreviewProvider {

    fun provide(): ArtistDetailsUIState {
        return ArtistDetailsUIState(
            artistName = "Artist name: Name",
            artistIconUrl = "",
            similarArtists = buildPersistentList {
                for (i in 1..10) {
                    add(
                        ArtistCardUIData.empty().copy(
                            id = i.toString(),
                            name = "Artist $i"
                        )
                    )
                }
            }
        )
    }
}