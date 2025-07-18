package and.degilevich.dream.shared.feature.album.model.core.impl.mapper

import and.degilevich.dream.shared.core.service.api.requests.getNewReleases.NewReleasesAlbumsOutput
import and.degilevich.dream.shared.feature.album.model.artifact.api.mapper.AlbumSimplifiedOutputToDataMapper
import and.degilevich.dream.shared.feature.album.model.core.api.data.NewReleasesAlbumsData
import and.degilevich.dream.shared.feature.album.model.core.api.mapper.NewReleasesAlbumsOutputToDataMapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith
import and.degilevich.dream.shared.foundation.primitive.primitives.number.int.orZero
import kotlin.collections.orEmpty

internal class NewReleasesAlbumsOutputToDataMapperImpl(
    private val albumSimplifiedOutputToDataMapper: AlbumSimplifiedOutputToDataMapper
) : NewReleasesAlbumsOutputToDataMapper {
    override fun map(item: NewReleasesAlbumsOutput): NewReleasesAlbumsData {
        return with(item) {
            NewReleasesAlbumsData(
                total = total.orZero(),
                albums = items?.mapWith(albumSimplifiedOutputToDataMapper).orEmpty()
            )
        }
    }
}