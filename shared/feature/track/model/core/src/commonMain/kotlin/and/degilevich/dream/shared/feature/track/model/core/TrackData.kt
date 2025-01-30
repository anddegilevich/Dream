package and.degilevich.dream.shared.feature.track.model.core

import and.degilevich.dream.shared.feature.album.model.core.AlbumData
import and.degilevich.dream.shared.feature.artist.model.artifact.ArtistSimplifiedData
import and.degilevich.dream.shared.feature.track.model.artifact.TrackSimplifiedData
import and.degilevich.dream.shared.foundation.model.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.model.id.AbstractIdentified

interface TrackData : TrackSimplifiedData {
    val album: AlbumData
    val popularity: Int

    data class Base(
        override val id: String,
        override val name: String,
        override val album: AlbumData,
        override val popularity: Int,
        override val trackNumber: Int,
        override val durationMs: Int,
        override val artists: List<ArtistSimplifiedData>
    ) : AbstractIdentified(), TrackData

    companion object : EmptyFactory<TrackData> {
        override fun empty(): TrackData {
            return Base(
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