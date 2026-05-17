package and.degilevich.dream.shared.feature.search.ui.impl.mapper

import and.degilevich.dream.shared.feature.album.model.artifact.abstraction.AlbumInfo
import and.degilevich.dream.shared.feature.artist.ui.api.mapper.ArtistsInfoToStringMapper
import and.degilevich.dream.shared.feature.search.ui.api.mapper.AlbumInfoToSearchCardUIDataMapper
import and.degilevich.dream.shared.feature.search.ui.api.model.card.AlbumSearchCardUIData

internal class AlbumInfoToSearchCardUIDataMapperImpl(
    private val artistsInfoToStringMapper: ArtistsInfoToStringMapper
) : AlbumInfoToSearchCardUIDataMapper {
    override fun map(item: AlbumInfo): AlbumSearchCardUIData {
        return with(item) {
            AlbumSearchCardUIData(
                id = id,
                iconUrl = images.firstOrNull()?.url.orEmpty(),
                name = name,
                artistName = artistsInfoToStringMapper.map(artists)
            )
        }
    }
}