package and.degilevich.dream.shared.feature.album.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.api.generated.model.SimplifiedTrackObject
import and.degilevich.dream.shared.core.service.test.model.pagingSimplifiedTrackObject
import and.degilevich.dream.shared.feature.track.data.mapper.api.remote.SimplifiedTrackOutputToDataMapper
import and.degilevich.dream.shared.feature.track.data.mapper.test.remote.FakeSimplifiedTrackOutputToDataMapper
import and.degilevich.dream.shared.feature.track.model.artifact.api.data.SimplifiedTrackData
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class AlbumTracksOutputToDataMapperImplTest {

    @Test
    fun `map - paging response with items - wraps mapped items via injected mapper`() {
        val simplifiedTrackData = SimplifiedTrackData.empty()
        val mapper = createMapper(
            simplifiedTrackOutputToDataMapper = FakeSimplifiedTrackOutputToDataMapper(onMap = { simplifiedTrackData })
        )
        val input = pagingSimplifiedTrackObject(
            items = listOf(
                SimplifiedTrackObject(),
                SimplifiedTrackObject()
            )
        )
        val result = mapper.map(input)
        result.items shouldBe listOf(simplifiedTrackData, simplifiedTrackData)
    }

    @Test
    fun `map - paging response with no items - returns empty items list`() {
        val result = createMapper().map(
            pagingSimplifiedTrackObject(items = emptyList())
        )
        result.items shouldBe emptyList()
    }

    private fun createMapper(
        simplifiedTrackOutputToDataMapper: SimplifiedTrackOutputToDataMapper = FakeSimplifiedTrackOutputToDataMapper()
    ) = AlbumTracksOutputToDataMapperImpl(
        simplifiedTrackOutputToDataMapper = simplifiedTrackOutputToDataMapper
    )
}
