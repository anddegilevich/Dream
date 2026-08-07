package and.degilevich.dream.shated.feature.track.ui.impl.mapper

import and.degilevich.dream.shared.feature.artist.model.artifact.test.data.simplifiedArtistData
import and.degilevich.dream.shared.feature.track.model.artifact.test.data.simplifiedTrackData
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class TrackInfoToTrackCardUIDataMapperImplTest {

    @Test
    fun `map - multiple artists - joins artist names and copies scalar fields`() {
        val track = simplifiedTrackData(
            id = "track-1",
            artists = listOf(
                simplifiedArtistData(id = "artist-a"),
                simplifiedArtistData(id = "artist-b")
            )
        )
        val result = createMapper().map(track)
        with(result) {
            id shouldBe track.id
            name shouldBe track.name
            number shouldBe track.trackNumber.toString()
            artists shouldBe "Artist artist-a, Artist artist-b"
        }
    }

    private fun createMapper() = TrackInfoToTrackCardUIDataMapperImpl()
}
