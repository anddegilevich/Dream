package and.degilevich.dream.shated.feature.track.ui.impl.mapper

import and.degilevich.dream.shared.feature.track.model.artifact.abstraction.TrackInfo
import and.degilevich.dream.shated.feature.track.ui.api.mapper.TrackInfoToTrackCardUIDataMapper
import and.degilevich.dream.shated.feature.track.ui.api.model.TrackCardUIData

internal class TrackInfoToTrackCardUIDataMapperImpl : TrackInfoToTrackCardUIDataMapper {
    override fun map(item: TrackInfo): TrackCardUIData {
        return with(item) {
            TrackCardUIData(
                id = id,
                name = name,
                number = trackNumber.toString(),
                artists = artists.joinToString(separator = ", ") { artist -> artist.name }
            )
        }
    }
}