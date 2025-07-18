package and.degilevich.dream.shared.feature.search.model.core.impl.mapper

import and.degilevich.dream.shared.core.service.api.requests.search.SearchResponse
import and.degilevich.dream.shared.feature.album.model.artifact.api.mapper.AlbumSimplifiedOutputToDataMapper
import and.degilevich.dream.shared.feature.artist.model.core.api.mapper.ArtistOutputToDataMapper
import and.degilevich.dream.shared.feature.search.model.core.api.mapper.SearchResponseToResultMapper
import and.degilevich.dream.shared.feature.search.model.core.api.request.search.SearchResult
import and.degilevich.dream.shared.feature.track.model.core.api.mapper.TrackOutputToDataMapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith
import kotlin.collections.orEmpty

internal class SearchResponseToResultMapperImpl(
    private val trackOutputToDataMapper: TrackOutputToDataMapper,
    private val artistOutputToDataMapper: ArtistOutputToDataMapper,
    private val albumSimplifiedOutputToDataMapper: AlbumSimplifiedOutputToDataMapper
) : SearchResponseToResultMapper {
    override fun map(item: SearchResponse): SearchResult {
        return with(item) {
            SearchResult(
                tracks = tracks?.mapWith(trackOutputToDataMapper).orEmpty(),
                artists = artists?.mapWith(artistOutputToDataMapper).orEmpty(),
                albums = albums?.mapWith(albumSimplifiedOutputToDataMapper).orEmpty()
            )
        }
    }
}