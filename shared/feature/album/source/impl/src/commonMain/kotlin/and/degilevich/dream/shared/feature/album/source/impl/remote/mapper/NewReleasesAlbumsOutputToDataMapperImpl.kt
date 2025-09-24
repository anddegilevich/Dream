package and.degilevich.dream.shared.feature.album.source.impl.remote.mapper

import and.degilevich.dream.shared.core.service.api.model.method.getNewReleases.NewReleasesAlbumsOutput
import and.degilevich.dream.shared.feature.album.source.api.remote.mapper.AlbumSimplifiedOutputToDataMapper
import and.degilevich.dream.shared.feature.album.model.core.api.data.NewReleasesAlbumsData
import and.degilevich.dream.shared.feature.album.source.api.remote.mapper.NewReleasesAlbumsOutputToDataMapper
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