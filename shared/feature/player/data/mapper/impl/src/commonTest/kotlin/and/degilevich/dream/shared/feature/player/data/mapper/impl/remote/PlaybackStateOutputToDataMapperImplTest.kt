package and.degilevich.dream.shared.feature.player.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.test.model.currentlyPlayingContextObject
import and.degilevich.dream.shared.core.service.test.model.trackObject
import and.degilevich.dream.shared.feature.track.data.mapper.api.remote.TrackOutputToDataMapper
import and.degilevich.dream.shared.feature.track.data.mapper.test.remote.FakeTrackOutputToDataMapper
import and.degilevich.dream.shared.feature.track.domain.model.core.api.data.TrackData
import and.degilevich.dream.shared.feature.track.domain.model.core.test.data.trackData
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class PlaybackStateOutputToDataMapperImplTest {

    @Test
    fun `map - item present - delegates track to injected mapper`() {
        val trackData = trackData(id = "track-1")
        val mapper = createMapper(
            trackOutputToDataMapper = FakeTrackOutputToDataMapper(onMap = { trackData })
        )

        val result = mapper.map(currentlyPlayingContextObject(item = trackObject()))

        result.track shouldBe trackData
    }

    @Test
    fun `map - null item - maps to empty track without calling injected mapper`() {
        val result = createMapper().map(currentlyPlayingContextObject(item = null))

        result.track shouldBe TrackData.empty()
    }

    @Test
    fun `map - playback fields present - copies playing progress shuffle and device name`() {
        val input = currentlyPlayingContextObject(
            item = null,
            isPlaying = true,
            progressMs = 42000,
            shuffleState = true
        )

        val result = createMapper().map(input)

        with(result) {
            isPlaying shouldBe true
            progressMs shouldBe 42000
            isShuffling shouldBe true
            deviceName shouldBe "Device Name"
        }
    }

    @Test
    fun `map - playback fields null - maps to not playing zero progress and shuffle off`() {
        val input = currentlyPlayingContextObject(
            item = null,
            isPlaying = null,
            progressMs = null,
            shuffleState = null
        )

        val result = createMapper().map(input)

        with(result) {
            isPlaying shouldBe false
            progressMs shouldBe 0
            isShuffling shouldBe false
        }
    }

    @Test
    fun `map - null device - maps to empty device name`() {
        val input = currentlyPlayingContextObject(item = null).copy(device = null)

        val result = createMapper().map(input)

        result.deviceName shouldBe ""
    }

    private fun createMapper(
        trackOutputToDataMapper: TrackOutputToDataMapper = FakeTrackOutputToDataMapper()
    ) = PlaybackStateOutputToDataMapperImpl(
        trackOutputToDataMapper = trackOutputToDataMapper
    )
}
