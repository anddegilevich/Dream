package and.degilevich.dream.shared.feature.player.data.mapper.test.remote

import and.degilevich.dream.shared.core.service.api.generated.model.CurrentlyPlayingContextObject
import and.degilevich.dream.shared.feature.player.data.mapper.api.remote.PlaybackStateResponseToResultMapper
import and.degilevich.dream.shared.feature.player.domain.model.core.api.method.getPlaybackState.GetPlaybackStateResult
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakePlaybackStateResponseToResultMapper(
    private val onMap: (CurrentlyPlayingContextObject) -> GetPlaybackStateResult = { fakeImplementationError() }
) : PlaybackStateResponseToResultMapper {

    override fun map(item: CurrentlyPlayingContextObject): GetPlaybackStateResult = onMap(item)
}
