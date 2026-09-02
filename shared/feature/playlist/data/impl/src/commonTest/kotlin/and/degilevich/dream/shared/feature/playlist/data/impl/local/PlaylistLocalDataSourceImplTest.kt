package and.degilevich.dream.shared.feature.playlist.data.impl.local

import and.degilevich.dream.shared.core.db.api.dao.PlaylistDao
import and.degilevich.dream.shared.core.db.api.entity.PlaylistEntity
import and.degilevich.dream.shared.core.db.test.dao.FakePlaylistDao
import and.degilevich.dream.shared.core.db.test.database.FakeAppDatabase
import and.degilevich.dream.shared.core.db.test.entity.playlistEntity
import and.degilevich.dream.shared.feature.playlist.data.mapper.api.local.PlaylistDataToEntityMapper
import and.degilevich.dream.shared.feature.playlist.data.mapper.api.local.SimplifiedPlaylistDataToEntityMapper
import and.degilevich.dream.shared.feature.playlist.data.mapper.test.local.FakePlaylistDataToEntityMapper
import and.degilevich.dream.shared.feature.playlist.data.mapper.test.local.FakeSimplifiedPlaylistDataToEntityMapper
import and.degilevich.dream.shared.feature.playlist.model.artifact.test.data.simplifiedPlaylistData
import and.degilevich.dream.shared.feature.playlist.model.core.test.data.playlistData
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

class PlaylistLocalDataSourceImplTest {

    @Test
    fun `savePlaylists - upserts all playlists mapped through the entity mapper`() = runTest {
        val upsertedAll = mutableListOf<List<PlaylistEntity>>()
        val dataSource = createDataSource(
            playlistDao = FakePlaylistDao(onUpsertAll = { upsertedAll.add(it) }),
            simplifiedPlaylistDataToEntityMapper = FakeSimplifiedPlaylistDataToEntityMapper(
                onMap = { playlist -> playlistEntity(id = playlist.id.value) }
            )
        )
        val playlists = listOf(
            simplifiedPlaylistData(id = "playlist-1"),
            simplifiedPlaylistData(id = "playlist-2")
        )

        dataSource.savePlaylists(playlists = playlists)

        upsertedAll shouldBe listOf(
            listOf(
                playlistEntity(id = "playlist-1"),
                playlistEntity(id = "playlist-2")
            )
        )
    }

    @Test
    fun `savePlaylists - empty list - upserts an empty list`() = runTest {
        val upsertedAll = mutableListOf<List<PlaylistEntity>>()
        val dataSource = createDataSource(
            playlistDao = FakePlaylistDao(onUpsertAll = { upsertedAll.add(it) })
        )

        dataSource.savePlaylists(playlists = emptyList())

        upsertedAll shouldBe listOf(emptyList())
    }

    @Test
    fun `savePlaylist - upserts the playlist mapped through the playlist entity mapper`() = runTest {
        val upserted = mutableListOf<PlaylistEntity>()
        val dataSource = createDataSource(
            playlistDao = FakePlaylistDao(onUpsert = { upserted.add(it) }),
            playlistDataToEntityMapper = FakePlaylistDataToEntityMapper(
                onMap = { playlist -> playlistEntity(id = playlist.id.value) }
            )
        )

        dataSource.savePlaylist(playlist = playlistData(id = "playlist-3"))

        upserted shouldBe listOf(playlistEntity(id = "playlist-3"))
    }

    private fun createDataSource(
        playlistDao: PlaylistDao = FakePlaylistDao(),
        simplifiedPlaylistDataToEntityMapper: SimplifiedPlaylistDataToEntityMapper =
            FakeSimplifiedPlaylistDataToEntityMapper(),
        playlistDataToEntityMapper: PlaylistDataToEntityMapper = FakePlaylistDataToEntityMapper()
    ) = PlaylistLocalDataSourceImpl(
        database = FakeAppDatabase(onGetPlaylistDao = { playlistDao }),
        simplifiedPlaylistDataToEntityMapper = simplifiedPlaylistDataToEntityMapper,
        playlistDataToEntityMapper = playlistDataToEntityMapper
    )
}
