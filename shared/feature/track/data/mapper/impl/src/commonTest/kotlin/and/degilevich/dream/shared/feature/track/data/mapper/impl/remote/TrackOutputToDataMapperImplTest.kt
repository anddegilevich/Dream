package and.degilevich.dream.shared.feature.track.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.test.model.simplifiedAlbumObject
import and.degilevich.dream.shared.core.service.test.model.simplifiedArtistObject
import and.degilevich.dream.shared.core.service.test.model.trackObject
import and.degilevich.dream.shared.feature.album.data.mapper.api.remote.SimplifiedAlbumOutputToDataMapper
import and.degilevich.dream.shared.feature.album.data.mapper.test.remote.FakeSimplifiedAlbumOutputToDataMapper
import and.degilevich.dream.shared.feature.album.model.artifact.api.data.SimplifiedAlbumData
import and.degilevich.dream.shared.feature.album.model.artifact.test.data.simplifiedAlbumData
import and.degilevich.dream.shared.feature.artist.data.mapper.api.remote.SimplifiedArtistOutputToDataMapper
import and.degilevich.dream.shared.feature.artist.data.mapper.test.remote.FakeSimplifiedArtistOutputToDataMapper
import and.degilevich.dream.shared.feature.artist.model.artifact.test.data.simplifiedArtistData
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class TrackOutputToDataMapperImplTest {

    @Test
    fun `map - scalar and nested fields - delegates to injected mappers and copies scalars`() {
        val simplifiedAlbumData = simplifiedAlbumData(id = "album-1")
        val simplifiedArtistData = simplifiedArtistData(id = "artist-1")
        val mapper = createMapper(
            simplifiedAlbumOutputToDataMapper = FakeSimplifiedAlbumOutputToDataMapper(
                onMap = { simplifiedAlbumData }
            ),
            simplifiedArtistOutputToDataMapper = FakeSimplifiedArtistOutputToDataMapper(
                onMap = { simplifiedArtistData }
            )
        )
        val input = trackObject(
            album = simplifiedAlbumObject(),
            artists = listOf(simplifiedArtistObject(), simplifiedArtistObject())
        )
        val result = mapper.map(input)
        with(result) {
            id.value shouldBe input.id
            name shouldBe input.name
            trackNumber shouldBe input.trackNumber
            durationMs shouldBe input.durationMs
            album shouldBe simplifiedAlbumData
            artists shouldBe listOf(simplifiedArtistData, simplifiedArtistData)
        }
    }

    @Test
    fun `map - no album - falls back to empty album`() {
        val result = createMapper().map(trackObject(album = null))
        result.album shouldBe SimplifiedAlbumData.empty()
    }

    private fun createMapper(
        simplifiedAlbumOutputToDataMapper: SimplifiedAlbumOutputToDataMapper = FakeSimplifiedAlbumOutputToDataMapper(),
        simplifiedArtistOutputToDataMapper: SimplifiedArtistOutputToDataMapper =
            FakeSimplifiedArtistOutputToDataMapper()
    ) = TrackOutputToDataMapperImpl(
        simplifiedAlbumOutputToDataMapper = simplifiedAlbumOutputToDataMapper,
        simplifiedArtistOutputToDataMapper = simplifiedArtistOutputToDataMapper
    )
}
