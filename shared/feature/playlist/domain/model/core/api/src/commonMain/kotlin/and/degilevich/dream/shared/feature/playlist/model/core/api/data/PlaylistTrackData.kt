package and.degilevich.dream.shared.feature.playlist.model.core.api.data

import and.degilevich.dream.shared.feature.track.model.artifact.api.data.TrackId
import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.abstraction.id.AbstractIdentified
import kotlinx.serialization.Serializable

@Serializable
data class PlaylistTrackData(
    val track: TrackData,
    val addedAt: String
) : AbstractIdentified() {

    override val id: TrackId
        get() = track.id

    companion object : EmptyFactory<PlaylistTrackData> {

        override fun empty(): PlaylistTrackData {
            return PlaylistTrackData(
                track = TrackData.empty(),
                addedAt = ""
            )
        }
    }
}
