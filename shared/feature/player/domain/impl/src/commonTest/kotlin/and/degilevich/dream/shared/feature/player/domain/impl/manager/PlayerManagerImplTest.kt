package and.degilevich.dream.shared.feature.player.domain.impl.manager

import and.degilevich.dream.shared.feature.player.data.api.repository.PlayerRepository
import and.degilevich.dream.shared.feature.player.data.test.repository.FakePlayerRepository
import and.degilevich.dream.shared.feature.player.domain.model.core.api.data.PlaybackStateData
import and.degilevich.dream.shared.feature.player.domain.model.core.api.data.PlayerStateData
import and.degilevich.dream.shared.feature.player.domain.model.core.api.method.getPlaybackState.GetPlaybackStateResult
import and.degilevich.dream.shared.feature.player.domain.model.core.api.method.setShuffle.SetShuffleParams
import and.degilevich.dream.shared.feature.player.domain.model.core.test.data.playbackStateData
import and.degilevich.dream.shared.feature.track.domain.model.core.test.data.trackData
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

class PlayerManagerImplTest {

    @Test
    fun `playerState - no collectors - stays idle without fetching`() = runTest {
        val manager = createManager()

        advance(10.seconds)

        manager.playerState.first() shouldBe PlayerStateData.Idle
    }

    @Test
    fun `playerState - first collector - fetches immediately and emits active state`() = runTest {
        val playbackState = playbackStateData(isPlaying = false)
        val values = mutableListOf<PlayerStateData>()
        val manager = createManager(
            playerRepository = FakePlayerRepository(onGetPlaybackState = { value(playbackState) })
        )

        collect(manager = manager, into = values)
        runCurrent()

        values.last() shouldBe PlayerStateData.Active(playbackState = playbackState)
    }

    @Test
    fun `playerState - late collector - receives the current state immediately without an extra fetch`() = runTest {
        var invocationCount = 0
        val playbackState = playbackStateData(isPlaying = false)
        val lateValues = mutableListOf<PlayerStateData>()
        val manager = createManager(
            playerRepository = FakePlayerRepository(
                onGetPlaybackState = {
                    invocationCount++
                    value(playbackState)
                }
            )
        )

        collect(manager = manager)
        runCurrent()
        collect(manager = manager, into = lateValues)
        runCurrent()

        lateValues.first() shouldBe PlayerStateData.Active(playbackState = playbackState)
        invocationCount shouldBe 1
    }

    @Test
    fun `playerState - two collectors - share a single polling loop`() = runTest {
        var invocationCount = 0
        val manager = createManager(
            playerRepository = FakePlayerRepository(
                onGetPlaybackState = {
                    invocationCount++
                    value(playbackStateData(isPlaying = false))
                }
            )
        )

        collect(manager = manager)
        collect(manager = manager)
        runCurrent()
        val afterSubscribe = invocationCount
        advance(3.seconds)

        afterSubscribe shouldBe 1
        invocationCount shouldBe 2
    }

    @Test
    fun `playerState - polling collector cancelled while another collects - polling continues`() = runTest {
        var invocationCount = 0
        val remainingValues = mutableListOf<PlayerStateData>()
        val manager = createManager(
            playerRepository = FakePlayerRepository(
                onGetPlaybackState = {
                    invocationCount++
                    value(playbackStateData(isPlaying = false, progressMs = invocationCount * 1000))
                }
            )
        )

        val first = collect(manager = manager)
        runCurrent()
        collect(manager = manager, into = remainingValues)
        runCurrent()
        first.cancel()
        runCurrent()
        val countAfterCancel = invocationCount
        advance(3.seconds)

        (invocationCount > countAfterCancel) shouldBe true
        remainingValues.last().progressMs() shouldBe invocationCount * 1000
    }

    @Test
    fun `playerState - all collectors cancelled - stops polling`() = runTest {
        var invocationCount = 0
        val manager = createManager(
            playerRepository = FakePlayerRepository(
                onGetPlaybackState = {
                    invocationCount++
                    value(playbackStateData(isPlaying = false))
                }
            )
        )

        val first = collect(manager = manager)
        val second = collect(manager = manager)
        runCurrent()
        first.cancel()
        second.cancel()
        runCurrent()
        val countAfterCancel = invocationCount
        advance(10.seconds)

        countAfterCancel shouldBe 1
        invocationCount shouldBe countAfterCancel
    }

