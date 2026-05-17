package and.degilevich.dream.shared.feature.album.data.impl.local

import and.degilevich.dream.shared.feature.album.model.artifact.data.AlbumSimplifiedData
import and.degilevich.dream.shared.feature.album.model.core.data.AlbumData

internal interface AlbumLocalDataSource {
    suspend fun saveAlbum(album: AlbumData)
    suspend fun saveAlbums(albums: List<AlbumSimplifiedData>)
}