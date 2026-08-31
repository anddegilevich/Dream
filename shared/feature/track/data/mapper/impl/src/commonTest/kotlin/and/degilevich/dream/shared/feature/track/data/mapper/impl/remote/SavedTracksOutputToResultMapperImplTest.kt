package and.degilevich.dream.shared.feature.track.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.test.model.pagingSavedTrackObject
import and.degilevich.dream.shared.core.service.test.model.savedTrackObject
import and.degilevich.dream.shared.core.service.test.model.trackObject
import and.degilevich.dream.shared.feature.track.data.mapper.api.remote.TrackOutputToDataMapper
import and.degilevich.dream.shared.feature.track.data.mapper.test.remote.FakeTrackOutputToDataMapper
import and.degilevich.dream.shared.feature.track.model.core.test.data.trackData
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class SavedTracksOutputToResultMapperImplTest {

    @Test
    fun `map - saved tracks - delegates every track to injected mapper preserving order`() {
        val firstTrack = trackData(id = "track-1")
        val secondTrack = trackData(id = "track-2")
        val firstOutput = trackObject()
        val secondOutput = trackObject()
        val mapper = createMapper(
            trackOutputToDataMapper = FakeTrackOutputToDataMapper(
                onMap = { output -> if (output === firstOutput) firstTrack else secondTrack }
            )
        )
        val input = pagingSavedTrackObject(
            items = listOf(
                savedTrackObject(track = firstOutput),
                savedTrackObject(track = secondOutput)
            )
        )

        val result = mapper.map(input)

        result.tracks shouldBe listOf(firstTrack, secondTrack)
    }

    @Test
    fun `map - total larger than page - copies total from response`() {
        val mapper = createMapper(
            trackOutputToDataMapper = FakeTrackOutputToDataMapper(
                onMap = { trackData(id = "track-1") }
            )
        )
        val input = pagingSavedTrackObject(
            items = listOf(savedTrackObject()),
            total = 145
        )

        val result = mapper.map(input)

        result.total shouldBe 145
    }

    @Test
    fun `map - item without track - drops the item`() {
        val track = trackData(id = "track-1")
        val mapper = createMapper(
            trackOutputToDataMapper = FakeTrackOutputToDataMapper(onMap = { track })
        )
        val input = pagingSavedTrackObject(
            items = listOf(
                savedTrackObject(track = null),
                savedTrackObject(track = trackObject())
            ),
            total = 2
        )

        val result = mapper.map(input)

        with(result) {
            tracks shouldBe listOf(track)
            total shouldBe 2
        }
    }

    @Test
    fun `map - empty page - returns no tracks`() {
        val result = createMapper().map(pagingSavedTrackObject(total = 0))

        with(result) {
            tracks shouldBe emptyList()
            total shouldBe 0
        }
    }

    private fun createMapper(
        trackOutputToDataMapper: TrackOutputToDataMapper = FakeTrackOutputToDataMapper()
    ) = SavedTracksOutputToResultMapperImpl(
        trackOutputToDataMapper = trackOutputToDataMapper
    )
}
