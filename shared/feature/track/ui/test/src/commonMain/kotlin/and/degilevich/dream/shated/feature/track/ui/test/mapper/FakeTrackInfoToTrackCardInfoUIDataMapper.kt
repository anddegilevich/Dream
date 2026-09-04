package and.degilevich.dream.shated.feature.track.ui.test.mapper

import and.degilevich.dream.shared.feature.track.model.artifact.api.abstraction.TrackInfo
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError
import and.degilevich.dream.shated.feature.track.ui.api.mapper.TrackInfoToTrackCardInfoUIDataMapper
import and.degilevich.dream.shated.feature.track.ui.api.model.TrackCardInfoUIData

class FakeTrackInfoToTrackCardInfoUIDataMapper(
    private val onMap: (TrackInfo) -> TrackCardInfoUIData = { fakeImplementationError() }
) : TrackInfoToTrackCardInfoUIDataMapper {

    override fun map(item: TrackInfo): TrackCardInfoUIData = onMap(item)
}
