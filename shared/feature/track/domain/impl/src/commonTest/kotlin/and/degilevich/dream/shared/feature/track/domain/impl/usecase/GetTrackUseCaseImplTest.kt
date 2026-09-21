package and.degilevich.dream.shared.feature.track.domain.impl.usecase

import and.degilevich.dream.shared.feature.track.data.test.repository.FakeTrackRepository
import and.degilevich.dream.shared.feature.track.model.artifact.api.data.TrackId
import and.degilevich.dream.shared.feature.track.model.core.api.method.getTrack.GetTrackParams
import and.degilevich.dream.shared.feature.track.model.core.api.method.getTrack.GetTrackResult
import and.degilevich.dream.shared.feature.track.model.core.test.data.trackData
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertTrue

class GetTrackUseCaseImplTest {

    @Test
    fun `invoke - repository succeeds - returns the result unchanged`() = runTest {
        val track = trackData(id = "track-1")
        val trackRepository = FakeTrackRepository(
            onGetTrack = { Result.success(GetTrackResult(track = track)) }
        )
        val useCase = GetTrackUseCaseImpl(trackRepository = trackRepository)
        val result = useCase(
            params = GetTrackParams(
                id = TrackId(value = "track-1")
            )
        )
        result shouldBe Result.success(GetTrackResult(track = track))
    }

    @Test
    fun `invoke - repository fails - returns failure`() = runTest {
        val error = IllegalStateException("network error")
        val trackRepository = FakeTrackRepository(
            onGetTrack = { Result.failure(error) }
        )
        val useCase = GetTrackUseCaseImpl(trackRepository = trackRepository)
        val result = useCase(
            params = GetTrackParams(
                id = TrackId(value = "track-1")
            )
        )
        assertTrue(result.isFailure)
    }

    @Test
    fun `invoke - any params - passes them to the repository unchanged`() = runTest {
        val receivedParams = mutableListOf<GetTrackParams>()
        val trackRepository = FakeTrackRepository(
            onGetTrack = { params ->
                receivedParams.add(params)
                Result.success(GetTrackResult(track = trackData(id = "track-1")))
            }
        )
        val useCase = GetTrackUseCaseImpl(trackRepository = trackRepository)
        val params = GetTrackParams(id = TrackId(value = "track-1"))
        useCase(params = params)
        receivedParams shouldBe listOf(params)
    }
}
