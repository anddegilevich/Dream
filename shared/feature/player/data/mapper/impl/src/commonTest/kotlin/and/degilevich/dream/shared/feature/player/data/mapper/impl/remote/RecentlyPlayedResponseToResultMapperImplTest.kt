package and.degilevich.dream.shared.feature.player.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.test.model.cursorPagingPlayHistoryObject
import and.degilevich.dream.shared.core.service.test.model.playHistoryObject
import and.degilevich.dream.shared.feature.player.data.mapper.api.remote.PlayHistoryOutputToDataMapper
import and.degilevich.dream.shared.feature.player.data.mapper.test.remote.FakePlayHistoryOutputToDataMapper
import and.degilevich.dream.shared.feature.player.model.core.test.data.playHistoryData
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class RecentlyPlayedResponseToResultMapperImplTest {

    @Test
    fun `map - play history - delegates every item to injected mapper preserving order`() {
        val first = playHistoryData(id = "track-1")
        val second = playHistoryData(id = "track-2")
        val firstOutput = playHistoryObject(playedAt = "2024-01-01T00:00:00Z")
        val secondOutput = playHistoryObject(playedAt = "2024-02-02T00:00:00Z")
        val mapper = createMapper(
            playHistoryOutputToDataMapper = FakePlayHistoryOutputToDataMapper(
                onMap = { output -> if (output === firstOutput) first else second }
            )
        )
        val input = cursorPagingPlayHistoryObject(items = listOf(firstOutput, secondOutput))

        val result = mapper.map(input)

        result.items shouldBe listOf(first, second)
    }

    @Test
    fun `map - same track played twice - keeps both entries`() {
        val played = playHistoryData(id = "track-1")
        val mapper = createMapper(
            playHistoryOutputToDataMapper = FakePlayHistoryOutputToDataMapper(onMap = { played })
        )
        val input = cursorPagingPlayHistoryObject(
            items = listOf(playHistoryObject(), playHistoryObject())
        )

        val result = mapper.map(input)

        result.items shouldBe listOf(played, played)
    }

    @Test
    fun `map - empty page - returns no items`() {
        val result = createMapper().map(cursorPagingPlayHistoryObject(items = emptyList()))

        result.items shouldBe emptyList()
    }

    @Test
    fun `map - null items - returns no items`() {
        val result = createMapper().map(cursorPagingPlayHistoryObject(items = null))

        result.items shouldBe emptyList()
    }

    private fun createMapper(
        playHistoryOutputToDataMapper: PlayHistoryOutputToDataMapper = FakePlayHistoryOutputToDataMapper()
    ) = RecentlyPlayedResponseToResultMapperImpl(
        playHistoryOutputToDataMapper = playHistoryOutputToDataMapper
    )
}
