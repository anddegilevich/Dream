package and.degilevich.dream.shared.feature.player.data.impl.repository

import and.degilevich.dream.shared.feature.player.data.impl.remote.FakePlayerRemoteDataSource
import and.degilevich.dream.shared.feature.player.domain.model.core.api.method.getPlaybackState.GetPlaybackStateResult
import and.degilevich.dream.shared.feature.player.domain.model.core.api.method.getRecentlyPlayed.GetRecentlyPlayedParams
import and.degilevich.dream.shared.feature.player.domain.model.core.api.method.getRecentlyPlayed.GetRecentlyPlayedResult
import and.degilevich.dream.shared.feature.player.domain.model.core.api.method.setShuffle.SetShuffleParams
import and.degilevich.dream.shared.feature.player.domain.model.core.test.data.playHistoryData
import and.degilevich.dream.shared.feature.player.domain.model.core.test.data.playbackStateData
import io.kotest.matchers.shouldBe
import kotlin.test.Test
import kotlinx.coroutines.test.runTest

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

    @Test
    fun `getPlaybackState - delegates to remote data source and returns its result unchanged`() = runTest {
        val expected = Result.success<GetPlaybackStateResult>(
            GetPlaybackStateResult.Value(playbackState = playbackStateData())
        )
        val repository = PlayerRepositoryImpl(
            playerRemoteDataSource = FakePlayerRemoteDataSource(onGetPlaybackState = { expected })
        )

        val result = repository.getPlaybackState()

        result shouldBe expected
    }

    @Test
    fun `getPlaybackState - remote data source fails - propagates the failure unchanged`() = runTest {
        val expected = Result.failure<GetPlaybackStateResult>(IllegalStateException("network is down"))
        val repository = PlayerRepositoryImpl(
            playerRemoteDataSource = FakePlayerRemoteDataSource(onGetPlaybackState = { expected })
        )

        val result = repository.getPlaybackState()

        result shouldBe expected
    }

    @Test
    fun `skipToNext - delegates to remote data source and returns its result unchanged`() = runTest {
        val expected = Result.failure<Unit>(IllegalStateException("premium required"))
        val repository = PlayerRepositoryImpl(
            playerRemoteDataSource = FakePlayerRemoteDataSource(onSkipToNext = { expected })
        )

        val result = repository.skipToNext()

        result shouldBe expected
    }

    @Test
    fun `skipToPrevious - delegates to remote data source and returns its result unchanged`() = runTest {
        val expected = Result.failure<Unit>(IllegalStateException("premium required"))
        val repository = PlayerRepositoryImpl(
            playerRemoteDataSource = FakePlayerRemoteDataSource(onSkipToPrevious = { expected })
        )

        val result = repository.skipToPrevious()

        result shouldBe expected
    }

    @Test
    fun `setShuffle - passes params through to remote data source and returns its result unchanged`() = runTest {
        val receivedParams = mutableListOf<SetShuffleParams>()
        val expected = Result.success(Unit)
        val repository = PlayerRepositoryImpl(
            playerRemoteDataSource = FakePlayerRemoteDataSource(
                onSetShuffle = { params ->
                    receivedParams.add(params)
                    expected
                }
            )
        )
        val params = SetShuffleParams(isEnabled = true)

        val result = repository.setShuffle(params = params)

        result shouldBe expected
        receivedParams shouldBe listOf(params)
    }
}
