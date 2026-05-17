package and.degilevich.dream.shared.feature.album.ui.impl.mapper

import and.degilevich.dream.shared.feature.album.ui.api.mapper.AlbumInfoToCardUIDataMapper
import and.degilevich.dream.shared.feature.album.ui.api.model.AlbumCardUIData
import and.degilevich.dream.shared.feature.album.model.artifact.abstraction.AlbumInfo
import and.degilevich.dream.shared.feature.artist.ui.api.mapper.ArtistsInfoToStringMapper

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