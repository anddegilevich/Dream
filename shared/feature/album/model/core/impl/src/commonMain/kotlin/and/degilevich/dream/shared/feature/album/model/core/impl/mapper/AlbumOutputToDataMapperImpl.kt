package and.degilevich.dream.shared.feature.album.model.core.impl.mapper

import and.degilevich.dream.shared.core.service.api.model.data.album.AlbumOutput
import and.degilevich.dream.shared.feature.album.model.artifact.api.dictionary.AlbumType
import and.degilevich.dream.shared.feature.album.model.core.api.data.AlbumData
import and.degilevich.dream.shared.feature.album.model.core.api.data.AlbumTracksData
import and.degilevich.dream.shared.feature.album.model.core.api.mapper.AlbumOutputToDataMapper
import and.degilevich.dream.shared.feature.album.model.core.api.mapper.AlbumTracksOutputToDataMapper
import and.degilevich.dream.shared.feature.artist.model.artifact.api.mapper.ArtistSimplifiedOutputToDataMapper
import and.degilevich.dream.shared.feature.image.model.artifact.api.mapper.ImageObjectOutputToDataMapper
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.ext.orEmpty
import and.degilevich.dream.shared.foundation.abstraction.id.ext.getEnumValueByIdOrElse
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith
import and.degilevich.dream.shared.foundation.primitive.primitives.number.int.orZero

internal class AlbumOutputToDataMapperImpl(
    private val artistSimplifiedOutputToDataMapper: ArtistSimplifiedOutputToDataMapper,
    private val imageObjectOutputToDataMapper: ImageObjectOutputToDataMapper,
    private val albumTracksOutputToDataMapper: AlbumTracksOutputToDataMapper,
) : AlbumOutputToDataMapper {
    override fun map(item: AlbumOutput): AlbumData {
        return with(item) {
            AlbumData(
                id = id.orEmpty(),
                name = name.orEmpty(),
                albumType = getEnumValueByIdOrElse(albumType) { AlbumType.UNKNOWN },
                totalTracks = totalTracks.orZero(),
                releaseDate = releaseDate.orEmpty(),
                artists = artists?.mapWith(artistSimplifiedOutputToDataMapper).orEmpty(),
                images = images?.mapWith(imageObjectOutputToDataMapper).orEmpty(),
                tracks = tracks?.mapWith(albumTracksOutputToDataMapper).orEmpty(AlbumTracksData),
                label = label.orEmpty(),
                popularity = popularity.orZero()
            )
        }
    }
}