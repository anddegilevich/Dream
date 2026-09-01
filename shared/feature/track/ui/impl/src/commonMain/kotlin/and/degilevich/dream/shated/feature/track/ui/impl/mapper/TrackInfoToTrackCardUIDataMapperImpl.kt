package and.degilevich.dream.shated.feature.track.ui.impl.mapper

import and.degilevich.dream.shared.feature.track.model.artifact.api.abstraction.TrackInfo
import and.degilevich.dream.shated.feature.track.ui.api.mapper.TrackInfoToTrackCardInfoUIDataMapper
import and.degilevich.dream.shated.feature.track.ui.api.mapper.TrackInfoToTrackCardUIDataMapper
import and.degilevich.dream.shated.feature.track.ui.api.model.TrackCardUIData

internal class TrackInfoToTrackCardUIDataMapperImpl(
    private val trackInfoToTrackCardInfoUIDataMapper: TrackInfoToTrackCardInfoUIDataMapper
) : TrackInfoToTrackCardUIDataMapper {

    override fun map(item: TrackInfo): TrackCardUIData = with(item) {
        TrackCardUIData(
            id = id,
            number = trackNumber.toString(),
            info = trackInfoToTrackCardInfoUIDataMapper.map(item)
        )
    }
}
