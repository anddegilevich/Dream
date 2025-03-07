package and.degilevich.dream.shared.feature.track.model.core

import and.degilevich.dream.shared.feature.album.model.core.data.AlbumData
import and.degilevich.dream.shared.feature.artist.model.artifact.data.ArtistSimplifiedData
import and.degilevich.dream.shared.feature.track.model.artifact.abstraction.TrackInfo
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.abstraction.id.IdentifiedAbs

data class TrackData(
    override val id: String,
    override val name: String,
    val album: AlbumData,
    val popularity: Int,
    override val trackNumber: Int,
    override val durationMs: Int,
    override val artists: List<ArtistSimplifiedData>
) : IdentifiedAbs(), TrackInfo {

    companion object : EmptyFactory<TrackData> {
        override fun empty(): TrackData {
            return TrackData(
                id = "",
                name = "",
                album = AlbumData.empty(),
                popularity = 0,
                trackNumber = 0,
                durationMs = 0,
                artists = emptyList()
            )
        }
    }
}