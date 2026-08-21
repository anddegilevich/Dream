package and.degilevich.dream.shared.feature.search.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.api.generated.api.SearchApi
import and.degilevich.dream.shared.feature.search.model.core.api.dictionary.SearchType
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class SearchTypeToRequestMapperImplTest {

    @Test
    fun `map - ALBUM - maps to TypeSearch ALBUM`() {
        createMapper().map(SearchType.ALBUM) shouldBe SearchApi.TypeSearch.ALBUM
    }

    @Test
    fun `map - ARTIST - maps to TypeSearch ARTIST`() {
        createMapper().map(SearchType.ARTIST) shouldBe SearchApi.TypeSearch.ARTIST
    }

    @Test
    fun `map - PLAYLIST - maps to TypeSearch PLAYLIST`() {
        createMapper().map(SearchType.PLAYLIST) shouldBe SearchApi.TypeSearch.PLAYLIST
    }

    @Test
    fun `map - TRACK - maps to TypeSearch TRACK`() {
        createMapper().map(SearchType.TRACK) shouldBe SearchApi.TypeSearch.TRACK
    }

    @Test
    fun `map - SHOW - maps to TypeSearch SHOW`() {
        createMapper().map(SearchType.SHOW) shouldBe SearchApi.TypeSearch.SHOW
    }

    @Test
    fun `map - EPISODE - maps to TypeSearch EPISODE`() {
        createMapper().map(SearchType.EPISODE) shouldBe SearchApi.TypeSearch.EPISODE
    }

    @Test
    fun `map - AUDIOBOOK - maps to TypeSearch AUDIOBOOK`() {
        createMapper().map(SearchType.AUDIOBOOK) shouldBe SearchApi.TypeSearch.AUDIOBOOK
    }

    private fun createMapper() = SearchTypeToRequestMapperImpl()
}
