package and.degilevich.dream.shared.feature.player.data.mapper.test.remote

import and.degilevich.dream.shared.core.service.api.generated.model.CurrentlyPlayingContextObject
import and.degilevich.dream.shared.feature.player.data.mapper.api.remote.PlaybackStateOutputToDataMapper
import and.degilevich.dream.shared.feature.player.domain.model.core.api.data.PlaybackStateData
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakePlaybackStateOutputToDataMapper(
    private val onMap: (CurrentlyPlayingContextObject) -> PlaybackStateData = { fakeImplementationError() }
) : PlaybackStateOutputToDataMapper {

    override fun map(item: CurrentlyPlayingContextObject): PlaybackStateData = onMap(item)
}
