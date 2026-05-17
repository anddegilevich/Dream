package and.degilevich.dream.shared.feature.artist.model.artifact.data

import and.degilevich.dream.shared.feature.artist.model.artifact.abstraction.ArtistInfo
import and.degilevich.dream.shared.feature.artist.model.artifact.dictionary.ArtistType
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.abstraction.id.AbstractIdentified
import kotlinx.serialization.Serializable

@Serializable
data class ArtistSimplifiedData(
    override val id: ArtistId,
    override val name: String,
    override val artistType: ArtistType
) : AbstractIdentified(), ArtistInfo {

    companion object : EmptyFactory<ArtistSimplifiedData> {

        override fun empty(): ArtistSimplifiedData {
            return ArtistSimplifiedData(
                id = ArtistId.empty(),
                name = "",
                artistType = ArtistType.UNKNOWN
            )
        }
    }
}