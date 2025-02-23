package and.degilevich.dream.shared.feature.artist.model.artifact.data

import and.degilevich.dream.shared.feature.artist.model.artifact.abstraction.ArtistInfo
import and.degilevich.dream.shared.feature.artist.model.artifact.dictionary.ArtistType
import and.degilevich.dream.shared.foundation.model.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.model.id.IdentifiedAbs
import kotlinx.serialization.Serializable

@Serializable
data class ArtistSimplifiedData(
    override val id: String,
    override val name: String,
    override val artistType: ArtistType
) : IdentifiedAbs(), ArtistInfo {

    companion object : EmptyFactory<ArtistSimplifiedData> {
        override fun empty(): ArtistSimplifiedData {
            return ArtistSimplifiedData(
                id = "",
                name = "",
                artistType = ArtistType.UNKNOWN
            )
        }
    }
}