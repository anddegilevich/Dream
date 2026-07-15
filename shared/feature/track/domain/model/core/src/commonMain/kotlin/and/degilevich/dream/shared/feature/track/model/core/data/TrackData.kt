package and.degilevich.dream.shared.feature.track.model.core.data

import and.degilevich.dream.shared.feature.album.model.artifact.data.SimplifiedAlbumData
import and.degilevich.dream.shared.feature.artist.model.artifact.data.SimplifiedArtistData
import and.degilevich.dream.shared.feature.track.model.artifact.abstraction.TrackInfo
import and.degilevich.dream.shared.feature.track.model.artifact.data.TrackId
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.abstraction.id.AbstractIdentified
import kotlinx.serialization.Serializable

@Serializable
data class TrackData(
    override val id: TrackId,
    override val name: String,
    val album: SimplifiedAlbumData,
    override val trackNumber: Int,
    override val durationMs: Int,
    override val artists: List<SimplifiedArtistData>
) : AbstractIdentified(), TrackInfo {

    companion object : EmptyFactory<TrackData> {

        override fun empty(): TrackData {
            return TrackData(
                id = TrackId.empty(),
                name = "",
                album = SimplifiedAlbumData.empty(),
                trackNumber = 0,
                durationMs = 0,
                artists = emptyList()
            )
        }
    }
}