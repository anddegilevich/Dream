package and.degilevich.dream.shared.feature.artist.core.api.source.model.request.getArtists

import and.degilevich.dream.shared.feature.artist.model.core.ArtistData
import and.degilevich.dream.shared.foundation.model.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.model.empty.state.EmptyState

data class GetArtistsResult(
    val artists: List<ArtistData>
) : EmptyState {
    override fun isEmpty(): Boolean {
        return artists.isEmpty()
    }

    companion object : EmptyFactory<GetArtistsResult> {
        override fun empty(): GetArtistsResult {
            return GetArtistsResult(
                artists = emptyList()
            )
        }
    }
}