package and.degilevich.dream.shared.feature.player.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.test.model.currentlyPlayingContextObject
import and.degilevich.dream.shared.core.service.test.model.trackObject
import and.degilevich.dream.shared.feature.player.data.mapper.api.remote.PlaybackStateOutputToDataMapper
import and.degilevich.dream.shared.feature.player.data.mapper.test.remote.FakePlaybackStateOutputToDataMapper
import and.degilevich.dream.shared.feature.player.domain.model.core.api.method.getPlaybackState.GetPlaybackStateResult
import and.degilevich.dream.shared.feature.player.domain.model.core.test.data.playbackStateData
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class PlaybackStateResponseToResultMapperImplTest {

    @Test
    fun `map - item present - returns value mapped via injected mapper`() {
        val playbackState = playbackStateData(trackId = "track-1")
        val input = currentlyPlayingContextObject(item = trackObject())
        val mapper = createMapper(
            playbackStateOutputToDataMapper = FakePlaybackStateOutputToDataMapper(
                onMap = { output -> if (output === input) playbackState else error("Unexpected input") }
            )
        )

        val result = mapper.map(input)

        result shouldBe GetPlaybackStateResult.Value(playbackState = playbackState)
    }

    @Test
    fun `map - null item - returns none without calling injected mapper`() {
        val result = createMapper().map(currentlyPlayingContextObject(item = null))

        result shouldBe GetPlaybackStateResult.None
    }

    private fun createMapper(
        playbackStateOutputToDataMapper: PlaybackStateOutputToDataMapper = FakePlaybackStateOutputToDataMapper()
    ) = PlaybackStateResponseToResultMapperImpl(
        playbackStateOutputToDataMapper = playbackStateOutputToDataMapper
    )
}
