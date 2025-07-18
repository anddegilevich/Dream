package and.degilevich.dream.shared.feature.album.model.core.api.data

import and.degilevich.dream.shared.feature.album.model.artifact.api.abstraction.AlbumInfo
import and.degilevich.dream.shared.feature.album.model.artifact.api.dictionary.AlbumType
import and.degilevich.dream.shared.feature.artist.model.artifact.api.data.ArtistSimplifiedData
import and.degilevich.dream.shared.feature.image.model.artifact.api.data.ImageObjectData
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.abstraction.id.AbstractIdentified
import kotlinx.serialization.Serializable

@Serializable
data class AlbumData(
    override val id: String,
    override val name: String,
    override val albumType: AlbumType,
    override val totalTracks: Int,
    override val releaseDate: String,
    override val artists: List<ArtistSimplifiedData>,
    override val images: List<ImageObjectData>,
    val tracks: AlbumTracksData,
    val label: String,
    val popularity: Int
) : AbstractIdentified(), AlbumInfo {

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
                tracks = AlbumTracksData.Companion.empty(),
                label = "",
                popularity = 0
            )
        }
    }
}