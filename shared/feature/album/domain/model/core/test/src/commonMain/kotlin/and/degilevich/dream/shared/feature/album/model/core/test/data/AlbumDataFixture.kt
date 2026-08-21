package and.degilevich.dream.shared.feature.album.model.core.test.data

import and.degilevich.dream.shared.feature.album.model.artifact.api.data.AlbumId
import and.degilevich.dream.shared.feature.album.model.artifact.api.dictionary.AlbumType
import and.degilevich.dream.shared.feature.album.model.core.api.data.AlbumData
import and.degilevich.dream.shared.feature.album.model.core.api.data.AlbumTracksData
import and.degilevich.dream.shared.feature.artist.model.artifact.api.data.SimplifiedArtistData

fun albumData(
    id: String,
    albumType: AlbumType = AlbumType.ALBUM,
    totalTracks: Int = 1,
    artists: List<SimplifiedArtistData> = emptyList(),
    tracks: AlbumTracksData = AlbumTracksData.empty()
): AlbumData = AlbumData(
    id = AlbumId(value = id),
    name = "Album $id",
    albumType = albumType,
    totalTracks = totalTracks,
    releaseDate = "2021-01-01",
    artists = artists,
    images = emptyList(),
    tracks = tracks
)
