package and.degilevich.dream.shared.feature.track.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.api.generated.model.PagingSavedTrackObject
import and.degilevich.dream.shared.feature.track.data.mapper.api.remote.SavedTrackOutputToDataMapper
import and.degilevich.dream.shared.feature.track.data.mapper.api.remote.SavedTracksOutputToResultMapper
import and.degilevich.dream.shared.feature.track.model.core.api.method.getSavedTracks.GetSavedTracksResult
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith

internal class SavedTracksOutputToResultMapperImpl(
    private val savedTrackOutputToDataMapper: SavedTrackOutputToDataMapper
) : SavedTracksOutputToResultMapper {

    override fun map(item: PagingSavedTrackObject): GetSavedTracksResult = with(item) {
        GetSavedTracksResult(
            tracks = items.mapWith(savedTrackOutputToDataMapper),
            total = total
        )
    }
}
