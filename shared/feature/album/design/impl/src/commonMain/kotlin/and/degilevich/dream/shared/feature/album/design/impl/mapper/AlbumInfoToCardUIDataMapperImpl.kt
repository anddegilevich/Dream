package and.degilevich.dream.shared.feature.album.design.impl.mapper

import and.degilevich.dream.shared.feature.album.design.api.mapper.AlbumInfoToCardUIDataMapper
import and.degilevich.dream.shared.feature.album.design.api.model.AlbumCardUIData
import and.degilevich.dream.shared.feature.album.model.artifact.api.abstraction.AlbumInfo
import and.degilevich.dream.shared.feature.artist.design.api.mapper.ArtistsInfoToStringMapper

internal class AlbumInfoToCardUIDataMapperImpl(
    private val artistsInfoToStringMapper: ArtistsInfoToStringMapper
) : AlbumInfoToCardUIDataMapper {
    override fun map(
        item: AlbumInfo
    ): AlbumCardUIData {
        return with(item) {
            AlbumCardUIData(
                id = id,
                iconUrl = images.firstOrNull()?.url.orEmpty(),
                name = name,
                artists = artistsInfoToStringMapper.map(artists)
            )
        }
    }
}