package and.degilevich.dream.shared.feature.artist.component.list.impl.component

import and.degilevich.dream.shared.feature.artist.component.list.api.component.ArtistListUIState
import and.degilevich.dream.shared.feature.artist.component.list.impl.store.model.ArtistListState
import and.degilevich.dream.shared.feature.artist.compose.model.ArtistUIItem
import and.degilevich.dream.shared.feature.artist.model.core.ArtistData
import and.degilevich.dream.shared.foundation.model.mapper.Mapper
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

internal class ArtistListUIStateMapper : Mapper<ArtistListState, ArtistListUIState> {
    override fun map(item: ArtistListState): ArtistListUIState {
        return ArtistListUIState(
            artists = mapToArtistsUIItems(item)
        )
    }

    private fun mapToArtistsUIItems(state: ArtistListState): ImmutableList<ArtistUIItem> {
        return state.artists.map { artist ->
            mapToArtistUIItem(artist)
        }.toImmutableList()
    }

    private fun mapToArtistUIItem(artist: ArtistData): ArtistUIItem {
        return with(artist) {
            ArtistUIItem(
                id = id,
                name = name
            )
        }
    }
}