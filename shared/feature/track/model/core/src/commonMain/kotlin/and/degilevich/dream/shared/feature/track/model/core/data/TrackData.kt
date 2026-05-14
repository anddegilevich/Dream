package and.degilevich.dream.shared.feature.track.model.core.data

import and.degilevich.dream.shared.feature.album.model.artifact.data.AlbumSimplifiedData
import and.degilevich.dream.shared.feature.artist.model.artifact.data.ArtistSimplifiedData
import and.degilevich.dream.shared.feature.track.model.artifact.abstraction.TrackInfo
import and.degilevich.dream.shared.feature.track.model.artifact.data.TrackId
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.abstraction.id.AbstractIdentified
import kotlinx.serialization.Serializable

@Serializable
data class TrackData(
    override val id: TrackId,
    override val name: String,
    val album: AlbumSimplifiedData,
    override val trackNumber: Int,
    override val durationMs: Int,
    override val artists: List<ArtistSimplifiedData>
) : AbstractIdentified(), TrackInfo {

    companion object : EmptyFactory<TrackData> {

        override fun empty(): TrackData {
            return TrackData(
                id = TrackId.empty(),
                name = "",
                album = AlbumSimplifiedData.empty(),
                trackNumber = 0,
                durationMs = 0,
                artists = emptyList()
            )
        }
    }
}