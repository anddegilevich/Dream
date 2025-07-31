package and.degilevich.dream.shared.feature.search.design.impl.mapper

import and.degilevich.dream.shared.feature.artist.design.api.mapper.ArtistsInfoToStringMapper
import and.degilevich.dream.shared.feature.search.design.api.mapper.TrackDataToSearchCardUIDataMapper
import and.degilevich.dream.shared.feature.search.design.api.model.card.TrackSearchCardUIData
import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData

internal class TrackDataToSearchCardUIDataMapperImpl(
    private val artistsInfoToStringMapper: ArtistsInfoToStringMapper
) : TrackDataToSearchCardUIDataMapper {
    override fun map(item: TrackData): TrackSearchCardUIData {
        return with(item) {
            TrackSearchCardUIData(
                id = id,
                iconUrl = album.images.firstOrNull()?.url.orEmpty(),
                name = name,
                artistName = artistsInfoToStringMapper.map(artists)
            )
        }
    }
}