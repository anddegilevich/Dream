package and.degilevich.dream.shared.feature.search.data.impl.repository

import and.degilevich.dream.shared.feature.search.data.impl.remote.FakeSearchRemoteDataSource
import and.degilevich.dream.shared.feature.search.model.core.api.dictionary.SearchType
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchParams
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchResult
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

class SearchRepositoryImplTest {

    @Test
    fun `search - delegates to remote data source and returns its result unchanged`() = runTest {
        val searchResult = Result.success(SearchResult.empty())
        val repository = SearchRepositoryImpl(
            searchRemoteDataSource = FakeSearchRemoteDataSource(onSearch = { searchResult })
        )
        val params = SearchParams(
            query = "query",
            limit = 10,
            offset = 0,
            types = listOf(SearchType.TRACK)
        )
        val result = repository.search(params)
        result shouldBe searchResult
    }
}
