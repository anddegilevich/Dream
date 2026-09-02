package and.degilevich.dream.shared.feature.playlist.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.test.model.playlistTrackObject
import and.degilevich.dream.shared.core.service.test.model.trackObject
import and.degilevich.dream.shared.feature.track.data.mapper.api.remote.TrackOutputToDataMapper
import and.degilevich.dream.shared.feature.track.data.mapper.test.remote.FakeTrackOutputToDataMapper
import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData
import and.degilevich.dream.shared.feature.track.model.core.test.data.trackData
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class PlaylistTrackOutputToDataMapperImplTest {

    @Test
    fun `map - item present - delegates track to injected mapper and copies addedAt`() {
        val trackData = trackData(id = "track-1")
        val mapper = createMapper(
            trackOutputToDataMapper = FakeTrackOutputToDataMapper(onMap = { trackData })
        )
        val input = playlistTrackObject(
            addedAt = "2024-05-05T00:00:00Z",
            item = trackObject()
        )

        val result = mapper.map(input)

        with(result) {
            track shouldBe trackData
            addedAt shouldBe "2024-05-05T00:00:00Z"
        }
    }

    @Test
    fun `map - null item - maps to empty track without calling injected mapper`() {
        val input = playlistTrackObject(item = null)

        val result = createMapper().map(input)

        result.track shouldBe TrackData.empty()
    }

    @Test
    fun `map - null addedAt - maps to empty string`() {
        val input = playlistTrackObject(
            addedAt = null,
            item = null
        )

        val result = createMapper().map(input)

        result.addedAt shouldBe ""
    }

    @Test
    fun `map - item present - exposes track id as identifier`() {
        val trackData = trackData(id = "track-9")
        val mapper = createMapper(
            trackOutputToDataMapper = FakeTrackOutputToDataMapper(onMap = { trackData })
        )

        val result = mapper.map(playlistTrackObject())

        result.id.value shouldBe "track-9"
    }

    private fun createMapper(
        trackOutputToDataMapper: TrackOutputToDataMapper = FakeTrackOutputToDataMapper()
    ) = PlaylistTrackOutputToDataMapperImpl(
        trackOutputToDataMapper = trackOutputToDataMapper
    )
}
