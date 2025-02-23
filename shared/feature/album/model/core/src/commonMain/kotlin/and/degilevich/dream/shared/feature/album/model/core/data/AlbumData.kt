package and.degilevich.dream.shared.feature.album.model.core.data

import and.degilevich.dream.shared.feature.album.model.core.dictionary.AlbumType
import and.degilevich.dream.shared.feature.artist.model.artifact.data.ArtistSimplifiedData
import and.degilevich.dream.shared.feature.image.model.artifact.data.ImageObjectData
import and.degilevich.dream.shared.foundation.model.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.model.id.IdentifiedAbs
import kotlinx.serialization.Serializable

@Serializable
data class AlbumData(
    override val id: String,
    val name: String,
    val albumType: AlbumType,
    val totalTracks: Int,
    val releaseDate: String,
    val artists: List<ArtistSimplifiedData>,
    val images: List<ImageObjectData>,
    val tracks: AlbumTracksData,
    val label: String,
    val popularity: Int
) : IdentifiedAbs() {

    companion object : EmptyFactory<AlbumData> {
        override fun empty(): AlbumData {
            return AlbumData(
                id = "",
                name = "",
                albumType = AlbumType.UNKNOWN,
                totalTracks = 0,
                releaseDate = "",
                artists = emptyList(),
                images = emptyList(),
                tracks = AlbumTracksData.empty(),
                label = "",
                popularity = 0
            )
        }
    }
}
