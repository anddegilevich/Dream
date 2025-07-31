package and.degilevich.dream.shared.feature.search.design.impl.mapper

import and.degilevich.dream.shared.feature.album.model.artifact.api.abstraction.AlbumInfo
import and.degilevich.dream.shared.feature.artist.design.api.mapper.ArtistsInfoToStringMapper
import and.degilevich.dream.shared.feature.search.design.api.mapper.AlbumInfoToSearchCardUIDataMapper
import and.degilevich.dream.shared.feature.search.design.api.model.card.AlbumSearchCardUIData

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