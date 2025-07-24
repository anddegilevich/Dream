package and.degilevich.dream.shared.feature.track.model.core.api.data

import and.degilevich.dream.shared.feature.album.model.artifact.api.data.AlbumSimplifiedData
import and.degilevich.dream.shared.feature.artist.model.artifact.api.data.ArtistSimplifiedData
import and.degilevich.dream.shared.feature.track.model.artifact.api.abstraction.TrackInfo
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.abstraction.id.AbstractIdentified
import kotlinx.serialization.Serializable

@Serializable
data class TrackData(
    override val id: String,
    override val name: String,
    val album: AlbumSimplifiedData,
    val popularity: Int,
    override val trackNumber: Int,
    override val durationMs: Int,
    override val artists: List<ArtistSimplifiedData>
) : AbstractIdentified(), TrackInfo {

    companion object : EmptyFactory<TrackData> {
        override fun empty(): TrackData {
            return TrackData(
                id = "",
                name = "",
                album = AlbumSimplifiedData.empty(),
                popularity = 0,
                trackNumber = 0,
                durationMs = 0,
                artists = emptyList()
            )
        }
    }
}