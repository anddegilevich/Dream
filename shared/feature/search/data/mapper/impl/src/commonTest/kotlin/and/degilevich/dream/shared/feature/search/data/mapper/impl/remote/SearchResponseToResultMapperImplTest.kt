package and.degilevich.dream.shared.feature.search.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.test.model.search200Response
import and.degilevich.dream.shared.feature.search.data.mapper.api.remote.SearchAlbumsOutputToDataMapper
import and.degilevich.dream.shared.feature.search.data.mapper.api.remote.SearchArtistsOutputToDataMapper
import and.degilevich.dream.shared.feature.search.data.mapper.api.remote.SearchTracksOutputToDataMapper
import and.degilevich.dream.shared.feature.search.data.mapper.test.remote.FakeSearchAlbumsOutputToDataMapper
import and.degilevich.dream.shared.feature.search.data.mapper.test.remote.FakeSearchArtistsOutputToDataMapper
import and.degilevich.dream.shared.feature.search.data.mapper.test.remote.FakeSearchTracksOutputToDataMapper
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchAlbumsData
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchArtistsData
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchTracksData
import and.degilevich.dream.shared.feature.search.model.core.test.method.search.searchAlbumsData
import and.degilevich.dream.shared.feature.search.model.core.test.method.search.searchArtistsData
import and.degilevich.dream.shared.feature.search.model.core.test.method.search.searchTracksData
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class SearchResponseToResultMapperImplTest {

    @Test
    fun `map - all sections present - delegates each section to its injected mapper`() {
        val tracksData = searchTracksData()
        val artistsData = searchArtistsData()
        val albumsData = searchAlbumsData()
        val mapper = createMapper(
            searchTracksOutputToDataMapper = FakeSearchTracksOutputToDataMapper(onMap = { tracksData }),
            searchArtistsOutputToDataMapper = FakeSearchArtistsOutputToDataMapper(onMap = { artistsData }),
            searchAlbumsOutputToDataMapper = FakeSearchAlbumsOutputToDataMapper(onMap = { albumsData })
        )
        val result = mapper.map(search200Response())
        with(result) {
            tracks shouldBe tracksData
            artists shouldBe artistsData
            albums shouldBe albumsData
        }
    }

    @Test
    fun `map - no sections present - falls back to empty for each section`() {
        val result = createMapper().map(search200Response(tracks = null, artists = null, albums = null))
        with(result) {
            tracks shouldBe SearchTracksData.empty()
            artists shouldBe SearchArtistsData.empty()
            albums shouldBe SearchAlbumsData.empty()
        }
    }

    private fun createMapper(
        searchTracksOutputToDataMapper: SearchTracksOutputToDataMapper = FakeSearchTracksOutputToDataMapper(),
        searchArtistsOutputToDataMapper: SearchArtistsOutputToDataMapper = FakeSearchArtistsOutputToDataMapper(),
        searchAlbumsOutputToDataMapper: SearchAlbumsOutputToDataMapper = FakeSearchAlbumsOutputToDataMapper()
    ) = SearchResponseToResultMapperImpl(
        searchTracksOutputToDataMapper = searchTracksOutputToDataMapper,
        searchArtistsOutputToDataMapper = searchArtistsOutputToDataMapper,
        searchAlbumsOutputToDataMapper = searchAlbumsOutputToDataMapper
    )
}
