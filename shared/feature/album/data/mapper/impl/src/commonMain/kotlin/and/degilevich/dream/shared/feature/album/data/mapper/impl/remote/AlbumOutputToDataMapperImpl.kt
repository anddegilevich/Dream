package and.degilevich.dream.shared.feature.album.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.api.generated.model.AlbumObject
import and.degilevich.dream.shared.feature.album.data.mapper.api.remote.AlbumOutputToDataMapper
import and.degilevich.dream.shared.feature.album.data.mapper.api.remote.AlbumTracksOutputToDataMapper
import and.degilevich.dream.shared.feature.album.model.artifact.data.AlbumId
import and.degilevich.dream.shared.feature.album.model.artifact.dictionary.AlbumType
import and.degilevich.dream.shared.feature.album.model.core.data.AlbumData
import and.degilevich.dream.shared.feature.artist.data.mapper.api.remote.SimplifiedArtistOutputToDataMapper
import and.degilevich.dream.shared.feature.image.data.mapper.api.remote.ImageOutputToDataMapper
import and.degilevich.dream.shared.foundation.abstraction.id.ext.getEnumValueByIdOrElse
import and.degilevich.dream.shared.foundation.abstraction.id.identifier
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith

internal class AlbumOutputToDataMapperImpl(
    private val simplifiedArtistOutputToDataMapper: SimplifiedArtistOutputToDataMapper,
    private val imageOutputToDataMapper: ImageOutputToDataMapper,
    private val albumTracksOutputToDataMapper: AlbumTracksOutputToDataMapper,
) : AlbumOutputToDataMapper {

    override fun map(item: AlbumObject): AlbumData = with(item) {
        AlbumData(
            id = id.let(::AlbumId),
            name = name,
            albumType = getEnumValueByIdOrElse(id = albumType.value.let(::identifier)) { AlbumType.UNKNOWN },
            totalTracks = totalTracks,
            releaseDate = releaseDate,
            artists = artists.mapWith(simplifiedArtistOutputToDataMapper),
            images = images.mapWith(imageOutputToDataMapper),
            tracks = tracks.mapWith(albumTracksOutputToDataMapper),
        )
    }
}