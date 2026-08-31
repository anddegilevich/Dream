package and.degilevich.dream.shared.feature.playlist.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.test.model.imageObject
import and.degilevich.dream.shared.core.service.test.model.simplifiedPlaylistObject
import and.degilevich.dream.shared.feature.image.data.mapper.api.remote.ImageOutputToDataMapper
import and.degilevich.dream.shared.feature.image.data.mapper.test.remote.FakeImageOutputToDataMapper
import and.degilevich.dream.shared.feature.image.model.artifact.test.data.imageData
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class SimplifiedPlaylistOutputToDataMapperImplTest {

    @Test
    fun `map - scalar and nested fields - delegates to injected mapper and copies scalars`() {
        val imageData = imageData()
        val mapper = createMapper(
            imageOutputToDataMapper = FakeImageOutputToDataMapper(onMap = { imageData })
        )
        val input = simplifiedPlaylistObject(
            id = "playlist-1",
            name = "Playlist Name",
            description = "Playlist Description",
            totalTracks = 7,
            images = listOf(imageObject(), imageObject())
        )

        val result = mapper.map(input)

        with(result) {
            id.value shouldBe "playlist-1"
            name shouldBe "Playlist Name"
            description shouldBe "Playlist Description"
            totalTracks shouldBe 7
            images shouldBe listOf(imageData, imageData)
        }
    }

    @Test
    fun `map - null id name and description - maps to empty values`() {
        val input = simplifiedPlaylistObject(
            id = null,
            name = null,
            description = null,
            images = emptyList()
        )

        val result = createMapper().map(input)

        with(result) {
            id.value shouldBe ""
            name shouldBe ""
            description shouldBe ""
        }
    }

    @Test
    fun `map - null tracks ref total - maps totalTracks to zero`() {
        val input = simplifiedPlaylistObject(
            totalTracks = null,
            images = emptyList()
        )

        val result = createMapper().map(input)

        result.totalTracks shouldBe 0
    }

    @Test
    fun `map - null images - maps to empty list`() {
        val input = simplifiedPlaylistObject(images = null)

        val result = createMapper().map(input)

        result.images shouldBe emptyList()
    }

    private fun createMapper(
        imageOutputToDataMapper: ImageOutputToDataMapper = FakeImageOutputToDataMapper()
    ) = SimplifiedPlaylistOutputToDataMapperImpl(
        imageOutputToDataMapper = imageOutputToDataMapper
    )
}
