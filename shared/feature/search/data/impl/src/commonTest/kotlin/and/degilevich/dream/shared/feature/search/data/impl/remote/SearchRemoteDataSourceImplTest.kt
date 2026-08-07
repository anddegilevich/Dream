package and.degilevich.dream.shared.feature.search.data.impl.remote

import and.degilevich.dream.shared.core.service.api.generated.api.SearchApi
import and.degilevich.dream.shared.core.service.api.generated.model.Search200Response
import and.degilevich.dream.shared.core.service.test.api.fakeSearchApi
import and.degilevich.dream.shared.core.service.test.model.search200Response
import and.degilevich.dream.shared.core.service.test.service.FakeApiService
import and.degilevich.dream.shared.feature.search.data.mapper.api.remote.SearchResponseToResultMapper
import and.degilevich.dream.shared.feature.search.data.mapper.api.remote.SearchTypeToRequestMapper
import and.degilevich.dream.shared.feature.search.data.mapper.test.remote.FakeSearchResponseToResultMapper
import and.degilevich.dream.shared.feature.search.data.mapper.test.remote.FakeSearchTypeToRequestMapper
import and.degilevich.dream.shared.feature.search.model.core.api.dictionary.SearchType
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchParams
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchResult
import io.kotest.matchers.shouldBe
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertTrue

class SearchRemoteDataSourceImplTest {

    @Test
    fun `search - successful response - returns mapped result via injected mapper`() = runTest {
        val searchResult = SearchResult.empty()
        val content = Json.encodeToString(
            serializer = Search200Response.serializer(),
            value = search200Response()
        )
        val dataSource = createDataSource(
            engine = respondingWith(content = content),
            searchResponseToResultMapper = FakeSearchResponseToResultMapper(onMap = { searchResult }),
            searchTypeToRequestMapper = FakeSearchTypeToRequestMapper(onMap = { SearchApi.TypeSearch.TRACK })
        )
        val params = SearchParams(
            query = "query",
            limit = 10,
            offset = 0,
            types = listOf(SearchType.TRACK)
        )
        val result = dataSource.search(params = params)
        assertTrue(result.isSuccess)
        result.getOrNull() shouldBe searchResult
    }

    @Test
    fun `search - response body cannot be deserialized - returns failure`() = runTest {
        val dataSource = createDataSource(
            engine = respondingWith(content = "not json"),
            searchTypeToRequestMapper = FakeSearchTypeToRequestMapper(onMap = { SearchApi.TypeSearch.TRACK })
        )
        val params = SearchParams(
            query = "query",
            limit = 10,
            offset = 0,
            types = listOf(SearchType.TRACK)
        )
        val result = dataSource.search(params = params)
        assertTrue(result.isFailure)
    }

    private fun createDataSource(
        engine: MockEngine,
        searchResponseToResultMapper: SearchResponseToResultMapper = FakeSearchResponseToResultMapper(),
        searchTypeToRequestMapper: SearchTypeToRequestMapper = FakeSearchTypeToRequestMapper()
    ): SearchRemoteDataSourceImpl {
        val apiService = FakeApiService(onSearchApi = { fakeSearchApi(engine = engine) })
        return SearchRemoteDataSourceImpl(
            apiService = apiService,
            searchResponseToResultMapper = searchResponseToResultMapper,
            searchTypeToRequestMapper = searchTypeToRequestMapper
        )
    }

    private fun respondingWith(content: String): MockEngine = MockEngine { _ ->
        respond(
            content = content,
            status = HttpStatusCode.OK,
            headers = headersOf(HttpHeaders.ContentType, "application/json")
        )
    }
}
