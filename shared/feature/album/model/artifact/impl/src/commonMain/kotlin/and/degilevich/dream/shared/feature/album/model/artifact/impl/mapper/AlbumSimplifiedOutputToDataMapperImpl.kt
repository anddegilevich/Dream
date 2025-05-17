package and.degilevich.dream.shared.feature.album.model.artifact.impl.mapper

import and.degilevich.dream.shared.core.service.api.model.album.AlbumSimplifiedOutput
import and.degilevich.dream.shared.feature.album.model.artifact.api.data.AlbumSimplifiedData
import and.degilevich.dream.shared.feature.album.model.artifact.api.dictionary.AlbumType
import and.degilevich.dream.shared.feature.album.model.artifact.api.mapper.AlbumSimplifiedOutputToDataMapper
import and.degilevich.dream.shared.feature.artist.model.artifact.api.mapper.ArtistSimplifiedOutputToDataMapper
import and.degilevich.dream.shared.feature.image.model.artifact.api.mapper.ImageObjectOutputToDataMapper
import and.degilevich.dream.shared.foundation.abstraction.id.ext.getEnumValueByIdOrElse
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith
import and.degilevich.dream.shared.foundation.primitive.primitives.number.int.orZero
import kotlin.collections.orEmpty

internal class AlbumSimplifiedOutputToDataMapperImpl(
    private val artistSimplifiedOutputToDataMapper: ArtistSimplifiedOutputToDataMapper,
    private val imageObjectOutputToDataMapper: ImageObjectOutputToDataMapper,
) : AlbumSimplifiedOutputToDataMapper {
    override fun map(item: AlbumSimplifiedOutput): AlbumSimplifiedData {
        return with(item) {
            AlbumSimplifiedData(
                id = id.orEmpty(),
                name = name.orEmpty(),
                albumType = getEnumValueByIdOrElse(albumType) { AlbumType.UNKNOWN },
                totalTracks = totalTracks.orZero(),
                releaseDate = releaseDate.orEmpty(),
                artists = artists?.mapWith(artistSimplifiedOutputToDataMapper).orEmpty(),
                images = images?.mapWith(imageObjectOutputToDataMapper).orEmpty()
            )
        }
    }
}