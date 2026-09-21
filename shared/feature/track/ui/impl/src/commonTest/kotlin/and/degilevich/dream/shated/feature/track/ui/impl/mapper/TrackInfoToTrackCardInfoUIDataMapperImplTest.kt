package and.degilevich.dream.shated.feature.track.ui.impl.mapper

import and.degilevich.dream.shared.feature.artist.model.artifact.test.data.simplifiedArtistData
import and.degilevich.dream.shared.feature.artist.ui.test.mapper.FakeArtistsInfoToStringMapper
import and.degilevich.dream.shared.feature.track.model.artifact.test.data.simplifiedTrackData
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class TrackInfoToTrackCardInfoUIDataMapperImplTest {

    @Test
    fun `map - multiple artists - copies name and delegates artists to artists mapper`() {
        val track = simplifiedTrackData(
            id = "track-1",
            artists = listOf(
                simplifiedArtistData(id = "artist-a"),
                simplifiedArtistData(id = "artist-b")
            )
        )
        val mapper = TrackInfoToTrackCardInfoUIDataMapperImpl(
            artistsInfoToStringMapper = FakeArtistsInfoToStringMapper(
                onMap = { artists -> artists.joinToString(separator = ", ") { artist -> artist.name } }
            )
        )

        val result = mapper.map(track)

        with(result) {
            name shouldBe track.name
            artists shouldBe "Artist artist-a, Artist artist-b"
        }
    }
}
