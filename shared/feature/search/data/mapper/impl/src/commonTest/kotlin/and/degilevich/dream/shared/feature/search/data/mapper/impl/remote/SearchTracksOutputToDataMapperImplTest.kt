package and.degilevich.dream.shared.feature.search.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.test.model.pagingTrackObject
import and.degilevich.dream.shared.core.service.test.model.trackObject
import and.degilevich.dream.shared.feature.track.data.mapper.api.remote.TrackOutputToDataMapper
import and.degilevich.dream.shared.feature.track.data.mapper.test.remote.FakeTrackOutputToDataMapper
import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class SearchTracksOutputToDataMapperImplTest {

    @Test
    fun `map - paging response with items - wraps mapped items via injected mapper`() {
        val trackData = TrackData.empty()
        val mapper = createMapper(
            trackOutputToDataMapper = FakeTrackOutputToDataMapper(onMap = { trackData })
        )
        val input = pagingTrackObject(
            items = listOf(
                trackObject(),
                trackObject()
            )
        )
        val result = mapper.map(input)
        result.items shouldBe listOf(trackData, trackData)
    }

    @Test
    fun `map - paging response with total - copies total from the paging response`() {
        val result = createMapper().map(
            pagingTrackObject(
                items = emptyList(),
                total = TOTAL_COUNT
            )
        )
        result.total shouldBe TOTAL_COUNT
    }

    @Test
    fun `map - paging response with no items - returns empty items list`() {
        val result = createMapper().map(
            pagingTrackObject(items = emptyList())
        )
        result.items shouldBe emptyList()
    }

    private fun createMapper(
        trackOutputToDataMapper: TrackOutputToDataMapper = FakeTrackOutputToDataMapper()
    ) = SearchTracksOutputToDataMapperImpl(
        trackOutputToDataMapper = trackOutputToDataMapper
    )

    private companion object {
        const val TOTAL_COUNT = 42
    }
}
