package and.degilevich.dream.shared.feature.album.source.api.local

import and.degilevich.dream.shared.feature.album.model.artifact.api.data.AlbumSimplifiedData
import and.degilevich.dream.shared.feature.album.model.core.api.data.AlbumData

interface AlbumLocalDataSource {
    suspend fun saveAlbum(album: AlbumData)
    suspend fun saveAlbums(albums: List<AlbumSimplifiedData>)
}