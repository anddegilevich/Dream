package and.degilevich.dream.shared.feature.track.domain.impl.usecase

import and.degilevich.dream.shared.feature.track.data.test.repository.FakeTrackRepository
import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData
import and.degilevich.dream.shared.feature.track.model.core.api.method.getSavedTracks.GetSavedTracksParams
import and.degilevich.dream.shared.feature.track.model.core.api.method.getSavedTracks.GetSavedTracksResult
import and.degilevich.dream.shared.feature.track.model.core.test.data.savedTrackData
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertTrue

class GetSavedTracksUseCaseImplTest {

    @Test
    fun `invoke - repository succeeds - caches the returned tracks and returns the result unchanged`() = runTest {
        val firstSavedTrack = savedTrackData(id = "track-1")
        val secondSavedTrack = savedTrackData(id = "track-2")
        val expected = GetSavedTracksResult(
            tracks = listOf(firstSavedTrack, secondSavedTrack),
            total = 145
        )
        val cachedTracks = mutableListOf<List<TrackData>>()
        val useCase = GetSavedTracksUseCaseImpl(
            trackRepository = FakeTrackRepository(
                onGetSavedTracks = { Result.success(expected) },
                onCacheTracks = { tracks -> cachedTracks.add(tracks) }
            )
        )

        val result = useCase(params = GetSavedTracksParams(limit = 20, offset = 40))

        result shouldBe Result.success(expected)
        cachedTracks shouldBe listOf(listOf(firstSavedTrack.track, secondSavedTrack.track))
    }

    @Test
    fun `invoke - any params - passes them to the repository unchanged`() = runTest {
        val passedParams = mutableListOf<GetSavedTracksParams>()
        val useCase = GetSavedTracksUseCaseImpl(
            trackRepository = FakeTrackRepository(
                onGetSavedTracks = { params ->
                    passedParams.add(params)
                    Result.success(GetSavedTracksResult(tracks = emptyList(), total = 0))
                },
                onCacheTracks = { }
            )
        )
        val params = GetSavedTracksParams(limit = 20, offset = 40)

        useCase(params = params)

        passedParams shouldBe listOf(params)
    }

    @Test
    fun `invoke - repository fails - returns failure without caching`() = runTest {
        val error = IllegalStateException("network error")
        val cachedTracks = mutableListOf<List<TrackData>>()
        val useCase = GetSavedTracksUseCaseImpl(
            trackRepository = FakeTrackRepository(
                onGetSavedTracks = { Result.failure(error) },
                onCacheTracks = { tracks -> cachedTracks.add(tracks) }
            )
        )

        val result = useCase(params = GetSavedTracksParams(limit = 20, offset = 0))

        assertTrue(result.isFailure)
        cachedTracks shouldBe emptyList()
    }
}
