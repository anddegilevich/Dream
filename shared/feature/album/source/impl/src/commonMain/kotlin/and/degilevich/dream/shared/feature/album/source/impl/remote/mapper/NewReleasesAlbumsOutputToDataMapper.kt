package and.degilevich.dream.shared.feature.album.source.impl.remote.mapper

import and.degilevich.dream.shared.core.service.api.requests.getNewReleases.NewReleasesAlbumsOutput
import and.degilevich.dream.shared.feature.album.model.artifact.api.mapper.AlbumSimplifiedOutputToDataMapper
import and.degilevich.dream.shared.feature.album.source.api.remote.request.getNewReleases.NewReleasesAlbumsData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith
import and.degilevich.dream.shared.foundation.primitive.primitives.number.int.orZero
import kotlin.collections.orEmpty

internal class NewReleasesAlbumsOutputToDataMapper(
    private val albumSimplifiedOutputToDataMapper: AlbumSimplifiedOutputToDataMapper
) : Mapper<NewReleasesAlbumsOutput, NewReleasesAlbumsData> {
    override fun map(item: NewReleasesAlbumsOutput): NewReleasesAlbumsData {
        return with(item) {
            NewReleasesAlbumsData(
                total = total.orZero(),
                albums = items?.mapWith(albumSimplifiedOutputToDataMapper).orEmpty()
            )
        }
    }
}