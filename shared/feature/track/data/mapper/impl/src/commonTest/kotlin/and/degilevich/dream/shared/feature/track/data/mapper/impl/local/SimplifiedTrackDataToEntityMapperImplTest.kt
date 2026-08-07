package and.degilevich.dream.shared.feature.track.data.mapper.impl.local

import and.degilevich.dream.shared.feature.track.model.artifact.test.data.simplifiedTrackData
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class SimplifiedTrackDataToEntityMapperImplTest {

    @Test
    fun `map - simplified track data - copies scalar fields and leaves album id null`() {
        val track = simplifiedTrackData(
            id = "track-1",
            artists = emptyList()
        )
        val entity = createMapper().map(track)
        with(entity) {
            id shouldBe "track-1"
            name shouldBe "Track track-1"
            albumId shouldBe null
            trackNumber shouldBe 1
            durationMs shouldBe 1000
        }
    }

    private fun createMapper() = SimplifiedTrackDataToEntityMapperImpl()
}
