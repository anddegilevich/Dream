package and.degilevich.dream.shared.feature.search.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.test.model.pagingSimplifiedAlbumObject
import and.degilevich.dream.shared.core.service.test.model.simplifiedAlbumObject
import and.degilevich.dream.shared.feature.album.data.mapper.api.remote.SimplifiedAlbumOutputToDataMapper
import and.degilevich.dream.shared.feature.album.data.mapper.test.remote.FakeSimplifiedAlbumOutputToDataMapper
import and.degilevich.dream.shared.feature.album.model.artifact.test.data.simplifiedAlbumData
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class SearchAlbumsOutputToDataMapperImplTest {

    @Test
    fun `map - paging response with items - wraps mapped items via injected mapper`() {
        val simplifiedAlbumData = simplifiedAlbumData(id = "album-1")
        val mapper = createMapper(
            simplifiedAlbumOutputToDataMapper = FakeSimplifiedAlbumOutputToDataMapper(
                onMap = { simplifiedAlbumData }
            )
        )
        val input = pagingSimplifiedAlbumObject(
            items = listOf(
                simplifiedAlbumObject(),
                simplifiedAlbumObject()
            )
        )
        val result = mapper.map(input)
        result.items shouldBe listOf(simplifiedAlbumData, simplifiedAlbumData)
    }

    @Test
    fun `map - paging response with total - copies total from the paging response`() {
        val result = createMapper().map(
            pagingSimplifiedAlbumObject(
                items = emptyList(),
                total = TOTAL_COUNT
            )
        )
        result.total shouldBe TOTAL_COUNT
    }

    @Test
    fun `map - paging response with no items - returns empty items list`() {
        val result = createMapper().map(pagingSimplifiedAlbumObject(items = emptyList()))
        result.items shouldBe emptyList()
    }

    private fun createMapper(
        simplifiedAlbumOutputToDataMapper: SimplifiedAlbumOutputToDataMapper = FakeSimplifiedAlbumOutputToDataMapper()
    ) = SearchAlbumsOutputToDataMapperImpl(
        simplifiedAlbumOutputToDataMapper = simplifiedAlbumOutputToDataMapper
    )

    private companion object {
        const val TOTAL_COUNT = 42
    }
}
