package and.degilevich.dream.shared.feature.album.source.impl.remote.mapper

import and.degilevich.dream.shared.core.service.api.model.data.album.AlbumSimplifiedOutput
import and.degilevich.dream.shared.feature.album.model.artifact.api.data.AlbumSimplifiedData
import and.degilevich.dream.shared.feature.album.model.artifact.api.dictionary.AlbumType
import and.degilevich.dream.shared.feature.album.source.api.remote.mapper.AlbumSimplifiedOutputToDataMapper
import and.degilevich.dream.shared.feature.artist.source.api.remote.mapper.ArtistSimplifiedOutputToDataMapper
import and.degilevich.dream.shared.feature.image.source.api.remote.mapper.ImageObjectOutputToDataMapper
import and.degilevich.dream.shared.foundation.abstraction.id.ext.asId
import and.degilevich.dream.shared.foundation.abstraction.id.ext.getEnumValueByIdOrElse
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith
import and.degilevich.dream.shared.foundation.primitive.primitives.number.int.orZero

internal class AlbumSimplifiedOutputToDataMapperImpl(
    private val artistSimplifiedOutputToDataMapper: ArtistSimplifiedOutputToDataMapper,
    private val imageObjectOutputToDataMapper: ImageObjectOutputToDataMapper,
) : AlbumSimplifiedOutputToDataMapper {

    override fun map(item: AlbumSimplifiedOutput): AlbumSimplifiedData {
        return with(item) {
            AlbumSimplifiedData(
                id = id.asId(),
                name = name.orEmpty(),
                albumType = getEnumValueByIdOrElse(
                    id = albumType.asId()
                ) { AlbumType.UNKNOWN },
                totalTracks = totalTracks.orZero(),
                releaseDate = releaseDate.orEmpty(),
                artists = artists?.mapWith(artistSimplifiedOutputToDataMapper).orEmpty(),
                images = images?.mapWith(imageObjectOutputToDataMapper).orEmpty()
            )
        }
    }
}