package and.degilevich.dream.shared.feature.artist.model.core.api.data

import and.degilevich.dream.shared.feature.artist.model.artifact.api.abstraction.ArtistInfo
import and.degilevich.dream.shared.feature.artist.model.artifact.api.data.ArtistId
import and.degilevich.dream.shared.feature.artist.model.artifact.api.dictionary.ArtistType
import and.degilevich.dream.shared.feature.image.model.artifact.api.data.ImageObjectData
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.abstraction.id.AbstractIdentified
import kotlinx.serialization.Serializable

@Serializable
data class ArtistData(
    override val id: ArtistId,
    override val name: String,
    override val artistType: ArtistType,
    val images: List<ImageObjectData>
) : AbstractIdentified(), ArtistInfo {

    companion object : EmptyFactory<ArtistData> {

        override fun empty(): ArtistData {
            return ArtistData(
                id = ArtistId.empty(),
                name = "",
                artistType = ArtistType.UNKNOWN,
                images = emptyList()
            )
        }
    }
}
