package and.degilevich.dream.shared.feature.track.data.impl.local

import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeTrackLocalDataSource(
    private val onSaveTracks: (List<TrackData>) -> Unit = { fakeImplementationError() },
    private val onSaveTrack: (TrackData) -> Unit = { fakeImplementationError() }
) : TrackLocalDataSource {

    override suspend fun saveTracks(tracks: List<TrackData>) {
        onSaveTracks(tracks)
    }

    override suspend fun saveTrack(track: TrackData) {
        onSaveTrack(track)
    }
}
