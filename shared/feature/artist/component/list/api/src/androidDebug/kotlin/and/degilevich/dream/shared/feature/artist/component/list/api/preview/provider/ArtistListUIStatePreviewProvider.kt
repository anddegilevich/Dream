package and.degilevich.dream.shared.feature.artist.component.list.api.preview.provider

import and.degilevich.dream.shared.feature.artist.component.list.api.component.model.ArtistListUIState
import and.degilevich.dream.shared.feature.artist.design.api.model.ArtistCardUIData
import kotlinx.collections.immutable.toImmutableList

@Suppress("MagicNumber")
object ArtistListUIStatePreviewProvider {
    fun provide(): ArtistListUIState {
        return ArtistListUIState(
            artistCount = "10 Artists",
            artists = buildList {
                for (i in 1..10) {
                    add(
                        ArtistCardUIData.empty().copy(
                            id = i.toString(),
                            name = "Artist $i"
                        )
                    )
                }
            }.toImmutableList()
        )
    }
}