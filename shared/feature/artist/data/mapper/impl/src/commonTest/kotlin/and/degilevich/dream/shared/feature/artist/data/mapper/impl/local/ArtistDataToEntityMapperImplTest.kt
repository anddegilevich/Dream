package and.degilevich.dream.shared.feature.artist.data.mapper.impl.local

import and.degilevich.dream.shared.feature.artist.model.artifact.api.dictionary.ArtistType
import and.degilevich.dream.shared.feature.artist.model.core.test.data.artistData
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class ArtistDataToEntityMapperImplTest {

    @Test
    fun `map - full artist data - copies all scalar fields to entity`() {
        val mapper = createMapper()
        val artist = artistData(
            id = "artist-1",
            artistType = ArtistType.ARTIST
        )
        val entity = mapper.map(artist)
        with(entity) {
            id shouldBe "artist-1"
            name shouldBe "Artist artist-1"
            artistType shouldBe "artist"
        }
    }

    private fun createMapper() = ArtistDataToEntityMapperImpl()
}
