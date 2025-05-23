package and.degilevich.dream.shared.feature.artist.component.list.impl.component

import and.degilevich.dream.shared.resource.api.ResourceManager
import and.degilevich.dream.shared.feature.artist.component.list.api.component.model.ArtistListUIState
import and.degilevich.dream.shared.feature.artist.component.list.impl.store.model.ArtistListState
import and.degilevich.dream.Res
import and.degilevich.dream.shared.feature.artist.design.api.mapper.ArtistDataToCardUIDataMapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper
import kotlinx.collections.immutable.toImmutableList
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class ArtistListUIStateMapper : Mapper<ArtistListState, ArtistListUIState>, KoinComponent {

    private val artistDataToCardUIDataMapper: ArtistDataToCardUIDataMapper by inject()
    private val resourceManager: ResourceManager by inject()

    override fun map(item: ArtistListState): ArtistListUIState {
        return with(item) {
            ArtistListUIState(
                artistCount = resourceManager.getString(Res.plurals.plural_artist, artists.count()),
                artists = artists
                    .map { artist ->
                        artistDataToCardUIDataMapper.map(
                            artist = artist,
                            isEnabled = !isLoading
                        )
                    }
                    .toImmutableList()
            )
        }
    }
}