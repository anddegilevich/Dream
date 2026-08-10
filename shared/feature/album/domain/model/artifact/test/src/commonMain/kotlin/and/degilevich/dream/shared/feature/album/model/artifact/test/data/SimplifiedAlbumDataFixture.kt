package and.degilevich.dream.shared.feature.album.model.artifact.test.data

import and.degilevich.dream.shared.feature.album.model.artifact.api.data.AlbumId
import and.degilevich.dream.shared.feature.album.model.artifact.api.data.SimplifiedAlbumData
import and.degilevich.dream.shared.feature.album.model.artifact.api.dictionary.AlbumType
import and.degilevich.dream.shared.feature.artist.model.artifact.api.data.SimplifiedArtistData
import and.degilevich.dream.shared.feature.image.model.artifact.api.data.ImageData

fun simplifiedAlbumData(
    id: String,
    artists: List<SimplifiedArtistData> = emptyList(),
    albumType: AlbumType = AlbumType.ALBUM,
    totalTracks: Int = 1,
    releaseDate: String = "2021-01-01",
    images: List<ImageData> = emptyList()
): SimplifiedAlbumData = SimplifiedAlbumData(
    id = AlbumId(value = id),
    name = "Album $id",
    albumType = albumType,
    totalTracks = totalTracks,
    releaseDate = releaseDate,
    artists = artists,
    images = images
)
