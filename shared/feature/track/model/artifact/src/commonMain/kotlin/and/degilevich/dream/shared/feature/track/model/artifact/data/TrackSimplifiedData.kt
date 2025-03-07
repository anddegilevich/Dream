package and.degilevich.dream.shared.feature.track.model.artifact.data

import and.degilevich.dream.shared.feature.artist.model.artifact.data.ArtistSimplifiedData
import and.degilevich.dream.shared.feature.track.model.artifact.abstraction.TrackInfo
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.abstraction.id.IdentifiedAbs
import kotlinx.serialization.Serializable

@Serializable
data class TrackSimplifiedData(
    override val id: String,
    override val name: String,
    override val trackNumber: Int,
    override val durationMs: Int,
    override val artists: List<ArtistSimplifiedData>
) : IdentifiedAbs(), TrackInfo {

    companion object :
        EmptyFactory<TrackSimplifiedData> {
        override fun empty(): TrackSimplifiedData {
            return TrackSimplifiedData(
                id = "",
                name = "",
                trackNumber = 0,
                durationMs = 0,
                artists = emptyList()
            )
        }
    }
}