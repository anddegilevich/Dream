package and.degilevich.dream.shared.feature.artist.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.test.model.artistObject
import and.degilevich.dream.shared.core.service.test.model.imageObject
import and.degilevich.dream.shared.feature.artist.model.artifact.api.dictionary.ArtistType
import and.degilevich.dream.shared.feature.image.data.mapper.api.remote.ImageOutputToDataMapper
import and.degilevich.dream.shared.feature.image.data.mapper.test.remote.FakeImageOutputToDataMapper
import and.degilevich.dream.shared.feature.image.model.artifact.test.data.imageData
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class ArtistOutputToDataMapperImplTest {

    @Test
    fun `map - known type ARTIST - maps to ArtistType ARTIST`() {
        val result = createMapper().map(artistObject())
        result.artistType shouldBe ArtistType.ARTIST
    }

    @Test
    fun `map - scalar and image fields - delegates to injected mapper and copies scalars`() {
        val imageData = imageData()
        val mapper = createMapper(
            imageOutputToDataMapper = FakeImageOutputToDataMapper(onMap = { imageData })
        )
        val input = artistObject(
            images = listOf(
                imageObject(),
                imageObject()
            )
        )
        val result = mapper.map(input)
        with(result) {
            id.value shouldBe input.id
            name shouldBe input.name
            images shouldBe listOf(imageData, imageData)
        }
    }

    private fun createMapper(
        imageOutputToDataMapper: ImageOutputToDataMapper = FakeImageOutputToDataMapper()
    ) = ArtistOutputToDataMapperImpl(
        imageOutputToDataMapper = imageOutputToDataMapper
    )
}
