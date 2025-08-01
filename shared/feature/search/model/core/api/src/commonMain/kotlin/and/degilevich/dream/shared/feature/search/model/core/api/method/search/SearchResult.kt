package and.degilevich.dream.shared.feature.search.model.core.api.method.search

import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.abstraction.empty.state.EmptyState
import kotlinx.serialization.Serializable

@Serializable
data class SearchResult(
    val tracks: SearchTracksData,
    val artists: SearchArtistsData,
    val albums: SearchAlbumsData,
) : EmptyState {

    override fun isEmpty(): Boolean {
        return sequence {
            yield(tracks.isEmpty())
            yield(artists.isEmpty())
            yield(albums.isEmpty())
        }.all { it }
    }

    companion object : EmptyFactory<SearchResult> {
        override fun empty(): SearchResult {
            return SearchResult(
                tracks = SearchTracksData.empty(),
                artists = SearchArtistsData.empty(),
                albums = SearchAlbumsData.empty()
            )
        }
    }
}