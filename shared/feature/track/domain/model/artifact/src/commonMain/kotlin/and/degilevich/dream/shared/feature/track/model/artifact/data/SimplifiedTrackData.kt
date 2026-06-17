package and.degilevich.dream.shared.feature.track.model.artifact.data

import and.degilevich.dream.shared.feature.artist.model.artifact.data.SimplifiedArtistData
import and.degilevich.dream.shared.feature.track.model.artifact.abstraction.TrackInfo
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.abstraction.id.AbstractIdentified
import kotlinx.serialization.Serializable

@Serializable
data class SimplifiedTrackData(
    override val id: TrackId,
    override val name: String,
    override val trackNumber: Int,
    override val durationMs: Int,
    override val artists: List<SimplifiedArtistData>
) : AbstractIdentified(), TrackInfo {

    companion object : EmptyFactory<SimplifiedTrackData> {

        override fun empty(): SimplifiedTrackData {
            return SimplifiedTrackData(
                id = TrackId.empty(),
                name = "",
                trackNumber = 0,
                durationMs = 0,
                artists = emptyList()
            )
        }
    }
}