package and.degilevich.dream.shared.feature.player.domain.impl.usecase

import and.degilevich.dream.shared.feature.player.data.test.repository.FakePlayerRepository
import and.degilevich.dream.shared.feature.player.model.core.api.method.getRecentlyPlayed.GetRecentlyPlayedParams
import and.degilevich.dream.shared.feature.player.model.core.api.method.getRecentlyPlayed.GetRecentlyPlayedResult
import and.degilevich.dream.shared.feature.player.model.core.test.data.playHistoryData
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertTrue

class GetRecentlyPlayedUseCaseImplTest {

    @Test
    fun `invoke - repository succeeds - returns its result unchanged`() = runTest {
        val expected = Result.success(
            GetRecentlyPlayedResult(
                items = listOf(
                    playHistoryData(id = "track-1"),
                    playHistoryData(id = "track-2")
                )
            )
        )
        val useCase = GetRecentlyPlayedUseCaseImpl(
            playerRepository = FakePlayerRepository(onGetRecentlyPlayed = { expected })
        )

        val result = useCase(GetRecentlyPlayedParams(limit = 10))

        result shouldBe expected
    }

    @Test
    fun `invoke - passes params through to repository unchanged`() = runTest {
        val receivedParams = mutableListOf<GetRecentlyPlayedParams>()
        val useCase = GetRecentlyPlayedUseCaseImpl(
            playerRepository = FakePlayerRepository(
                onGetRecentlyPlayed = { params ->
                    receivedParams.add(params)
                    Result.success(GetRecentlyPlayedResult(items = emptyList()))
                }
            )
        )
        val params = GetRecentlyPlayedParams(limit = 25)

        useCase(params)

        receivedParams shouldBe listOf(params)
    }

    @Test
    fun `invoke - repository fails - returns failure`() = runTest {
        val useCase = GetRecentlyPlayedUseCaseImpl(
            playerRepository = FakePlayerRepository(
                onGetRecentlyPlayed = { Result.failure(IllegalStateException("network is down")) }
            )
        )

        val result = useCase(GetRecentlyPlayedParams(limit = 10))

        assertTrue(result.isFailure)
    }

    @Test
    fun `invoke - repository returns no history - returns empty items`() = runTest {
        val useCase = GetRecentlyPlayedUseCaseImpl(
            playerRepository = FakePlayerRepository(
                onGetRecentlyPlayed = { Result.success(GetRecentlyPlayedResult(items = emptyList())) }
            )
        )

        val result = useCase(GetRecentlyPlayedParams(limit = 10))

        result.getOrNull()?.items shouldBe emptyList()
    }
}
