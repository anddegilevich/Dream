package and.degilevich.dream.shated.feature.track.ui.impl.mapper

import and.degilevich.dream.shared.feature.artist.ui.api.mapper.ArtistsInfoToStringMapper
import and.degilevich.dream.shared.feature.track.model.artifact.api.abstraction.TrackInfo
import and.degilevich.dream.shated.feature.track.ui.api.mapper.TrackInfoToTrackCardInfoUIDataMapper
import and.degilevich.dream.shated.feature.track.ui.api.model.TrackCardInfoUIData

internal class TrackInfoToTrackCardInfoUIDataMapperImpl(
    private val artistsInfoToStringMapper: ArtistsInfoToStringMapper
) : TrackInfoToTrackCardInfoUIDataMapper {

    override fun map(item: TrackInfo): TrackCardInfoUIData = with(item) {
        TrackCardInfoUIData(
            name = name,
            artists = artistsInfoToStringMapper.map(artists)
        )
    }
}
