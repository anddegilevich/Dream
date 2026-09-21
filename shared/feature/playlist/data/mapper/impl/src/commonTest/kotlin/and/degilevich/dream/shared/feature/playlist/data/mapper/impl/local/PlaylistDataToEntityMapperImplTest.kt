package and.degilevich.dream.shared.feature.playlist.data.mapper.impl.local

import and.degilevich.dream.shared.feature.image.model.artifact.test.data.imageData
import and.degilevich.dream.shared.feature.playlist.model.core.test.data.playlistData
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class PlaylistDataToEntityMapperImplTest {

    @Test
    fun `map - playlist data - copies all scalar fields to entity`() {
        val mapper = createMapper()
        val playlist = playlistData(
            id = "playlist-2",
            description = "Best of 2019",
            totalTracks = 5,
            images = listOf(imageData())
        )

        val entity = mapper.map(playlist)

        with(entity) {
            id shouldBe "playlist-2"
            name shouldBe "Playlist playlist-2"
            description shouldBe "Best of 2019"
            totalTracks shouldBe 5
        }
    }

    private fun createMapper() = PlaylistDataToEntityMapperImpl()
}
