package and.degilevich.dream.shared.feature.search.model.core.api.method.search

import and.degilevich.dream.shared.feature.album.model.artifact.api.data.AlbumSimplifiedData
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.abstraction.empty.state.EmptyState
import kotlinx.serialization.Serializable

@Serializable
data class SearchAlbumsData(
    val items: List<AlbumSimplifiedData>
) : EmptyState {

    override fun isEmpty(): Boolean {
        return items.isEmpty()
    }

    companion object : EmptyFactory<SearchAlbumsData> {
        override fun empty(): SearchAlbumsData {
            return SearchAlbumsData(
                items = emptyList()
            )
        }
    }
}
