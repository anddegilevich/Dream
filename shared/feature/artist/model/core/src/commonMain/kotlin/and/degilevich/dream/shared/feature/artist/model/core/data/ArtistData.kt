package and.degilevich.dream.shared.feature.artist.model.core.data

import and.degilevich.dream.shared.feature.artist.model.artifact.abstraction.ArtistInfo
import and.degilevich.dream.shared.feature.artist.model.artifact.dictionary.ArtistType
import and.degilevich.dream.shared.feature.image.model.artifact.data.ImageObjectData
import and.degilevich.dream.shared.foundation.model.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.model.id.AbstractIdentified
import kotlinx.serialization.Serializable

@Serializable
data class ArtistData(
    override val id: String,
    override val name: String,
    override val artistType: ArtistType,
    val popularity: Int,
    val genres: List<String>,
    val followers: ArtistFollowersData,
    val images: List<ImageObjectData>
) : AbstractIdentified(), ArtistInfo {
    companion object : EmptyFactory<ArtistData> {
        override fun empty(): ArtistData {
            return ArtistData(
                id = "",
                name = "",
                artistType = ArtistType.UNKNOWN,
                popularity = 0,
                genres = emptyList(),
                followers = ArtistFollowersData.empty(),
                images = emptyList()
            )
        }
    }
}
