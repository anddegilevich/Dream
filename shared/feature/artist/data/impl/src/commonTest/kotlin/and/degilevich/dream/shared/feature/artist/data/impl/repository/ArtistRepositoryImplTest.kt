package and.degilevich.dream.shared.feature.artist.data.impl.repository

import and.degilevich.dream.shared.feature.artist.data.impl.local.FakeArtistLocalDataSource
import and.degilevich.dream.shared.feature.artist.data.impl.remote.FakeArtistRemoteDataSource
import and.degilevich.dream.shared.feature.artist.model.artifact.api.data.ArtistId
import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtist.GetArtistParams
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtist.GetArtistResult
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtistAlbums.GetArtistAlbumsParams
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtistAlbums.GetArtistAlbumsResult
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

class ArtistRepositoryImplTest {

    @Test
    fun `getArtist - delegates to remote data source and returns its result unchanged`() = runTest {
        val getArtistResult = Result.success(GetArtistResult(artist = ArtistData.empty()))
        val repository = ArtistRepositoryImpl(
            artistRemoteDataSource = FakeArtistRemoteDataSource(onGetArtist = { getArtistResult }),
            artistLocalDataSource = FakeArtistLocalDataSource()
        )
        val result = repository.getArtist(
            params = GetArtistParams(
                id = ArtistId(value = "artist-1")
            )
        )
        result shouldBe getArtistResult
    }

    @Test
    fun `getArtistAlbums - delegates to remote data source and returns its result unchanged`() = runTest {
        val getArtistAlbumsResult = Result.success(
            GetArtistAlbumsResult(
                total = 0,
                items = emptyList()
            )
        )
        val repository = ArtistRepositoryImpl(
            artistRemoteDataSource = FakeArtistRemoteDataSource(onGetArtistAlbums = { getArtistAlbumsResult }),
            artistLocalDataSource = FakeArtistLocalDataSource()
        )
        val result = repository.getArtistAlbums(
            params = GetArtistAlbumsParams(
                id = ArtistId(value = "artist-1"),
                limit = 10,
                offset = 0
            )
        )
        result shouldBe getArtistAlbumsResult
    }

    @Test
    fun `cacheArtist - delegates to local data source`() = runTest {
        val savedArtists = mutableListOf<ArtistData>()
        val repository = ArtistRepositoryImpl(
            artistRemoteDataSource = FakeArtistRemoteDataSource(),
            artistLocalDataSource = FakeArtistLocalDataSource(onSaveArtist = { savedArtists.add(it) })
        )
        val artist = ArtistData.empty()
        repository.cacheArtist(artist)
        savedArtists shouldBe listOf(artist)
    }

    @Test
    fun `cacheArtists - delegates to local data source`() = runTest {
        val savedArtistLists = mutableListOf<List<ArtistData>>()
        val repository = ArtistRepositoryImpl(
            artistRemoteDataSource = FakeArtistRemoteDataSource(),
            artistLocalDataSource = FakeArtistLocalDataSource(onSaveArtists = { savedArtistLists.add(it) })
        )
        val artists = listOf(ArtistData.empty())
        repository.cacheArtists(artists)
        savedArtistLists shouldBe listOf(artists)
    }
}
