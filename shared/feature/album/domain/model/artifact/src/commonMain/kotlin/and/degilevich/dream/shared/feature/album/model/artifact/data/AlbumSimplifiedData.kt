package and.degilevich.dream.shared.feature.album.model.artifact.data

import and.degilevich.dream.shared.feature.album.model.artifact.abstraction.AlbumInfo
import and.degilevich.dream.shared.feature.album.model.artifact.dictionary.AlbumType
import and.degilevich.dream.shared.feature.artist.model.artifact.data.ArtistSimplifiedData
import and.degilevich.dream.shared.feature.image.model.artifact.data.ImageObjectData
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.abstraction.id.AbstractIdentified
import kotlinx.serialization.Serializable

@Serializable
data class AlbumSimplifiedData(
    override val id: AlbumId,
    override val name: String,
    override val albumType: AlbumType,
    override val totalTracks: Int,
    override val releaseDate: String,
    override val artists: List<ArtistSimplifiedData>,
    override val images: List<ImageObjectData>,
) : AbstractIdentified(), AlbumInfo {

    companion object : EmptyFactory<AlbumSimplifiedData> {

        override fun empty(): AlbumSimplifiedData {
            return AlbumSimplifiedData(
                id = AlbumId.empty(),
                name = "",
                albumType = AlbumType.UNKNOWN,
                totalTracks = 0,
                releaseDate = "",
                artists = emptyList(),
                images = emptyList()
            )
        }
    }
}
