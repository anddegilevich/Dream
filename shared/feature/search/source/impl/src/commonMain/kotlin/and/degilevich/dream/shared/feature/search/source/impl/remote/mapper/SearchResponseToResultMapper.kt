package and.degilevich.dream.shared.feature.search.source.impl.remote.mapper

import and.degilevich.dream.shared.core.service.api.requests.search.SearchResponse
import and.degilevich.dream.shared.feature.album.model.artifact.api.mapper.AlbumOutputToDataMapper
import and.degilevich.dream.shared.feature.artist.model.core.api.mapper.ArtistOutputToDataMapper
import and.degilevich.dream.shared.feature.search.source.api.remote.request.search.SearchResult
import and.degilevich.dream.shared.feature.track.model.core.api.mapper.TrackOutputToDataMapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith

internal class SearchResponseToResultMapper(
    private val trackOutputToDataMapper: TrackOutputToDataMapper,
    private val artistOutputToDataMapper: ArtistOutputToDataMapper,
    private val albumOutputToDataMapper: AlbumOutputToDataMapper
) : Mapper<SearchResponse, SearchResult> {
    override fun map(item: SearchResponse): SearchResult {
        return with(item) {
            SearchResult(
                tracks = tracks?.mapWith(trackOutputToDataMapper).orEmpty(),
                artists = artists?.mapWith(artistOutputToDataMapper).orEmpty(),
                albums = albums?.mapWith(albumOutputToDataMapper).orEmpty()
            )
        }
    }
}