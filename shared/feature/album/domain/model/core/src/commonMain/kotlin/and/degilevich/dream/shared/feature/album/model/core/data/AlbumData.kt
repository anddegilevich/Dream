package and.degilevich.dream.shared.feature.album.model.core.data

import and.degilevich.dream.shared.feature.album.model.artifact.abstraction.AlbumInfo
import and.degilevich.dream.shared.feature.album.model.artifact.data.AlbumId
import and.degilevich.dream.shared.feature.album.model.artifact.dictionary.AlbumType
import and.degilevich.dream.shared.feature.artist.model.artifact.data.SimplifiedArtistData
import and.degilevich.dream.shared.feature.image.model.artifact.data.ImageData
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.abstraction.id.AbstractIdentified
import kotlinx.serialization.Serializable

@Serializable
data class AlbumData(
    override val id: AlbumId,
    override val name: String,
    override val albumType: AlbumType,
    override val totalTracks: Int,
    override val releaseDate: String,
    override val artists: List<SimplifiedArtistData>,
    override val images: List<ImageData>,
    val tracks: AlbumTracksData,
) : AbstractIdentified(), AlbumInfo {

    companion object : EmptyFactory<AlbumData> {

        override fun empty(): AlbumData {
            return AlbumData(
                id = AlbumId.empty(),
                name = "",
                albumType = AlbumType.UNKNOWN,
                totalTracks = 0,
                releaseDate = "",
                artists = emptyList(),
                images = emptyList(),
                tracks = AlbumTracksData.empty()
            )
        }
    }
}