    @Test
    fun `playerState - while collected - polls every 3 seconds`() = runTest {
        var invocationCount = 0
        val manager = createManager(
            playerRepository = FakePlayerRepository(
                onGetPlaybackState = {
                    invocationCount++
                    value(playbackStateData(isPlaying = false))
                }
            )
        )

        collect(manager = manager)
        runCurrent()
        val afterSubscribe = invocationCount
        advance(3.seconds)
        val afterFirstInterval = invocationCount
        advance(3.seconds)

        afterSubscribe shouldBe 1
        afterFirstInterval shouldBe 2
        invocationCount shouldBe 3
    }

    @Test
    fun `playerState - playback stops between polls - emits idle`() = runTest {
        var invocationCount = 0
        val values = mutableListOf<PlayerStateData>()
        val manager = createManager(
            playerRepository = FakePlayerRepository(
                onGetPlaybackState = {
                    invocationCount++
                    if (invocationCount == 1) {
                        value(playbackStateData(isPlaying = false))
                    } else {
                        Result.success(GetPlaybackStateResult.None)
                    }
                }
            )
        )

        collect(manager = manager, into = values)
        runCurrent()
        advance(3.seconds)

        values.last() shouldBe PlayerStateData.Idle
    }

    @Test
    fun `playerState - poll fails - keeps the last known state`() = runTest {
        var invocationCount = 0
        val playbackState = playbackStateData(isPlaying = false)
        val values = mutableListOf<PlayerStateData>()
        val manager = createManager(
            playerRepository = FakePlayerRepository(
                onGetPlaybackState = {
                    invocationCount++
                    if (invocationCount == 1) {
                        value(playbackState)
                    } else {
                        Result.failure(IllegalStateException("network is down"))
                    }
                }
            )
        )

        collect(manager = manager, into = values)
        runCurrent()
        advance(3.seconds)

        invocationCount shouldBe 2
        values.last() shouldBe PlayerStateData.Active(playbackState = playbackState)
    }

    @Test
    fun `playerState - playing - advances progress every second between polls`() = runTest {
        val values = mutableListOf<PlayerStateData>()
        val manager = createManager(
            playerRepository = FakePlayerRepository(
                onGetPlaybackState = { value(playing(progressMs = 20000, durationMs = 200000)) }
            )
        )

        collect(manager = manager, into = values)
        runCurrent()
        advance(1.seconds)
        val afterOneSecond = values.last().progressMs()
        advance(1.seconds)

        afterOneSecond shouldBe 21000
        values.last().progressMs() shouldBe 22000
    }

    @Test
    fun `playerState - paused - does not advance progress`() = runTest {
        val values = mutableListOf<PlayerStateData>()
        val manager = createManager(
            playerRepository = FakePlayerRepository(
                onGetPlaybackState = { value(playbackStateData(isPlaying = false, progressMs = 20000)) }
            )
        )

        collect(manager = manager, into = values)
        runCurrent()
        advance(2.seconds)

        values.last().progressMs() shouldBe 20000
    }

    @Test
    fun `playerState - progress reaches track duration - stops at the duration`() = runTest {
        val values = mutableListOf<PlayerStateData>()
        val manager = createManager(
            playerRepository = FakePlayerRepository(
                onGetPlaybackState = { value(playing(progressMs = 79500, durationMs = 80000)) }
            )
        )

        collect(manager = manager, into = values)
        runCurrent()
        advance(2.seconds)

        values.last().progressMs() shouldBe 80000
    }

    @Test
    fun `skipToNext - repository succeeds - returns success and fetches the player state`() = runTest {
        val nextTrackState = playbackStateData(trackId = "next-track", isPlaying = false)
        val manager = createManager(
            playerRepository = FakePlayerRepository(
                onGetPlaybackState = { value(nextTrackState) },
                onSkipToNext = { Result.success(Unit) }
            )
        )

        val result = manager.skipToNext()

        result shouldBe Result.success(Unit)
        manager.playerState.first() shouldBe PlayerStateData.Active(playbackState = nextTrackState)
    }

