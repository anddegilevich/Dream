package and.degilevich.dream.shared.feature.artist.model.artifact.api.data

import and.degilevich.dream.shared.feature.artist.model.artifact.api.abstraction.ArtistInfo
import and.degilevich.dream.shared.feature.artist.model.artifact.api.dictionary.ArtistType
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.abstraction.id.AbstractIdentified
import and.degilevich.dream.shared.foundation.abstraction.id.Identifier
import kotlinx.serialization.Serializable

@Serializable
data class ArtistSimplifiedData(
    override val id: Identifier,
    override val name: String,
    override val artistType: ArtistType
) : AbstractIdentified(), ArtistInfo {

    companion object : EmptyFactory<ArtistSimplifiedData> {
        override fun empty(): ArtistSimplifiedData {
            return ArtistSimplifiedData(
                id = Identifier.empty(),
                name = "",
                artistType = ArtistType.UNKNOWN
            )
        }
    }
}