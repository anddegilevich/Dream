package and.degilevich.dream.shared.feature.album.data.impl.repository

import and.degilevich.dream.shared.feature.album.data.impl.local.FakeAlbumLocalDataSource
import and.degilevich.dream.shared.feature.album.data.impl.remote.FakeAlbumRemoteDataSource
import and.degilevich.dream.shared.feature.album.model.artifact.api.data.AlbumId
import and.degilevich.dream.shared.feature.album.model.artifact.api.data.SimplifiedAlbumData
import and.degilevich.dream.shared.feature.album.model.core.api.data.AlbumData
import and.degilevich.dream.shared.feature.album.model.core.api.method.getAlbum.GetAlbumParams
import and.degilevich.dream.shared.feature.album.model.core.api.method.getAlbum.GetAlbumResult
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

class AlbumRepositoryImplTest {

    @Test
    fun `getAlbum - delegates to remote data source and returns its result unchanged`() = runTest {
        val getAlbumResult = Result.success(GetAlbumResult(album = AlbumData.empty()))
        val remoteDataSource = FakeAlbumRemoteDataSource(onGetAlbum = { getAlbumResult })
        val repository = AlbumRepositoryImpl(
            albumRemoteDataSource = remoteDataSource,
            albumLocalDataSource = FakeAlbumLocalDataSource()
        )
        val params = GetAlbumParams(id = AlbumId(value = "album-1"))
        val result = repository.getAlbum(params)
        result shouldBe getAlbumResult
    }

    @Test
    fun `cacheAlbum - delegates to local data source`() = runTest {
        val savedAlbums = mutableListOf<AlbumData>()
        val repository = AlbumRepositoryImpl(
            albumRemoteDataSource = FakeAlbumRemoteDataSource(),
            albumLocalDataSource = FakeAlbumLocalDataSource(onSaveAlbum = { savedAlbums.add(it) })
        )
        val album = AlbumData.empty()
        repository.cacheAlbum(album)
        savedAlbums shouldBe listOf(album)
    }

    @Test
    fun `cacheAlbums - delegates to local data source`() = runTest {
        val savedAlbumLists = mutableListOf<List<SimplifiedAlbumData>>()
        val repository = AlbumRepositoryImpl(
            albumRemoteDataSource = FakeAlbumRemoteDataSource(),
            albumLocalDataSource = FakeAlbumLocalDataSource(onSaveAlbums = { savedAlbumLists.add(it) })
        )
        val albums = listOf(SimplifiedAlbumData.empty())
        repository.cacheAlbums(albums)
        savedAlbumLists shouldBe listOf(albums)
    }
}
