package and.degilevich.dream.shared.feature.playlist.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.test.model.pagingPlaylistTrackObject
import and.degilevich.dream.shared.core.service.test.model.playlistTrackObject
import and.degilevich.dream.shared.feature.playlist.data.mapper.api.remote.PlaylistTrackOutputToDataMapper
import and.degilevich.dream.shared.feature.playlist.data.mapper.test.remote.FakePlaylistTrackOutputToDataMapper
import and.degilevich.dream.shared.feature.playlist.model.core.test.data.playlistTrackData
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class PlaylistTracksResponseToResultMapperImplTest {

    @Test
    fun `map - playlist tracks - delegates every item to injected mapper preserving order`() {
        val first = playlistTrackData(id = "track-1")
        val second = playlistTrackData(id = "track-2")
        val firstOutput = playlistTrackObject(addedAt = "2024-01-01T00:00:00Z")
        val secondOutput = playlistTrackObject(addedAt = "2024-02-02T00:00:00Z")
        val mapper = createMapper(
            playlistTrackOutputToDataMapper = FakePlaylistTrackOutputToDataMapper(
                onMap = { output -> if (output === firstOutput) first else second }
            )
        )
        val input = pagingPlaylistTrackObject(items = listOf(firstOutput, secondOutput))

        val result = mapper.map(input)

        result.tracks shouldBe listOf(first, second)
    }

    @Test
    fun `map - total larger than page - copies total from response`() {
        val mapper = createMapper(
            playlistTrackOutputToDataMapper = FakePlaylistTrackOutputToDataMapper(
                onMap = { playlistTrackData(id = "track-1") }
            )
        )
        val input = pagingPlaylistTrackObject(
            items = listOf(playlistTrackObject()),
            total = 145
        )

        val result = mapper.map(input)

        result.total shouldBe 145
    }

    @Test
    fun `map - empty page - returns no tracks`() {
        val result = createMapper().map(pagingPlaylistTrackObject(total = 0))

        with(result) {
            tracks shouldBe emptyList()
            total shouldBe 0
        }
    }

    private fun createMapper(
        playlistTrackOutputToDataMapper: PlaylistTrackOutputToDataMapper = FakePlaylistTrackOutputToDataMapper()
    ) = PlaylistTracksResponseToResultMapperImpl(
        playlistTrackOutputToDataMapper = playlistTrackOutputToDataMapper
    )
}
