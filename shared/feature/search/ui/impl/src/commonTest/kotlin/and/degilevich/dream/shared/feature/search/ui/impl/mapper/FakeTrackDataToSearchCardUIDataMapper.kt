package and.degilevich.dream.shared.feature.search.ui.impl.mapper

import and.degilevich.dream.shared.feature.search.ui.api.mapper.TrackDataToSearchCardUIDataMapper
import and.degilevich.dream.shared.feature.search.ui.api.model.card.TrackSearchCardUIData
import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeTrackDataToSearchCardUIDataMapper(
    private val onMap: (item: TrackData) -> TrackSearchCardUIData = { fakeImplementationError() }
) : TrackDataToSearchCardUIDataMapper {

    override fun map(item: TrackData): TrackSearchCardUIData = onMap(item)
}
