package and.degilevich.dream.shared.feature.track.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.api.generated.model.SavedTrackObject
import and.degilevich.dream.shared.feature.track.data.mapper.api.remote.SavedTrackOutputToDataMapper
import and.degilevich.dream.shared.feature.track.data.mapper.api.remote.TrackOutputToDataMapper
import and.degilevich.dream.shared.feature.track.model.core.api.data.SavedTrackData
import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.ext.orEmpty
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith

internal class SavedTrackOutputToDataMapperImpl(
    private val trackOutputToDataMapper: TrackOutputToDataMapper
) : SavedTrackOutputToDataMapper {

    override fun map(item: SavedTrackObject): SavedTrackData = with(item) {
        SavedTrackData(
            track = track?.mapWith(trackOutputToDataMapper).orEmpty(TrackData),
            addedAt = addedAt.orEmpty()
        )
    }
}
