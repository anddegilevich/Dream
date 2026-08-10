package and.degilevich.dream.shared.feature.artist.data.mapper.impl.local

import and.degilevich.dream.shared.feature.artist.model.artifact.test.data.simplifiedArtistData
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class SimplifiedArtistDataToEntityMapperImplTest {

    @Test
    fun `map - simplified artist data - copies all scalar fields to entity`() {
        val mapper = createMapper()
        val artist = simplifiedArtistData(id = "artist-1")
        val entity = mapper.map(artist)
        with(entity) {
            id shouldBe "artist-1"
            name shouldBe "Artist artist-1"
            artistType shouldBe "artist"
        }
    }

    private fun createMapper() = SimplifiedArtistDataToEntityMapperImpl()
}
