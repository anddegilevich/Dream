package and.degilevich.dream.shared.feature.track.domain.impl.usecase

import and.degilevich.dream.shared.feature.track.data.test.repository.FakeTrackRepository
import and.degilevich.dream.shared.feature.track.model.core.api.method.getSavedTracks.GetSavedTracksParams
import and.degilevich.dream.shared.feature.track.model.core.api.method.getSavedTracks.GetSavedTracksResult
import and.degilevich.dream.shared.feature.track.model.core.test.data.savedTrackData
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertTrue

class GetSavedTracksUseCaseImplTest {

    @Test
    fun `invoke - repository succeeds - returns the result unchanged`() = runTest {
        val firstSavedTrack = savedTrackData(id = "track-1")
        val secondSavedTrack = savedTrackData(id = "track-2")
        val expected = GetSavedTracksResult(
            tracks = listOf(firstSavedTrack, secondSavedTrack),
            total = 145
        )
        val useCase = GetSavedTracksUseCaseImpl(
            trackRepository = FakeTrackRepository(
                onGetSavedTracks = { Result.success(expected) }
            )
        )

        val result = useCase(params = GetSavedTracksParams(limit = 20, offset = 40))

        result shouldBe Result.success(expected)
    }

    @Test
    fun `invoke - any params - passes them to the repository unchanged`() = runTest {
        val passedParams = mutableListOf<GetSavedTracksParams>()
        val useCase = GetSavedTracksUseCaseImpl(
            trackRepository = FakeTrackRepository(
                onGetSavedTracks = { params ->
                    passedParams.add(params)
                    Result.success(GetSavedTracksResult(tracks = emptyList(), total = 0))
                }
            )
        )
        val params = GetSavedTracksParams(limit = 20, offset = 40)

        useCase(params = params)

        passedParams shouldBe listOf(params)
    }

    @Test
    fun `invoke - repository fails - returns failure`() = runTest {
        val error = IllegalStateException("network error")
        val useCase = GetSavedTracksUseCaseImpl(
            trackRepository = FakeTrackRepository(
                onGetSavedTracks = { Result.failure(error) }
            )
        )

        val result = useCase(params = GetSavedTracksParams(limit = 20, offset = 0))

        assertTrue(result.isFailure)
    }
}
