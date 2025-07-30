package and.degilevich.dream.shared.feature.album.model.core.impl.mapper

import and.degilevich.dream.shared.core.service.api.model.method.getNewReleases.GetNewReleasesResponse
import and.degilevich.dream.shared.feature.album.model.core.api.method.getNewReleases.GetNewReleasesResult
import and.degilevich.dream.shared.feature.album.model.core.api.data.NewReleasesAlbumsData
import and.degilevich.dream.shared.feature.album.model.core.api.mapper.GetNewReleasesResponseToResultMapper
import and.degilevich.dream.shared.feature.album.model.core.api.mapper.NewReleasesAlbumsOutputToDataMapper
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.ext.orEmpty
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith

internal class GetNewReleasesResponseToResultMapperImpl(
    private val newReleasesAlbumsOutputToDataMapper: NewReleasesAlbumsOutputToDataMapper
) : GetNewReleasesResponseToResultMapper {
    override fun map(item: GetNewReleasesResponse): GetNewReleasesResult {
        return with(item) {
            GetNewReleasesResult(
                albums = albums?.mapWith(newReleasesAlbumsOutputToDataMapper).orEmpty(NewReleasesAlbumsData)
            )
        }
    }
}