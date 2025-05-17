package and.degilevich.dream.shared.feature.album.source.impl.remote.mapper

import and.degilevich.dream.shared.core.service.api.requests.getNewReleases.GetNewReleasesResponse
import and.degilevich.dream.shared.feature.album.source.api.remote.request.getNewReleases.GetNewReleasesResult
import and.degilevich.dream.shared.feature.album.source.api.remote.request.getNewReleases.NewReleasesAlbumsData
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.ext.orEmpty
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith

internal class GetNewReleasesResponseToResultMapper(
    private val newReleasesAlbumsOutputToDataMapper: NewReleasesAlbumsOutputToDataMapper
) : Mapper<GetNewReleasesResponse, GetNewReleasesResult> {
    override fun map(item: GetNewReleasesResponse): GetNewReleasesResult {
        return with(item) {
            GetNewReleasesResult(
                albums = albums?.mapWith(newReleasesAlbumsOutputToDataMapper).orEmpty(NewReleasesAlbumsData)
            )
        }
    }
}