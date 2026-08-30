package and.degilevich.dream.shared.feature.playlist.data.mapper.impl.local

import and.degilevich.dream.shared.feature.image.model.artifact.test.data.imageData
import and.degilevich.dream.shared.feature.playlist.model.artifact.test.data.simplifiedPlaylistData
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class SimplifiedPlaylistDataToEntityMapperImplTest {

    @Test
    fun `map - simplified playlist data - copies all scalar fields to entity`() {
        val mapper = createMapper()
        val playlist = simplifiedPlaylistData(
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

    private fun createMapper() = SimplifiedPlaylistDataToEntityMapperImpl()
}
