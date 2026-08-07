package and.degilevich.dream.shared.feature.track.data.mapper.impl.local

import and.degilevich.dream.shared.feature.album.model.artifact.test.data.simplifiedAlbumData
import and.degilevich.dream.shared.feature.track.model.core.test.data.trackData
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class TrackDataToEntityMapperImplTest {

    @Test
    fun `map - full track data - copies scalar fields and album id to entity`() {
        val album = simplifiedAlbumData(id = "album-1")
        val track = trackData(
            id = "track-1",
            trackNumber = 3,
            durationMs = 2000,
            album = album
        )
        val entity = createMapper().map(track)
        with(entity) {
            id shouldBe "track-1"
            name shouldBe "Track track-1"
            albumId shouldBe "album-1"
            trackNumber shouldBe 3
            durationMs shouldBe 2000
        }
    }

    private fun createMapper() = TrackDataToEntityMapperImpl()
}
