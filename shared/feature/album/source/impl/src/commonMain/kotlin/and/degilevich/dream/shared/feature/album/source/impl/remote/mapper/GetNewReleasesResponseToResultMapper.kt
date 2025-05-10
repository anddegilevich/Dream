package and.degilevich.dream.shared.feature.album.source.impl.remote.mapper

import and.degilevich.dream.shared.core.service.api.requests.getNewReleases.GetNewReleasesResponse
import and.degilevich.dream.shared.feature.album.model.artifact.api.mapper.AlbumOutputToDataMapper
import and.degilevich.dream.shared.feature.album.source.api.remote.request.getNewReleases.GetNewReleasesResult
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith
import and.degilevich.dream.shared.foundation.primitive.primitives.number.int.orZero

internal class GetNewReleasesResponseToResultMapper(
    private val albumOutputToDataMapper: AlbumOutputToDataMapper
) : Mapper<GetNewReleasesResponse, GetNewReleasesResult> {
    override fun map(item: GetNewReleasesResponse): GetNewReleasesResult {
        return with(item) {
            GetNewReleasesResult(
                total = total.orZero(),
                albums = items?.mapWith(albumOutputToDataMapper).orEmpty()
            )
        }
    }
}