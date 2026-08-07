package and.degilevich.dream.shared.feature.artist.ui.api.mapper

import and.degilevich.dream.shared.feature.artist.model.artifact.test.data.simplifiedArtistData
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class ArtistsInfoToStringMapperImplTest {

    @Test
    fun `map - multiple artists - joins names with comma`() {
        val artists = listOf(
            simplifiedArtistData(id = "artist-a"),
            simplifiedArtistData(id = "artist-b")
        )
        val result = createMapper().map(artists)
        result shouldBe "Artist artist-a, Artist artist-b"
    }

    @Test
    fun `map - empty artists - returns empty string`() {
        val result = createMapper().map(emptyList())
        result shouldBe ""
    }

    private fun createMapper() = ArtistsInfoToStringMapperImpl()
}
