package and.degilevich.dream.shared.feature.player.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.test.model.playHistoryObject
import and.degilevich.dream.shared.core.service.test.model.trackObject
import and.degilevich.dream.shared.feature.track.data.mapper.api.remote.TrackOutputToDataMapper
import and.degilevich.dream.shared.feature.track.data.mapper.test.remote.FakeTrackOutputToDataMapper
import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData
import and.degilevich.dream.shared.feature.track.model.core.test.data.trackData
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class PlayHistoryOutputToDataMapperImplTest {

    @Test
    fun `map - track present - delegates track to injected mapper and copies playedAt`() {
        val trackData = trackData(id = "track-1")
        val mapper = createMapper(
            trackOutputToDataMapper = FakeTrackOutputToDataMapper(onMap = { trackData })
        )
        val input = playHistoryObject(
            track = trackObject(),
            playedAt = "2024-05-05T00:00:00Z"
        )

        val result = mapper.map(input)

        with(result) {
            track shouldBe trackData
            playedAt shouldBe "2024-05-05T00:00:00Z"
        }
    }

    @Test
    fun `map - null track - maps to empty track without calling injected mapper`() {
        val input = playHistoryObject(track = null)

        val result = createMapper().map(input)

        result.track shouldBe TrackData.empty()
    }

    @Test
    fun `map - null playedAt - maps to empty string`() {
        val input = playHistoryObject(
            track = null,
            playedAt = null
        )

        val result = createMapper().map(input)

        result.playedAt shouldBe ""
    }

    @Test
    fun `map - track present - exposes track id as identifier`() {
        val mapper = createMapper(
            trackOutputToDataMapper = FakeTrackOutputToDataMapper(onMap = { trackData(id = "track-9") })
        )

        val result = mapper.map(playHistoryObject())

        result.id.value shouldBe "track-9"
    }

    private fun createMapper(
        trackOutputToDataMapper: TrackOutputToDataMapper = FakeTrackOutputToDataMapper()
    ) = PlayHistoryOutputToDataMapperImpl(
        trackOutputToDataMapper = trackOutputToDataMapper
    )
}
