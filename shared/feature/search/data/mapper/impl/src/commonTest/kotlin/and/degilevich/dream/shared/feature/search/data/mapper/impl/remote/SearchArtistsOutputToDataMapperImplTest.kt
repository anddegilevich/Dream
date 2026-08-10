package and.degilevich.dream.shared.feature.search.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.test.model.artistObject
import and.degilevich.dream.shared.core.service.test.model.pagingArtistObject
import and.degilevich.dream.shared.feature.artist.data.mapper.api.remote.ArtistOutputToDataMapper
import and.degilevich.dream.shared.feature.artist.data.mapper.test.remote.FakeArtistOutputToDataMapper
import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class SearchArtistsOutputToDataMapperImplTest {

    @Test
    fun `map - paging response with items - wraps mapped items via injected mapper`() {
        val artistData = ArtistData.empty()
        val mapper = createMapper(
            artistOutputToDataMapper = FakeArtistOutputToDataMapper(onMap = { artistData })
        )
        val input = pagingArtistObject(items = listOf(artistObject(), artistObject()))
        val result = mapper.map(input)
        result.items shouldBe listOf(artistData, artistData)
    }

    @Test
    fun `map - paging response with no items - returns empty items list`() {
        val result = createMapper().map(pagingArtistObject(items = emptyList()))
        result.items shouldBe emptyList()
    }

    private fun createMapper(
        artistOutputToDataMapper: ArtistOutputToDataMapper = FakeArtistOutputToDataMapper()
    ) = SearchArtistsOutputToDataMapperImpl(
        artistOutputToDataMapper = artistOutputToDataMapper
    )
}