    @Test
    fun `skipToNext - repository fails - returns the failure without fetching the player state`() = runTest {
        val expected = Result.failure<Unit>(IllegalStateException("premium required"))
        val manager = createManager(
            playerRepository = FakePlayerRepository(onSkipToNext = { expected })
        )

        val result = manager.skipToNext()

        result shouldBe expected
        manager.playerState.first() shouldBe PlayerStateData.Idle
    }

    @Test
    fun `skipToNext - fetch after the command fails - still returns success`() = runTest {
        val manager = createManager(
            playerRepository = FakePlayerRepository(
                onGetPlaybackState = { Result.failure(IllegalStateException("network is down")) },
                onSkipToNext = { Result.success(Unit) }
            )
        )

        val result = manager.skipToNext()

        result shouldBe Result.success(Unit)
        manager.playerState.first() shouldBe PlayerStateData.Idle
    }

    @Test
    fun `skipToPrevious - repository succeeds - returns success and fetches the player state`() = runTest {
        val previousTrackState = playbackStateData(trackId = "previous-track", isPlaying = false)
        val manager = createManager(
            playerRepository = FakePlayerRepository(
                onGetPlaybackState = { value(previousTrackState) },
                onSkipToPrevious = { Result.success(Unit) }
            )
        )

        val result = manager.skipToPrevious()

        result shouldBe Result.success(Unit)
        manager.playerState.first() shouldBe PlayerStateData.Active(playbackState = previousTrackState)
    }

    @Test
    fun `skipToPrevious - repository fails - returns the failure without fetching the player state`() = runTest {
        val expected = Result.failure<Unit>(IllegalStateException("premium required"))
        val manager = createManager(
            playerRepository = FakePlayerRepository(onSkipToPrevious = { expected })
        )

        val result = manager.skipToPrevious()

        result shouldBe expected
        manager.playerState.first() shouldBe PlayerStateData.Idle
    }

    @Test
    fun `setShuffle - repository succeeds - passes params through and fetches the player state`() = runTest {
        val receivedParams = mutableListOf<SetShuffleParams>()
        val shuffledState = playbackStateData(isPlaying = false, isShuffling = true)
        val manager = createManager(
            playerRepository = FakePlayerRepository(
                onGetPlaybackState = { value(shuffledState) },
                onSetShuffle = { params ->
                    receivedParams.add(params)
                    Result.success(Unit)
                }
            )
        )
        val params = SetShuffleParams(isEnabled = true)

        val result = manager.setShuffle(params = params)

        result shouldBe Result.success(Unit)
        receivedParams shouldBe listOf(params)
        manager.playerState.first() shouldBe PlayerStateData.Active(playbackState = shuffledState)
    }

    @Test
    fun `setShuffle - repository fails - returns the failure without fetching the player state`() = runTest {
        val expected = Result.failure<Unit>(IllegalStateException("premium required"))
        val manager = createManager(
            playerRepository = FakePlayerRepository(onSetShuffle = { expected })
        )

        val result = manager.setShuffle(params = SetShuffleParams(isEnabled = true))

        result shouldBe expected
        manager.playerState.first() shouldBe PlayerStateData.Idle
    }

    @Test
    fun `pause - repository succeeds - returns success and fetches the player state`() = runTest {
        val fetchedState = playbackStateData(trackId = "track", isPlaying = false)
        val manager = createManager(
            playerRepository = FakePlayerRepository(
                onGetPlaybackState = { value(fetchedState) },
                onPause = { Result.success(Unit) }
            )
        )

        val result = manager.pause()

        result shouldBe Result.success(Unit)
        manager.playerState.first() shouldBe PlayerStateData.Active(playbackState = fetchedState)
    }

