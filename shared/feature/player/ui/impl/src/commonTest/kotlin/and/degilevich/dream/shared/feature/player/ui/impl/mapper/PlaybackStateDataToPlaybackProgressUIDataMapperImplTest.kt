package and.degilevich.dream.shared.feature.player.ui.impl.mapper

import and.degilevich.dream.shared.feature.player.domain.model.core.api.data.PlaybackStateData
import and.degilevich.dream.shared.feature.player.domain.model.core.test.data.playbackStateData
import and.degilevich.dream.shared.feature.track.domain.model.core.test.data.trackData
import and.degilevich.dream.shared.foundation.datetime.api.DateTimeHelper
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class PlaybackStateDataToPlaybackProgressUIDataMapperImplTest {

    @Test
    fun `map - progress under a minute - formats elapsed as minutes and seconds`() {
        val result = createMapper().map(playback(progressMs = 20_000, durationMs = 80_000))

        result.elapsed shouldBe "0:20"
    }

    @Test
    fun `map - seconds below ten - pads seconds with a zero`() {
        val result = createMapper().map(playback(progressMs = 65_000, durationMs = 605_000))

        result.elapsed shouldBe "1:05"
    }

    @Test
    fun `map - partial second - rounds down to whole seconds`() {
        val result = createMapper().map(playback(progressMs = 20_999, durationMs = 80_000))

        result.elapsed shouldBe "0:20"
    }

    @Test
    fun `map - elapsed an hour or longer - formats as hours minutes and seconds`() {
        val result = createMapper().map(playback(progressMs = 3_723_000, durationMs = 4_000_000))

        result.elapsed shouldBe "1:02:03"
    }

    @Test
    fun `map - progress within duration - formats remaining time with a leading minus`() {
        val result = createMapper().map(playback(progressMs = 20_000, durationMs = 80_000))

        result.remaining shouldBe "-1:00"
    }

    @Test
    fun `map - partial second - rounds remaining down to whole seconds`() {
        val result = createMapper().map(playback(progressMs = 20_999, durationMs = 80_000))

        result.remaining shouldBe "-0:59"
    }

    @Test
    fun `map - progress beyond duration - remaining is zero`() {
        val result = createMapper().map(playback(progressMs = 90_000, durationMs = 80_000))

        result.remaining shouldBe "-0:00"
    }

    @Test
    fun `map - remaining an hour or longer - formats as hours minutes and seconds`() {
        val result = createMapper().map(playback(progressMs = 61_000, durationMs = 3_723_000))

        result.remaining shouldBe "-1:01:02"
    }

    @Test
    fun `map - progress within duration - fraction is progress divided by duration`() {
        val result = createMapper().map(playback(progressMs = 20_000, durationMs = 80_000))

        result.fraction shouldBe 0.25f
    }

    @Test
    fun `map - progress beyond duration - fraction is capped at one`() {
        val result = createMapper().map(playback(progressMs = 90_000, durationMs = 80_000))

        result.fraction shouldBe 1f
    }

    @Test
    fun `map - zero duration - fraction is zero`() {
        val result = createMapper().map(playback(progressMs = 20_000, durationMs = 0))

        result.fraction shouldBe 0f
    }

    private fun playback(progressMs: Int, durationMs: Int): PlaybackStateData = playbackStateData(
        track = trackData(id = "track-1", durationMs = durationMs),
        progressMs = progressMs
    )

    private fun createMapper() = PlaybackStateDataToPlaybackProgressUIDataMapperImpl(
        dateTime = DateTimeHelper()
    )
}
