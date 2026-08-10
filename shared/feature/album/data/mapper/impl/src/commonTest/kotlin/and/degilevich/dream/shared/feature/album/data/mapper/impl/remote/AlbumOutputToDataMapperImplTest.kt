package and.degilevich.dream.shared.feature.album.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.api.generated.model.AlbumObject
import and.degilevich.dream.shared.core.service.api.generated.model.SimplifiedArtistObject
import and.degilevich.dream.shared.core.service.test.model.albumObject
import and.degilevich.dream.shared.core.service.test.model.imageObject
import and.degilevich.dream.shared.feature.album.data.mapper.api.remote.AlbumTracksOutputToDataMapper
import and.degilevich.dream.shared.feature.album.data.mapper.test.remote.FakeAlbumTracksOutputToDataMapper
import and.degilevich.dream.shared.feature.album.model.artifact.api.dictionary.AlbumType
import and.degilevich.dream.shared.feature.album.model.core.api.data.AlbumTracksData
import and.degilevich.dream.shared.feature.artist.data.mapper.api.remote.SimplifiedArtistOutputToDataMapper
import and.degilevich.dream.shared.feature.artist.data.mapper.test.remote.FakeSimplifiedArtistOutputToDataMapper
import and.degilevich.dream.shared.feature.artist.model.artifact.api.data.SimplifiedArtistData
import and.degilevich.dream.shared.feature.image.data.mapper.api.remote.ImageOutputToDataMapper
import and.degilevich.dream.shared.feature.image.data.mapper.test.remote.FakeImageOutputToDataMapper
import and.degilevich.dream.shared.feature.image.model.artifact.api.data.ImageData
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class AlbumOutputToDataMapperImplTest {

    @Test
    fun `map - known album type ALBUM - maps to AlbumType ALBUM`() {
        val result = createMapper().map(albumObject(albumType = AlbumObject.AlbumType.ALBUM))
        result.albumType shouldBe AlbumType.ALBUM
    }

    @Test
    fun `map - known album type SINGLE - maps to AlbumType SINGLE`() {
        val result = createMapper().map(albumObject(albumType = AlbumObject.AlbumType.SINGLE))
        result.albumType shouldBe AlbumType.SINGLE
    }

    @Test
    fun `map - known album type COMPILATION - maps to AlbumType COMPILATION`() {
        val result = createMapper().map(albumObject(albumType = AlbumObject.AlbumType.COMPILATION))
        result.albumType shouldBe AlbumType.COMPILATION
    }

    @Test
    fun `map - scalar and nested fields - delegates to injected mappers and copies scalars`() {
        val simplifiedArtistData = SimplifiedArtistData.empty()
        val imageData = ImageData.empty()
        val mapper = createMapper(
            simplifiedArtistOutputToDataMapper = FakeSimplifiedArtistOutputToDataMapper(
                onMap = { simplifiedArtistData }
            ),
            imageOutputToDataMapper = FakeImageOutputToDataMapper(onMap = { imageData })
        )
        val input = albumObject(
            albumType = AlbumObject.AlbumType.ALBUM,
            artists = listOf(SimplifiedArtistObject(), SimplifiedArtistObject()),
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
            tracks shouldBe AlbumTracksData.empty()
        }
    }

    private fun createMapper(
        simplifiedArtistOutputToDataMapper: SimplifiedArtistOutputToDataMapper =
            FakeSimplifiedArtistOutputToDataMapper(),
        imageOutputToDataMapper: ImageOutputToDataMapper = FakeImageOutputToDataMapper(),
        albumTracksOutputToDataMapper: AlbumTracksOutputToDataMapper = FakeAlbumTracksOutputToDataMapper(
            onMap = { AlbumTracksData.empty() }
        )
    ) = AlbumOutputToDataMapperImpl(
        simplifiedArtistOutputToDataMapper = simplifiedArtistOutputToDataMapper,
        imageOutputToDataMapper = imageOutputToDataMapper,
        albumTracksOutputToDataMapper = albumTracksOutputToDataMapper
    )
}
