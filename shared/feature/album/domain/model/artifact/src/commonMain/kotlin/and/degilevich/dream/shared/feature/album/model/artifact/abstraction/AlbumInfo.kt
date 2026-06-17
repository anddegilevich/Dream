package and.degilevich.dream.shared.feature.album.model.artifact.abstraction

import and.degilevich.dream.shared.feature.album.model.artifact.data.AlbumId
import and.degilevich.dream.shared.feature.album.model.artifact.dictionary.AlbumType
import and.degilevich.dream.shared.feature.artist.model.artifact.data.SimplifiedArtistData
import and.degilevich.dream.shared.feature.image.model.artifact.data.ImageData
import and.degilevich.dream.shared.foundation.abstraction.id.Identified

interface AlbumInfo : Identified {
    override val id: AlbumId
    val name: String
    val albumType: AlbumType
    val totalTracks: Int
    val releaseDate: String
    val artists: List<SimplifiedArtistData>
    val images: List<ImageData>
}