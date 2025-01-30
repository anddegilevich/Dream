package and.degilevich.dream.shared.feature.album.model.core

import and.degilevich.dream.shared.feature.album.model.core.dictionary.AlbumType
import and.degilevich.dream.shared.feature.artist.model.artifact.ArtistSimplifiedData
import and.degilevich.dream.shared.feature.image.model.artifact.ImageObjectData
import and.degilevich.dream.shared.foundation.model.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.model.empty.state.EmptyState
import and.degilevich.dream.shared.foundation.model.id.AbstractIdentified
import and.degilevich.dream.shared.foundation.model.id.Identified

interface AlbumData : Identified, EmptyState {
    val name: String
    val albumType: AlbumType
    val totalTracks: Int
    val releaseDate: String
    val artists: List<ArtistSimplifiedData>
    val images: List<ImageObjectData>
    val tracks: AlbumTracksData
    val label: String
    val popularity: Int

    data class Base(
        override val id: String,
        override val name: String,
        override val albumType: AlbumType,
        override val totalTracks: Int,
        override val releaseDate: String,
        override val artists: List<ArtistSimplifiedData>,
        override val images: List<ImageObjectData>,
        override val tracks: AlbumTracksData,
        override val label: String,
        override val popularity: Int
    ) : AbstractIdentified(), AlbumData

    companion object : EmptyFactory<AlbumData> {
        override fun empty(): AlbumData {
            return Base(
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
