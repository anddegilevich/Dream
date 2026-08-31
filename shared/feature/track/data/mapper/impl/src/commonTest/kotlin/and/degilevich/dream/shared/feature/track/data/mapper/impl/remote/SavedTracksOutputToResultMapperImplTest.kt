package and.degilevich.dream.shared.feature.track.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.test.model.pagingSavedTrackObject
import and.degilevich.dream.shared.core.service.test.model.savedTrackObject
import and.degilevich.dream.shared.feature.track.data.mapper.api.remote.SavedTrackOutputToDataMapper
import and.degilevich.dream.shared.feature.track.data.mapper.test.remote.FakeSavedTrackOutputToDataMapper
import and.degilevich.dream.shared.feature.track.model.core.api.data.SavedTrackData
import and.degilevich.dream.shared.feature.track.model.core.test.data.savedTrackData
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class SavedTracksOutputToResultMapperImplTest {

    @Test
    fun `map - saved tracks - delegates every item to injected mapper preserving order`() {
        val first = savedTrackData(id = "track-1")
        val second = savedTrackData(id = "track-2")
        val firstOutput = savedTrackObject(addedAt = "2024-01-01T00:00:00Z")
        val secondOutput = savedTrackObject(addedAt = "2024-02-02T00:00:00Z")
        val mapper = createMapper(
            savedTrackOutputToDataMapper = FakeSavedTrackOutputToDataMapper(
                onMap = { output -> if (output === firstOutput) first else second }
            )
        )
        val input = pagingSavedTrackObject(items = listOf(firstOutput, secondOutput))

        val result = mapper.map(input)

        result.tracks shouldBe listOf(first, second)
    }

    @Test
    fun `map - total larger than page - copies total from response`() {
        val mapper = createMapper(
            savedTrackOutputToDataMapper = FakeSavedTrackOutputToDataMapper(
                onMap = { savedTrackData(id = "track-1") }
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
    fun `map - item mapped to empty - drops the item`() {
        val savedTrack = savedTrackData(id = "track-1")
        val emptyOutput = savedTrackObject(track = null)
        val mapper = createMapper(
            savedTrackOutputToDataMapper = FakeSavedTrackOutputToDataMapper(
                onMap = { output -> if (output === emptyOutput) SavedTrackData.empty() else savedTrack }
            )
        )
        val input = pagingSavedTrackObject(
            items = listOf(emptyOutput, savedTrackObject()),
            total = 2
        )

        val result = mapper.map(input)

        with(result) {
            tracks shouldBe listOf(savedTrack)
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
        savedTrackOutputToDataMapper: SavedTrackOutputToDataMapper = FakeSavedTrackOutputToDataMapper()
    ) = SavedTracksOutputToResultMapperImpl(
        savedTrackOutputToDataMapper = savedTrackOutputToDataMapper
    )
}