    @Test
    fun `pause - repository fails - returns the failure without fetching the player state`() = runTest {
        val expected = Result.failure<Unit>(IllegalStateException("premium required"))
        val manager = createManager(
            playerRepository = FakePlayerRepository(onPause = { expected })
        )

        val result = manager.pause()

        result shouldBe expected
        manager.playerState.first() shouldBe PlayerStateData.Idle
    }

    @Test
    fun `resume - repository succeeds - returns success and fetches the player state`() = runTest {
        val fetchedState = playbackStateData(trackId = "track", isPlaying = true)
        val manager = createManager(
            playerRepository = FakePlayerRepository(
                onGetPlaybackState = { value(fetchedState) },
                onResume = { Result.success(Unit) }
            )
        )

        val result = manager.resume()

        result shouldBe Result.success(Unit)
        manager.playerState.first() shouldBe PlayerStateData.Active(playbackState = fetchedState)
    }

    @Test
    fun `resume - repository fails - returns the failure without fetching the player state`() = runTest {
        val expected = Result.failure<Unit>(IllegalStateException("premium required"))
        val manager = createManager(
            playerRepository = FakePlayerRepository(onResume = { expected })
        )

        val result = manager.resume()

        result shouldBe expected
        manager.playerState.first() shouldBe PlayerStateData.Idle
    }

    @Test
    fun `skipToNext - repository succeeds while active - resets progress locally before fetching`() = runTest {
        var fetchCount = 0
        val initialState = playbackStateData(trackId = "track", isPlaying = true, progressMs = 20000)
        val values = mutableListOf<PlayerStateData>()
        val manager = createManager(
            playerRepository = FakePlayerRepository(
                onGetPlaybackState = {
                    fetchCount++
                    value(if (fetchCount == 1) initialState else playbackStateData(trackId = "fetched"))
                },
                onSkipToNext = { Result.success(Unit) }
            )
        )

        collect(manager = manager, into = values)
        runCurrent()
        launch { manager.skipToNext() }
        runCurrent()

        fetchCount shouldBe 1
        values.last() shouldBe PlayerStateData.Active(playbackState = initialState.copy(progressMs = 0))
    }

    @Test
    fun `skipToNext - repository succeeds - fetches the player state 500 ms later`() = runTest {
        var fetchCount = 0
        val fetchedState = playbackStateData(trackId = "fetched", isPlaying = false)
        val values = mutableListOf<PlayerStateData>()
        val manager = createManager(
            playerRepository = FakePlayerRepository(
                onGetPlaybackState = {
                    fetchCount++
                    value(if (fetchCount == 1) playbackStateData(trackId = "track", isPlaying = false) else fetchedState)
                },
                onSkipToNext = { Result.success(Unit) }
            )
        )

        collect(manager = manager, into = values)
        runCurrent()
        launch { manager.skipToNext() }
        runCurrent()
        advance(499.milliseconds)
        val fetchCountBeforeDelay = fetchCount
        advance(1.milliseconds)

        fetchCountBeforeDelay shouldBe 1
        fetchCount shouldBe 2
        values.last() shouldBe PlayerStateData.Active(playbackState = fetchedState)
    }

    @Test
    fun `skipToPrevious - repository succeeds while active - resets progress locally before fetching`() = runTest {
        var fetchCount = 0
        val initialState = playbackStateData(trackId = "track", isPlaying = true, progressMs = 20000)
        val values = mutableListOf<PlayerStateData>()
        val manager = createManager(
            playerRepository = FakePlayerRepository(
                onGetPlaybackState = {
                    fetchCount++
                    value(if (fetchCount == 1) initialState else playbackStateData(trackId = "fetched"))
                },
                onSkipToPrevious = { Result.success(Unit) }
            )
        )

        collect(manager = manager, into = values)
        runCurrent()
        launch { manager.skipToPrevious() }
        runCurrent()

        fetchCount shouldBe 1
        values.last() shouldBe PlayerStateData.Active(playbackState = initialState.copy(progressMs = 0))
    }

