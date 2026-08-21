package and.degilevich.dream.shared.feature.artist.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.test.model.pagingArtistDiscographyAlbumObject
import and.degilevich.dream.shared.core.service.test.model.simplifiedAlbumObject
import and.degilevich.dream.shared.feature.album.data.mapper.api.remote.SimplifiedAlbumOutputToDataMapper
import and.degilevich.dream.shared.feature.album.data.mapper.test.remote.FakeSimplifiedAlbumOutputToDataMapper
import and.degilevich.dream.shared.feature.album.model.artifact.test.data.simplifiedAlbumData
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class GetArtistAlbumsResponseToResultMapperImplTest {

    @Test
    fun `map - paging response with items - wraps mapped items via injected mapper`() {
        val simplifiedAlbumData = simplifiedAlbumData(id = "album-1")
        val mapper = createMapper(
            simplifiedAlbumOutputToDataMapper = FakeSimplifiedAlbumOutputToDataMapper(
                onMap = { simplifiedAlbumData }
            )
        )
        val input = pagingArtistDiscographyAlbumObject(
            items = listOf(
                simplifiedAlbumObject(),
                simplifiedAlbumObject()
            )
        )
        val result = mapper.map(input)
        with(result) {
            total shouldBe input.total
            items shouldBe listOf(simplifiedAlbumData, simplifiedAlbumData)
        }
    }

    @Test
    fun `map - paging response with no items - returns empty items list`() {
        val result = createMapper().map(
            pagingArtistDiscographyAlbumObject(items = emptyList())
        )
        result.items shouldBe emptyList()
    }

    private fun createMapper(
        simplifiedAlbumOutputToDataMapper: SimplifiedAlbumOutputToDataMapper = FakeSimplifiedAlbumOutputToDataMapper()
    ) = GetArtistAlbumsResponseToResultMapperImpl(
        simplifiedAlbumOutputToDataMapper = simplifiedAlbumOutputToDataMapper
    )
}
