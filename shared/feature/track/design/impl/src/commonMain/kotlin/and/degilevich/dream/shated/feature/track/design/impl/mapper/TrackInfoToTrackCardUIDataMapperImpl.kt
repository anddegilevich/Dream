package and.degilevich.dream.shated.feature.track.design.impl.mapper

import and.degilevich.dream.shared.feature.track.model.artifact.api.abstraction.TrackInfo
import and.degilevich.dream.shated.feature.track.design.api.mapper.TrackInfoToTrackCardUIDataMapper
import and.degilevich.dream.shated.feature.track.design.api.model.TrackCardUIData

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