    @Test
    fun `skipToPrevious - repository succeeds - fetches the player state 500 ms later`() = runTest {
        var fetchCount = 0
        val fetchedState = playbackStateData(trackId = "fetched", isPlaying = false)
        val values = mutableListOf<PlayerStateData>()
        val manager = createManager(
            playerRepository = FakePlayerRepository(
                onGetPlaybackState = {
                    fetchCount++
                    value(if (fetchCount == 1) playbackStateData(trackId = "track", isPlaying = false) else fetchedState)
                },
                onSkipToPrevious = { Result.success(Unit) }
            )
        )

        collect(manager = manager, into = values)
        runCurrent()
        launch { manager.skipToPrevious() }
        runCurrent()
        advance(499.milliseconds)
        val fetchCountBeforeDelay = fetchCount
        advance(1.milliseconds)

        fetchCountBeforeDelay shouldBe 1
        fetchCount shouldBe 2
        values.last() shouldBe PlayerStateData.Active(playbackState = fetchedState)
    }

    @Test
    fun `setShuffle - repository succeeds while active - updates shuffling locally before fetching`() = runTest {
        var fetchCount = 0
        val initialState = playbackStateData(trackId = "track", isPlaying = false, isShuffling = false)
        val values = mutableListOf<PlayerStateData>()
        val manager = createManager(
            playerRepository = FakePlayerRepository(
                onGetPlaybackState = {
                    fetchCount++
                    value(if (fetchCount == 1) initialState else playbackStateData(trackId = "fetched"))
                },
                onSetShuffle = { Result.success(Unit) }
            )
        )

        collect(manager = manager, into = values)
        runCurrent()
        launch { manager.setShuffle(params = SetShuffleParams(isEnabled = true)) }
        runCurrent()

        fetchCount shouldBe 1
        values.last() shouldBe PlayerStateData.Active(playbackState = initialState.copy(isShuffling = true))
    }

    @Test
    fun `setShuffle - repository succeeds - fetches the player state 500 ms later`() = runTest {
        var fetchCount = 0
        val fetchedState = playbackStateData(trackId = "fetched", isPlaying = false, isShuffling = true)
        val values = mutableListOf<PlayerStateData>()
        val manager = createManager(
            playerRepository = FakePlayerRepository(
                onGetPlaybackState = {
                    fetchCount++
                    value(if (fetchCount == 1) playbackStateData(trackId = "track", isPlaying = false) else fetchedState)
                },
                onSetShuffle = { Result.success(Unit) }
            )
        )

        collect(manager = manager, into = values)
        runCurrent()
        launch { manager.setShuffle(params = SetShuffleParams(isEnabled = true)) }
        runCurrent()
        advance(499.milliseconds)
        val fetchCountBeforeDelay = fetchCount
        advance(1.milliseconds)

        fetchCountBeforeDelay shouldBe 1
        fetchCount shouldBe 2
        values.last() shouldBe PlayerStateData.Active(playbackState = fetchedState)
    }

    @Test
    fun `pause - repository succeeds while active - marks playback paused locally before fetching`() = runTest {
        var fetchCount = 0
        val initialState = playbackStateData(trackId = "track", isPlaying = true, progressMs = 20000)
        val values = mutableListOf<PlayerStateData>()
        val manager = createManager(
            playerRepository = FakePlayerRepository(
                onGetPlaybackState = {
                    fetchCount++
                    value(if (fetchCount == 1) initialState else playbackStateData(trackId = "fetched"))
                },
                onPause = { Result.success(Unit) }
            )
        )

        collect(manager = manager, into = values)
        runCurrent()
        launch { manager.pause() }
        runCurrent()

        fetchCount shouldBe 1
        values.last() shouldBe PlayerStateData.Active(playbackState = initialState.copy(isPlaying = false))
    }

    @Test
    fun `pause - repository succeeds - fetches the player state 500 ms later`() = runTest {
        var fetchCount = 0
        val fetchedState = playbackStateData(trackId = "fetched", isPlaying = false)
        val values = mutableListOf<PlayerStateData>()
        val manager = createManager(
            playerRepository = FakePlayerRepository(
                onGetPlaybackState = {
                    fetchCount++
                    value(if (fetchCount == 1) playbackStateData(trackId = "track", isPlaying = false) else fetchedState)
                },
                onPause = { Result.success(Unit) }
            )
        )

        collect(manager = manager, into = values)
        runCurrent()
        launch { manager.pause() }
        runCurrent()
        advance(499.milliseconds)
        val fetchCountBeforeDelay = fetchCount
        advance(1.milliseconds)

        fetchCountBeforeDelay shouldBe 1
        fetchCount shouldBe 2
        values.last() shouldBe PlayerStateData.Active(playbackState = fetchedState)
    }

