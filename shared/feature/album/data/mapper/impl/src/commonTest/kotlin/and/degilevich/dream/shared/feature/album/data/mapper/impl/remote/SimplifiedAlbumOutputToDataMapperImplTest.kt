package and.degilevich.dream.shared.feature.album.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.api.generated.model.SimplifiedAlbumObject
import and.degilevich.dream.shared.core.service.test.model.imageObject
import and.degilevich.dream.shared.core.service.test.model.simplifiedAlbumObject
import and.degilevich.dream.shared.core.service.test.model.simplifiedArtistObject
import and.degilevich.dream.shared.feature.album.model.artifact.api.dictionary.AlbumType
import and.degilevich.dream.shared.feature.artist.data.mapper.api.remote.SimplifiedArtistOutputToDataMapper
import and.degilevich.dream.shared.feature.artist.data.mapper.test.remote.FakeSimplifiedArtistOutputToDataMapper
import and.degilevich.dream.shared.feature.artist.model.artifact.test.data.simplifiedArtistData
import and.degilevich.dream.shared.feature.image.data.mapper.api.remote.ImageOutputToDataMapper
import and.degilevich.dream.shared.feature.image.data.mapper.test.remote.FakeImageOutputToDataMapper
import and.degilevich.dream.shared.feature.image.model.artifact.test.data.imageData
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class SimplifiedAlbumOutputToDataMapperImplTest {

    @Test
    fun `map - known album type ALBUM - maps to AlbumType ALBUM`() {
        val result = createMapper().map(
            simplifiedAlbumObject(albumType = SimplifiedAlbumObject.AlbumType.ALBUM)
        )
        result.albumType shouldBe AlbumType.ALBUM
    }

    @Test
    fun `map - known album type SINGLE - maps to AlbumType SINGLE`() {
        val result = createMapper().map(
            simplifiedAlbumObject(albumType = SimplifiedAlbumObject.AlbumType.SINGLE)
        )
        result.albumType shouldBe AlbumType.SINGLE
    }

    @Test
    fun `map - known album type COMPILATION - maps to AlbumType COMPILATION`() {
        val result = createMapper().map(
            simplifiedAlbumObject(albumType = SimplifiedAlbumObject.AlbumType.COMPILATION)
        )
        result.albumType shouldBe AlbumType.COMPILATION
    }

    @Test
    fun `map - scalar and nested fields - delegates to injected mappers and copies scalars`() {
        val simplifiedArtistData = simplifiedArtistData()
        val imageData = imageData()
        val mapper = createMapper(
            simplifiedArtistOutputToDataMapper = FakeSimplifiedArtistOutputToDataMapper(
                onMap = { simplifiedArtistData }
            ),
            imageOutputToDataMapper = FakeImageOutputToDataMapper(onMap = { imageData })
        )
        val input = simplifiedAlbumObject(
            albumType = SimplifiedAlbumObject.AlbumType.ALBUM,
            artists = listOf(simplifiedArtistObject(), simplifiedArtistObject()),
            images = listOf(imageObject())
        )
        val result = mapper.map(input)
        with(result) {
            id.value shouldBe input.id
            name shouldBe input.name
            totalTracks shouldBe input.totalTracks
            releaseDate shouldBe input.releaseDate
            artists shouldBe listOf(simplifiedArtistData, simplifiedArtistData)
            images shouldBe listOf(imageData)
        }
    }

    private fun createMapper(
        simplifiedArtistOutputToDataMapper: SimplifiedArtistOutputToDataMapper =
            FakeSimplifiedArtistOutputToDataMapper(),
        imageOutputToDataMapper: ImageOutputToDataMapper = FakeImageOutputToDataMapper()
    ) = SimplifiedAlbumOutputToDataMapperImpl(
        simplifiedArtistOutputToDataMapper = simplifiedArtistOutputToDataMapper,
        imageOutputToDataMapper = imageOutputToDataMapper
    )
}
