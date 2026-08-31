package and.degilevich.dream.shared.feature.track.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.test.model.savedTrackObject
import and.degilevich.dream.shared.core.service.test.model.trackObject
import and.degilevich.dream.shared.feature.track.data.mapper.api.remote.TrackOutputToDataMapper
import and.degilevich.dream.shared.feature.track.data.mapper.test.remote.FakeTrackOutputToDataMapper
import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData
import and.degilevich.dream.shared.feature.track.model.core.test.data.trackData
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class SavedTrackOutputToDataMapperImplTest {

    @Test
    fun `map - saved track - delegates track to injected mapper and copies added at`() {
        val track = trackData(id = "track-1")
        val mapper = createMapper(
            trackOutputToDataMapper = FakeTrackOutputToDataMapper(onMap = { track })
        )
        val input = savedTrackObject(
            addedAt = "2020-05-17T10:36:00Z",
            track = trackObject()
        )

        val result = mapper.map(input)

        with(result) {
            this.track shouldBe track
            addedAt shouldBe "2020-05-17T10:36:00Z"
        }
    }

    @Test
    fun `map - no added at - falls back to empty added at`() {
        val mapper = createMapper(
            trackOutputToDataMapper = FakeTrackOutputToDataMapper(onMap = { trackData(id = "track-1") })
        )

        val result = mapper.map(savedTrackObject(addedAt = null))

        result.addedAt shouldBe ""
    }

    @Test
    fun `map - no track - falls back to empty track`() {
        val result = createMapper().map(savedTrackObject(track = null))

        with(result) {
            track shouldBe TrackData.empty()
            isEmpty() shouldBe true
        }
    }

    @Test
    fun `map - track present - is not empty`() {
        val mapper = createMapper(
            trackOutputToDataMapper = FakeTrackOutputToDataMapper(onMap = { trackData(id = "track-1") })
        )

        val result = mapper.map(savedTrackObject())

        result.isEmpty() shouldBe false
    }

    private fun createMapper(
        trackOutputToDataMapper: TrackOutputToDataMapper = FakeTrackOutputToDataMapper()
    ) = SavedTrackOutputToDataMapperImpl(
        trackOutputToDataMapper = trackOutputToDataMapper
    )
}