    @Test
    fun `pause - repository succeeds while idle - stays idle until the fetch`() = runTest {
        var fetchCount = 0
        val values = mutableListOf<PlayerStateData>()
        val manager = createManager(
            playerRepository = FakePlayerRepository(
                onGetPlaybackState = {
                    fetchCount++
                    if (fetchCount == 1) {
                        Result.success(GetPlaybackStateResult.None)
                    } else {
                        value(playbackStateData(trackId = "fetched", isPlaying = false))
                    }
                },
                onPause = { Result.success(Unit) }
            )
        )

        collect(manager = manager, into = values)
        runCurrent()
        launch { manager.pause() }
        runCurrent()

        fetchCount shouldBe 1
        values.last() shouldBe PlayerStateData.Idle
    }

    @Test
    fun `pause - repository fails while active - keeps the state and does not fetch`() = runTest {
        var fetchCount = 0
        val initialState = playbackStateData(trackId = "track", isPlaying = false, progressMs = 20000)
        val values = mutableListOf<PlayerStateData>()
        val manager = createManager(
            playerRepository = FakePlayerRepository(
                onGetPlaybackState = {
                    fetchCount++
                    value(initialState)
                },
                onPause = { Result.failure(IllegalStateException("premium required")) }
            )
        )

        collect(manager = manager, into = values)
        runCurrent()
        launch { manager.pause() }
        runCurrent()
        advance(1.seconds)

        fetchCount shouldBe 1
        values.last() shouldBe PlayerStateData.Active(playbackState = initialState)
    }

    @Test
    fun `resume - repository succeeds while active - marks playback playing locally before fetching`() = runTest {
        var fetchCount = 0
        val initialState = playbackStateData(trackId = "track", isPlaying = false, progressMs = 20000)
        val values = mutableListOf<PlayerStateData>()
        val manager = createManager(
            playerRepository = FakePlayerRepository(
                onGetPlaybackState = {
                    fetchCount++
                    value(if (fetchCount == 1) initialState else playbackStateData(trackId = "fetched"))
                },
                onResume = { Result.success(Unit) }
            )
        )

        collect(manager = manager, into = values)
        runCurrent()
        launch { manager.resume() }
        runCurrent()

        fetchCount shouldBe 1
        values.last() shouldBe PlayerStateData.Active(playbackState = initialState.copy(isPlaying = true))
    }

    @Test
    fun `resume - repository succeeds - fetches the player state 500 ms later`() = runTest {
        var fetchCount = 0
        val fetchedState = playbackStateData(trackId = "fetched", isPlaying = false)
        val values = mutableListOf<PlayerStateData>()
        val manager = createManager(
            playerRepository = FakePlayerRepository(
                onGetPlaybackState = {
                    fetchCount++
                    value(if (fetchCount == 1) playbackStateData(trackId = "track", isPlaying = false) else fetchedState)
                },
                onResume = { Result.success(Unit) }
            )
        )

        collect(manager = manager, into = values)
        runCurrent()
        launch { manager.resume() }
        runCurrent()
        advance(499.milliseconds)
        val fetchCountBeforeDelay = fetchCount
        advance(1.milliseconds)

        fetchCountBeforeDelay shouldBe 1
        fetchCount shouldBe 2
        values.last() shouldBe PlayerStateData.Active(playbackState = fetchedState)
    }

