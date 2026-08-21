package and.degilevich.dream.shared.feature.track.domain.impl.usecase

import and.degilevich.dream.shared.feature.track.data.test.repository.FakeTrackRepository
import and.degilevich.dream.shared.feature.track.model.artifact.api.data.TrackId
import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData
import and.degilevich.dream.shared.feature.track.model.core.api.method.getTrack.GetTrackParams
import and.degilevich.dream.shared.feature.track.model.core.api.method.getTrack.GetTrackResult
import and.degilevich.dream.shared.feature.track.model.core.test.data.trackData
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertTrue

class GetTrackUseCaseImplTest {

    @Test
    fun `invoke - repository succeeds - caches the returned track and returns the result unchanged`() = runTest {
        val track = trackData(id = "track-1")
        val cachedTracks = mutableListOf<TrackData>()
        val trackRepository = FakeTrackRepository(
            onGetTrack = { Result.success(GetTrackResult(track = track)) },
            onCacheTrack = { cachedTracks.add(it) }
        )
        val useCase = GetTrackUseCaseImpl(trackRepository = trackRepository)
        val result = useCase(
            params = GetTrackParams(
                id = TrackId(value = "track-1")
            )
        )
        result shouldBe Result.success(GetTrackResult(track = track))
        cachedTracks shouldBe listOf(track)
    }

    @Test
    fun `invoke - repository fails - returns failure without caching`() = runTest {
        val error = IllegalStateException("network error")
        val cachedTracks = mutableListOf<TrackData>()
        val trackRepository = FakeTrackRepository(
            onGetTrack = { Result.failure(error) },
            onCacheTrack = { cachedTracks.add(it) }
        )
        val useCase = GetTrackUseCaseImpl(trackRepository = trackRepository)
        val result = useCase(
            params = GetTrackParams(
                id = TrackId(value = "track-1")
            )
        )
        assertTrue(result.isFailure)
        cachedTracks shouldBe emptyList()
    }
}
