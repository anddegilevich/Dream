package and.degilevich.dream.shared.feature.artist.component.details.impl.component

import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistDetailsUIState
import and.degilevich.dream.shared.feature.artist.component.details.impl.store.model.ArtistDetailsState
import and.degilevich.dream.shared.feature.artist.compose.mapper.ArtistUIItemMapper
import and.degilevich.dream.shared.foundation.model.mapper.Mapper
import kotlinx.collections.immutable.toImmutableList

internal class ArtistDetailsUIStateMapper : Mapper<ArtistDetailsState, ArtistDetailsUIState> {

    private val artistUIItemMapper = ArtistUIItemMapper()

    override fun map(item: ArtistDetailsState): ArtistDetailsUIState {
        return with(item) {
            ArtistDetailsUIState(
                artistName = artist.name,
                similarArtists = artistUIItemMapper.map(similarArtists).toImmutableList()
            )
        }
    }
}