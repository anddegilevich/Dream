package and.degilevich.dream.shared.feature.player.ui.test.mapper

import and.degilevich.dream.shared.feature.player.domain.model.core.api.data.PlaybackStateData
import and.degilevich.dream.shared.feature.player.ui.api.mapper.PlaybackStateDataToPlaybackProgressUIDataMapper
import and.degilevich.dream.shared.feature.player.ui.api.model.PlaybackProgressUIData
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakePlaybackStateDataToPlaybackProgressUIDataMapper(
    private val onMap: (PlaybackStateData) -> PlaybackProgressUIData = { fakeImplementationError() }
) : PlaybackStateDataToPlaybackProgressUIDataMapper {

    override fun map(item: PlaybackStateData): PlaybackProgressUIData = onMap(item)
}
