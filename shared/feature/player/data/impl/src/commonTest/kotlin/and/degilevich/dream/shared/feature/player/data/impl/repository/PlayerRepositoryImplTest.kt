package and.degilevich.dream.shared.feature.player.data.impl.repository

import and.degilevich.dream.shared.feature.player.data.impl.remote.FakePlayerRemoteDataSource
import and.degilevich.dream.shared.feature.player.model.core.api.method.getRecentlyPlayed.GetRecentlyPlayedParams
import and.degilevich.dream.shared.feature.player.model.core.api.method.getRecentlyPlayed.GetRecentlyPlayedResult
import and.degilevich.dream.shared.feature.player.model.core.test.data.playHistoryData
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

class PlayerRepositoryImplTest {

    @Test
    fun `getRecentlyPlayed - delegates to remote data source and returns its result unchanged`() = runTest {
        val expected = Result.success(
            GetRecentlyPlayedResult(items = listOf(playHistoryData(id = "track-1")))
        )
        val repository = PlayerRepositoryImpl(
            playerRemoteDataSource = FakePlayerRemoteDataSource(onGetRecentlyPlayed = { expected })
        )

        val result = repository.getRecentlyPlayed(params = GetRecentlyPlayedParams(limit = 10))

        result shouldBe expected
    }

    @Test
    fun `getRecentlyPlayed - passes params through to remote data source unchanged`() = runTest {
        val receivedParams = mutableListOf<GetRecentlyPlayedParams>()
        val repository = PlayerRepositoryImpl(
            playerRemoteDataSource = FakePlayerRemoteDataSource(
                onGetRecentlyPlayed = { params ->
                    receivedParams.add(params)
                    Result.success(GetRecentlyPlayedResult(items = emptyList()))
                }
            )
        )
        val params = GetRecentlyPlayedParams(limit = 25)

        repository.getRecentlyPlayed(params = params)

        receivedParams shouldBe listOf(params)
    }

    @Test
    fun `getRecentlyPlayed - remote data source fails - propagates the failure unchanged`() = runTest {
        val expected = Result.failure<GetRecentlyPlayedResult>(IllegalStateException("network is down"))
        val repository = PlayerRepositoryImpl(
            playerRemoteDataSource = FakePlayerRemoteDataSource(onGetRecentlyPlayed = { expected })
        )

        val result = repository.getRecentlyPlayed(params = GetRecentlyPlayedParams(limit = 10))

        result shouldBe expected
    }
}
