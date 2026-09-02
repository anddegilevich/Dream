package and.degilevich.dream.shared.feature.search.ui.impl.mapper

import and.degilevich.dream.shared.feature.search.model.core.api.data.SearchItemData
import and.degilevich.dream.shared.feature.search.ui.api.mapper.AlbumInfoToSearchCardUIDataMapper
import and.degilevich.dream.shared.feature.search.ui.api.mapper.ArtistDataToSearchCardUIDataMapper
import and.degilevich.dream.shared.feature.search.ui.api.mapper.SearchItemDataToSearchCardUIDataMapper
import and.degilevich.dream.shared.feature.search.ui.api.mapper.TrackDataToSearchCardUIDataMapper
import and.degilevich.dream.shared.feature.search.ui.api.model.card.SearchCardUIData

internal class SearchItemDataToSearchCardUIDataMapperImpl(
    private val artistDataToSearchCardUIDataMapper: ArtistDataToSearchCardUIDataMapper,
    private val albumInfoToSearchCardUIDataMapper: AlbumInfoToSearchCardUIDataMapper,
    private val trackDataToSearchCardUIDataMapper: TrackDataToSearchCardUIDataMapper
) : SearchItemDataToSearchCardUIDataMapper {

    override fun map(item: SearchItemData): SearchCardUIData = when (item) {
        is SearchItemData.Artist -> artistDataToSearchCardUIDataMapper.map(item.artist)
        is SearchItemData.Album -> albumInfoToSearchCardUIDataMapper.map(item.album)
        is SearchItemData.Track -> trackDataToSearchCardUIDataMapper.map(item.track)
    }
}
