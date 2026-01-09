package and.degilevich.dream.shared.feature.track.model.artifact.api.data

import and.degilevich.dream.shared.feature.artist.model.artifact.api.data.ArtistSimplifiedData
import and.degilevich.dream.shared.feature.track.model.artifact.api.abstraction.TrackInfo
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.abstraction.id.AbstractIdentified
import and.degilevich.dream.shared.foundation.abstraction.id.Identifier
import kotlinx.serialization.Serializable

@Serializable
data class TrackSimplifiedData(
    override val id: Identifier,
    override val name: String,
    override val trackNumber: Int,
    override val durationMs: Int,
    override val artists: List<ArtistSimplifiedData>
) : AbstractIdentified(), TrackInfo {

    companion object :
        EmptyFactory<TrackSimplifiedData> {
        override fun empty(): TrackSimplifiedData {
            return TrackSimplifiedData(
                id = Identifier.empty(),
                name = "",
                trackNumber = 0,
                durationMs = 0,
                artists = emptyList()
            )
        }
    }
}