package and.degilevich.dream.shared.feature.playlist.data.impl.repository

import and.degilevich.dream.shared.feature.playlist.data.impl.local.FakePlaylistLocalDataSource
import and.degilevich.dream.shared.feature.playlist.data.impl.remote.FakePlaylistRemoteDataSource
import and.degilevich.dream.shared.feature.playlist.model.artifact.api.data.PlaylistId
import and.degilevich.dream.shared.feature.playlist.model.artifact.api.data.SimplifiedPlaylistData
import and.degilevich.dream.shared.feature.playlist.model.core.api.data.PlaylistData
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getCurrentUserPlaylists.GetCurrentUserPlaylistsParams
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getCurrentUserPlaylists.GetCurrentUserPlaylistsResult
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getPlaylist.GetPlaylistParams
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getPlaylist.GetPlaylistResult
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getPlaylistTracks.GetPlaylistTracksParams
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getPlaylistTracks.GetPlaylistTracksResult
import and.degilevich.dream.shared.feature.playlist.model.core.test.data.playlistData
import and.degilevich.dream.shared.feature.playlist.model.core.test.data.playlistTrackData
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

class PlaylistRepositoryImplTest {

    @Test
    fun `getCurrentUserPlaylists - delegates to remote data source and returns its result unchanged`() = runTest {
        val expected = Result.success(
            GetCurrentUserPlaylistsResult(
                playlists = listOf(SimplifiedPlaylistData.empty())
            )
        )
        val repository = PlaylistRepositoryImpl(
            playlistRemoteDataSource = FakePlaylistRemoteDataSource(
                onGetCurrentUserPlaylists = { expected }
            ),
            playlistLocalDataSource = FakePlaylistLocalDataSource()
        )

        val result = repository.getCurrentUserPlaylists(
            params = GetCurrentUserPlaylistsParams(
                limit = 10,
                offset = 0
            )
        )

        result shouldBe expected
    }

    @Test
    fun `getCurrentUserPlaylists - passes params through to remote data source unchanged`() = runTest {
        val receivedParams = mutableListOf<GetCurrentUserPlaylistsParams>()
        val repository = PlaylistRepositoryImpl(
            playlistRemoteDataSource = FakePlaylistRemoteDataSource(
                onGetCurrentUserPlaylists = { params ->
                    receivedParams.add(params)
                    Result.success(GetCurrentUserPlaylistsResult(playlists = emptyList()))
                }
            ),
            playlistLocalDataSource = FakePlaylistLocalDataSource()
        )
        val params = GetCurrentUserPlaylistsParams(
            limit = 5,
            offset = 20
        )

        repository.getCurrentUserPlaylists(params = params)

        receivedParams shouldBe listOf(params)
    }

    @Test
    fun `getPlaylist - delegates to remote data source and returns its result unchanged`() = runTest {
        val expected = Result.success(GetPlaylistResult(playlist = playlistData(id = "playlist-1")))
        val receivedParams = mutableListOf<GetPlaylistParams>()
        val repository = PlaylistRepositoryImpl(
            playlistRemoteDataSource = FakePlaylistRemoteDataSource(
                onGetPlaylist = { params ->
                    receivedParams.add(params)
                    expected
                }
            ),
            playlistLocalDataSource = FakePlaylistLocalDataSource()
        )
        val params = GetPlaylistParams(id = PlaylistId(value = "playlist-1"))

        val result = repository.getPlaylist(params = params)

        result shouldBe expected
        receivedParams shouldBe listOf(params)
    }

    @Test
    fun `getPlaylistTracks - delegates to remote data source and returns its result unchanged`() = runTest {
        val expected = Result.success(
            GetPlaylistTracksResult(
                tracks = listOf(playlistTrackData(id = "track-1")),
                total = 1
            )
        )
        val receivedParams = mutableListOf<GetPlaylistTracksParams>()
        val repository = PlaylistRepositoryImpl(
            playlistRemoteDataSource = FakePlaylistRemoteDataSource(
                onGetPlaylistTracks = { params ->
                    receivedParams.add(params)
                    expected
                }
            ),
            playlistLocalDataSource = FakePlaylistLocalDataSource()
        )
        val params = GetPlaylistTracksParams(
            id = PlaylistId(value = "playlist-1"),
            limit = 50,
            offset = 100
        )

        val result = repository.getPlaylistTracks(params = params)

        result shouldBe expected
        receivedParams shouldBe listOf(params)
    }

    @Test
    fun `cachePlaylist - delegates to local data source`() = runTest {
        val saved = mutableListOf<PlaylistData>()
        val repository = PlaylistRepositoryImpl(
            playlistRemoteDataSource = FakePlaylistRemoteDataSource(),
            playlistLocalDataSource = FakePlaylistLocalDataSource(onSavePlaylist = { saved.add(it) })
        )
        val playlist = playlistData(id = "playlist-1")

        repository.cachePlaylist(playlist = playlist)

        saved shouldBe listOf(playlist)
    }

    @Test
    fun `cachePlaylists - delegates to local data source`() = runTest {
        val savedPlaylists = mutableListOf<List<SimplifiedPlaylistData>>()
        val repository = PlaylistRepositoryImpl(
            playlistRemoteDataSource = FakePlaylistRemoteDataSource(),
            playlistLocalDataSource = FakePlaylistLocalDataSource(
                onSavePlaylists = { savedPlaylists.add(it) }
            )
        )
        val playlists = listOf(SimplifiedPlaylistData.empty())

        repository.cachePlaylists(playlists = playlists)

        savedPlaylists shouldBe listOf(playlists)
    }
}
