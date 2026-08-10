package and.degilevich.dream.shared.feature.album.data.impl.local

import and.degilevich.dream.shared.feature.album.model.artifact.api.data.SimplifiedAlbumData
import and.degilevich.dream.shared.feature.album.model.core.api.data.AlbumData
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeAlbumLocalDataSource(
    private val onSaveAlbum: (AlbumData) -> Unit = { fakeImplementationError() },
    private val onSaveAlbums: (List<SimplifiedAlbumData>) -> Unit = { fakeImplementationError() }
) : AlbumLocalDataSource {

    override suspend fun saveAlbum(album: AlbumData) {
        onSaveAlbum(album)
    }

    override suspend fun saveAlbums(albums: List<SimplifiedAlbumData>) {
        onSaveAlbums(albums)
    }
}