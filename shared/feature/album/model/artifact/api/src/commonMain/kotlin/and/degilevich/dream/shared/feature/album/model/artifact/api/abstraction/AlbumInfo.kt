package and.degilevich.dream.shared.feature.album.model.artifact.api.abstraction

import and.degilevich.dream.shared.feature.album.model.artifact.api.dictionary.AlbumType
import and.degilevich.dream.shared.feature.artist.model.artifact.api.data.ArtistSimplifiedData
import and.degilevich.dream.shared.feature.image.model.artifact.api.data.ImageObjectData

interface AlbumInfo {
    val id: String
    val name: String
    val albumType: AlbumType
    val totalTracks: Int
    val releaseDate: String
    val artists: List<ArtistSimplifiedData>
    val images: List<ImageObjectData>
}