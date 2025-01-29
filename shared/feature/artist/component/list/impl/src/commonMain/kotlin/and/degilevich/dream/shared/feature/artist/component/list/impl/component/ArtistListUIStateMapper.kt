package and.degilevich.dream.shared.feature.artist.component.list.impl.component

import and.degilevich.dream.shared.feature.artist.component.list.api.component.model.ArtistListUIState
import and.degilevich.dream.shared.feature.artist.component.list.impl.store.model.ArtistListState
import and.degilevich.dream.shared.feature.artist.compose.mapper.ArtistUIItemMapper
import and.degilevich.dream.shared.foundation.model.mapper.Mapper
import kotlinx.collections.immutable.toImmutableList

internal class ArtistListUIStateMapper : Mapper<ArtistListState, ArtistListUIState> {

    private val artistUIItemMapper = ArtistUIItemMapper()

    override fun map(item: ArtistListState): ArtistListUIState {
        return ArtistListUIState(
            artists = artistUIItemMapper.map(item.artists).toImmutableList()
        )
    }
}