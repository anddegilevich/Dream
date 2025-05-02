package and.degilevich.dream.shared.feature.artist.core.impl.source.remote

import and.degilevich.dream.shared.template.source.remote.RemoteDataSourceTemplate
import and.degilevich.dream.shared.feature.artist.core.api.source.model.request.getArtist.GetArtistParams
import and.degilevich.dream.shared.feature.artist.core.api.source.model.request.getArtist.GetArtistResult
import and.degilevich.dream.shared.feature.artist.core.api.source.model.request.getArtists.GetArtistsParams
import and.degilevich.dream.shared.feature.artist.core.api.source.model.request.getArtists.GetArtistsResult
import and.degilevich.dream.shared.feature.artist.core.api.source.remote.ArtistRemoteDataSource
import and.degilevich.dream.shared.feature.artist.core.impl.source.remote.mappers.mapToResult
import and.degilevich.dream.shared.feature.artist.core.impl.source.remote.mappers.mapToRequest
import and.degilevich.dream.shared.foundation.primitive.result.foldResultSuccess

internal class ArtistRemoteDataSourceImpl : ArtistRemoteDataSource, RemoteDataSourceTemplate() {
    override suspend fun getArtist(params: GetArtistParams): Result<GetArtistResult> {
        return service.getArtist(params.mapToRequest()).foldResultSuccess { response ->
            response.mapToResult()
        }
    }

    override suspend fun getArtists(params: GetArtistsParams): Result<GetArtistsResult> {
        return service.getArtists(params.mapToRequest()).foldResultSuccess { response ->
            response.mapToResult()
        }
    }
}