package and.degilevich.dream.shared.feature.search.component.search.impl.component

import and.degilevich.dream.shared.feature.search.component.search.api.component.model.SearchUIState
import and.degilevich.dream.shared.feature.search.component.search.impl.store.model.SearchState
import and.degilevich.dream.shared.feature.search.design.api.mapper.AlbumInfoToSearchCardUIDataMapper
import and.degilevich.dream.shared.feature.search.design.api.mapper.ArtistDataToSearchCardUIDataMapper
import and.degilevich.dream.shared.feature.search.design.api.mapper.TrackDataToSearchCardUIDataMapper
import and.degilevich.dream.shared.feature.search.design.api.model.card.SearchCardUIData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import kotlin.getValue
import kotlin.random.Random

internal class SearchUIStateMapper : Mapper<SearchState, SearchUIState>, KoinComponent {

    private val artistDataToSearchCardUIDataMapper: ArtistDataToSearchCardUIDataMapper by inject()
    private val albumDataToSearchCardUIDataMapper: AlbumInfoToSearchCardUIDataMapper by inject()
    private val trackDataToSearchCardUIDataMapper: TrackDataToSearchCardUIDataMapper by inject()

    override fun map(item: SearchState): SearchUIState {
        return with(item) {
            SearchUIState(
                query = query,
                items = mapToItems(state = item)
            )
        }
    }

    private fun mapToItems(state: SearchState): ImmutableList<SearchCardUIData> {
        return with(state.searchResult) {
            listOf(
                albums.items.mapWith(albumDataToSearchCardUIDataMapper),
                artists.items.mapWith(artistDataToSearchCardUIDataMapper),
                tracks.items.mapWith(trackDataToSearchCardUIDataMapper)
            )
                .flatten()
                .shuffled(random = Random(0)) // FIXME: Sort more deliberately
                .toImmutableList()
        }
    }
}