    @Test
    fun `skipToNext - repository succeeds while playing - stops progress ticker until the fetch`() = runTest {
        var fetchCount = 0
        val values = mutableListOf<PlayerStateData>()
        val manager = createManager(
            playerRepository = FakePlayerRepository(
                onGetPlaybackState = {
                    fetchCount++
                    value(playing(progressMs = 20000, durationMs = 200000))
                },
                onSkipToNext = { Result.success(Unit) }
            )
        )

        collect(manager = manager, into = values)
        runCurrent()
        advance(900.milliseconds)
        launch { manager.skipToNext() }
        runCurrent()
        advance(400.milliseconds)

        fetchCount shouldBe 1
        values.last().progressMs() shouldBe 0
    }

    @Test
    fun `skipToNext - fetched playing state - restarts progress ticker from the fetch`() = runTest {
        var fetchCount = 0
        val values = mutableListOf<PlayerStateData>()
        val manager = createManager(
            playerRepository = FakePlayerRepository(
                onGetPlaybackState = {
                    fetchCount++
                    value(playing(progressMs = if (fetchCount == 1) 20000 else 5000, durationMs = 200000))
                },
                onSkipToNext = { Result.success(Unit) }
            )
        )

        collect(manager = manager, into = values)
        runCurrent()
        advance(900.milliseconds)
        launch { manager.skipToNext() }
        runCurrent()
        advance(1200.milliseconds)
        val progressBeforeTick = values.last().progressMs()
        advance(300.milliseconds)

        fetchCount shouldBe 2
        progressBeforeTick shouldBe 5000
        values.last().progressMs() shouldBe 6000
    }

    @Test
    fun `resume - repository succeeds while paused - does not advance progress until the fetch`() = runTest {
        var fetchCount = 0
        val values = mutableListOf<PlayerStateData>()
        val manager = createManager(
            playerRepository = FakePlayerRepository(
                onGetPlaybackState = {
                    fetchCount++
                    value(playbackStateData(isPlaying = false, progressMs = 20000))
                },
                onResume = { Result.success(Unit) }
            )
        )

        collect(manager = manager, into = values)
        runCurrent()
        advance(900.milliseconds)
        launch { manager.resume() }
        runCurrent()
        advance(400.milliseconds)

        fetchCount shouldBe 1
        values.last().progressMs() shouldBe 20000
    }

    @Test
    fun `resume - fetched playing state - starts progress ticker from the fetch`() = runTest {
        var fetchCount = 0
        val values = mutableListOf<PlayerStateData>()
        val manager = createManager(
            playerRepository = FakePlayerRepository(
                onGetPlaybackState = {
                    fetchCount++
                    if (fetchCount == 1) {
                        value(playbackStateData(isPlaying = false, progressMs = 20000))
                    } else {
                        value(playing(progressMs = 30000, durationMs = 200000))
                    }
                },
                onResume = { Result.success(Unit) }
            )
        )

        collect(manager = manager, into = values)
        runCurrent()
        advance(900.milliseconds)
        launch { manager.resume() }
        runCurrent()
        advance(1200.milliseconds)
        val progressBeforeTick = values.last().progressMs()
        advance(300.milliseconds)

        fetchCount shouldBe 2
        progressBeforeTick shouldBe 30000
        values.last().progressMs() shouldBe 31000
    }

    private fun createManager(
        playerRepository: PlayerRepository = FakePlayerRepository()
    ) = PlayerManagerImpl(
        playerRepository = playerRepository
    )

    private fun TestScope.collect(
        manager: PlayerManagerImpl,
        into: MutableList<PlayerStateData> = mutableListOf()
    ): Job = backgroundScope.launch {
        manager.playerState.collect { state -> into.add(state) }
    }

    private fun TestScope.advance(duration: Duration) {
        advanceTimeBy(duration)
        runCurrent()
    }

    private fun PlayerStateData.progressMs(): Int? {
        return (this as? PlayerStateData.Active)?.playbackState?.progressMs
    }

    private fun value(playbackState: PlaybackStateData): Result<GetPlaybackStateResult> {
        return Result.success(GetPlaybackStateResult.Value(playbackState = playbackState))
    }

    private fun playing(progressMs: Int, durationMs: Int): PlaybackStateData = playbackStateData(
        track = trackData(id = "track-id", durationMs = durationMs),
        isPlaying = true,
        progressMs = progressMs
    )
}
