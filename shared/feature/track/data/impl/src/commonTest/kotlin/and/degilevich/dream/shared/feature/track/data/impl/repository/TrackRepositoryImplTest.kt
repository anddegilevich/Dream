package and.degilevich.dream.shared.feature.track.data.impl.repository

import and.degilevich.dream.shared.feature.track.data.impl.local.FakeTrackLocalDataSource
import and.degilevich.dream.shared.feature.track.data.impl.remote.FakeTrackRemoteDataSource
import and.degilevich.dream.shared.feature.track.model.artifact.api.data.TrackId
import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData
import and.degilevich.dream.shared.feature.track.model.core.api.method.getSavedTracks.GetSavedTracksParams
import and.degilevich.dream.shared.feature.track.model.core.api.method.getSavedTracks.GetSavedTracksResult
import and.degilevich.dream.shared.feature.track.model.core.api.method.getTrack.GetTrackParams
import and.degilevich.dream.shared.feature.track.model.core.api.method.getTrack.GetTrackResult
import and.degilevich.dream.shared.feature.track.model.core.test.data.savedTrackData
import and.degilevich.dream.shared.feature.track.model.core.test.data.trackData
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

class TrackRepositoryImplTest {

    @Test
    fun `getTrack - delegates to remote data source and returns its result unchanged`() = runTest {
        val getTrackResult = Result.success(
            GetTrackResult(
                track = trackData(id = "track-1")
            )
        )
        val repository = TrackRepositoryImpl(
            trackRemoteDataSource = FakeTrackRemoteDataSource(onGetTrack = { getTrackResult }),
            trackLocalDataSource = FakeTrackLocalDataSource()
        )
        val params = GetTrackParams(id = TrackId(value = "track-1"))
        val result = repository.getTrack(params)
        result shouldBe getTrackResult
    }

    @Test
    fun `getSavedTracks - delegates to remote data source and returns its result unchanged`() = runTest {
        val getSavedTracksResult = Result.success(
            GetSavedTracksResult(
                tracks = listOf(savedTrackData(id = "track-1")),
                total = 145
            )
        )
        val passedParams = mutableListOf<GetSavedTracksParams>()
        val repository = TrackRepositoryImpl(
            trackRemoteDataSource = FakeTrackRemoteDataSource(
                onGetSavedTracks = { params ->
                    passedParams.add(params)
                    getSavedTracksResult
                }
            ),
            trackLocalDataSource = FakeTrackLocalDataSource()
        )
        val params = GetSavedTracksParams(limit = 20, offset = 40)

        val result = repository.getSavedTracks(params)

        result shouldBe getSavedTracksResult
        passedParams shouldBe listOf(params)
    }

    @Test
    fun `cacheTrack - delegates to local data source`() = runTest {
        val savedTracks = mutableListOf<TrackData>()
        val repository = TrackRepositoryImpl(
            trackRemoteDataSource = FakeTrackRemoteDataSource(),
            trackLocalDataSource = FakeTrackLocalDataSource(onSaveTrack = { savedTracks.add(it) })
        )
        val track = TrackData.empty()
        repository.cacheTrack(track)
        savedTracks shouldBe listOf(track)
    }

    @Test
    fun `cacheTracks - delegates to local data source`() = runTest {
        val savedTrackLists = mutableListOf<List<TrackData>>()
        val repository = TrackRepositoryImpl(
            trackRemoteDataSource = FakeTrackRemoteDataSource(),
            trackLocalDataSource = FakeTrackLocalDataSource(onSaveTracks = { savedTrackLists.add(it) })
        )
        val tracks = listOf(TrackData.empty())
        repository.cacheTracks(tracks)
        savedTrackLists shouldBe listOf(tracks)
    }
}
