package and.degilevich.dream.shared.feature.album.data.impl.local

import and.degilevich.dream.shared.feature.album.model.artifact.api.data.SimplifiedAlbumData
import and.degilevich.dream.shared.feature.album.model.core.api.data.AlbumData

internal interface AlbumLocalDataSource {
    suspend fun saveAlbum(album: AlbumData)
    suspend fun saveAlbums(albums: List<SimplifiedAlbumData>)
}