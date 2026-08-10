package and.degilevich.dream.shared.feature.artist.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.test.model.simplifiedArtistObject
import and.degilevich.dream.shared.feature.artist.model.artifact.api.dictionary.ArtistType
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class SimplifiedArtistOutputToDataMapperImplTest {

    @Test
    fun `map - known type ARTIST - maps to ArtistType ARTIST`() {
        val result = createMapper().map(simplifiedArtistObject())
        result.artistType shouldBe ArtistType.ARTIST
    }

    @Test
    fun `map - scalar fields - copies id and name unchanged`() {
        val input = simplifiedArtistObject()
        val result = createMapper().map(input)
        with(result) {
            id.value shouldBe input.id
            name shouldBe input.name
        }
    }

    private fun createMapper() = SimplifiedArtistOutputToDataMapperImpl()
}
