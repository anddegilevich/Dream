package and.degilevich.dream.shared.feature.album.data.api.local

import and.degilevich.dream.shared.feature.album.model.artifact.data.AlbumSimplifiedData
import and.degilevich.dream.shared.feature.album.model.core.data.AlbumData

interface AlbumLocalDataSource {
    suspend fun saveAlbum(album: AlbumData)
    suspend fun saveAlbums(albums: List<AlbumSimplifiedData>)
}