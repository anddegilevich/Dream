package and.degilevich.dream.shared.feature.playlist.ui.impl.mapper

import and.degilevich.dream.shared.feature.image.model.artifact.test.data.imageData
import and.degilevich.dream.shared.feature.playlist.model.artifact.api.data.PlaylistId
import and.degilevich.dream.shared.feature.playlist.model.artifact.test.data.simplifiedPlaylistData
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class PlaylistInfoToCardUIDataMapperImplTest {

    @Test
    fun `map - multiple images - iconUrl uses the first image`() {
        val mapper = createMapper()
        val playlist = simplifiedPlaylistData(
            id = "playlist-1",
            images = listOf(
                imageData(url = "https://first.image"),
                imageData(url = "https://second.image")
            )
        )

        val result = mapper.map(playlist)

        with(result) {
            id shouldBe PlaylistId(value = "playlist-1")
            name shouldBe "Playlist playlist-1"
            iconUrl shouldBe "https://first.image"
        }
    }

    @Test
    fun `map - no images - iconUrl is empty`() {
        val playlist = simplifiedPlaylistData(
            id = "playlist-1",
            images = emptyList()
        )

        val result = createMapper().map(playlist)

        result.iconUrl shouldBe ""
    }

    private fun createMapper() = PlaylistInfoToCardUIDataMapperImpl()
}
