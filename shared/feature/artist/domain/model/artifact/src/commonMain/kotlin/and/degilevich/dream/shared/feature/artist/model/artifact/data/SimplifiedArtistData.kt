package and.degilevich.dream.shared.feature.artist.model.artifact.data

import and.degilevich.dream.shared.feature.artist.model.artifact.abstraction.ArtistInfo
import and.degilevich.dream.shared.feature.artist.model.artifact.dictionary.ArtistType
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.abstraction.id.AbstractIdentified
import kotlinx.serialization.Serializable

@Serializable
data class SimplifiedArtistData(
    override val id: ArtistId,
    override val name: String,
    override val artistType: ArtistType
) : AbstractIdentified(), ArtistInfo {

    companion object : EmptyFactory<SimplifiedArtistData> {

        override fun empty(): SimplifiedArtistData {
            return SimplifiedArtistData(
                id = ArtistId.empty(),
                name = "",
                artistType = ArtistType.UNKNOWN
            )
        }
    }
}