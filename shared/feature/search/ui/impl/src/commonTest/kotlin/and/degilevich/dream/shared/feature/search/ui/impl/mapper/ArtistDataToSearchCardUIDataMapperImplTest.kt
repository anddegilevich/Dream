package and.degilevich.dream.shared.feature.search.ui.impl.mapper

import and.degilevich.dream.shared.feature.artist.model.core.test.data.artistData
import and.degilevich.dream.shared.feature.image.model.artifact.test.data.imageData
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class ArtistDataToSearchCardUIDataMapperImplTest {

    @Test
    fun `map - multiple images - iconUrl uses the first image`() {
        val artist = artistData(
            id = "artist-1",
            images = listOf(
                imageData(url = "https://first.image"),
                imageData(url = "https://second.image")
            )
        )
        val result = createMapper().map(artist)
        with(result) {
            id shouldBe artist.id
            name shouldBe artist.name
            iconUrl shouldBe "https://first.image"
        }
    }

    @Test
    fun `map - no images - iconUrl is empty`() {
        val artist = artistData(
            id = "artist-1",
            images = emptyList()
        )
        val result = createMapper().map(artist)
        result.iconUrl shouldBe ""
    }

    private fun createMapper() = ArtistDataToSearchCardUIDataMapperImpl()
}
