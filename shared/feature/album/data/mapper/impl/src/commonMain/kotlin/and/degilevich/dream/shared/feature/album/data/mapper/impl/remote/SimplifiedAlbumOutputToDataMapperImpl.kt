package and.degilevich.dream.shared.feature.album.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.api.generated.model.SimplifiedAlbumObject
import and.degilevich.dream.shared.feature.album.data.mapper.api.remote.SimplifiedAlbumOutputToDataMapper
import and.degilevich.dream.shared.feature.album.model.artifact.data.AlbumId
import and.degilevich.dream.shared.feature.album.model.artifact.data.SimplifiedAlbumData
import and.degilevich.dream.shared.feature.album.model.artifact.dictionary.AlbumType
import and.degilevich.dream.shared.feature.artist.data.mapper.api.remote.SimplifiedArtistOutputToDataMapper
import and.degilevich.dream.shared.feature.image.data.mapper.api.remote.ImageOutputToDataMapper
import and.degilevich.dream.shared.foundation.abstraction.id.ext.getEnumValueByIdOrElse
import and.degilevich.dream.shared.foundation.abstraction.id.identifier
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith

internal class SimplifiedAlbumOutputToDataMapperImpl(
    private val simplifiedArtistOutputToDataMapper: SimplifiedArtistOutputToDataMapper,
    private val imageOutputToDataMapper: ImageOutputToDataMapper,
) : SimplifiedAlbumOutputToDataMapper {

    override fun map(item: SimplifiedAlbumObject): SimplifiedAlbumData = with(item) {
        SimplifiedAlbumData(
            id = id.let(::AlbumId),
            name = name,
            albumType = getEnumValueByIdOrElse(id = albumType.value.let(::identifier)) { AlbumType.UNKNOWN },
            totalTracks = totalTracks,
            releaseDate = releaseDate,
            artists = artists.mapWith(simplifiedArtistOutputToDataMapper),
            images = images.mapWith(imageOutputToDataMapper)
        )
    }
}