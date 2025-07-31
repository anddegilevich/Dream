package and.degilevich.dream.shared.feature.search.model.core.api.method.search

import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import kotlinx.serialization.Serializable

@Serializable
data class SearchArtistsData(
    val items: List<ArtistData>
) {
    companion object : EmptyFactory<SearchArtistsData> {
        override fun empty(): SearchArtistsData {
            return SearchArtistsData(
                items = emptyList()
            )
        }
    }
}
