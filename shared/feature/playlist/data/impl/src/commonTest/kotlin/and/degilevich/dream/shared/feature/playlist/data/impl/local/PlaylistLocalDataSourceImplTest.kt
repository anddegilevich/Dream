package and.degilevich.dream.shared.feature.playlist.data.impl.local

import and.degilevich.dream.shared.core.db.api.dao.PlaylistDao
import and.degilevich.dream.shared.core.db.api.entity.PlaylistEntity
import and.degilevich.dream.shared.core.db.test.dao.FakePlaylistDao
import and.degilevich.dream.shared.core.db.test.database.FakeAppDatabase
import and.degilevich.dream.shared.core.db.test.entity.playlistEntity
import and.degilevich.dream.shared.feature.playlist.data.mapper.api.local.SimplifiedPlaylistDataToEntityMapper
import and.degilevich.dream.shared.feature.playlist.data.mapper.test.local.FakeSimplifiedPlaylistDataToEntityMapper
import and.degilevich.dream.shared.feature.playlist.model.artifact.test.data.simplifiedPlaylistData
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

    private fun createDataSource(
        playlistDao: PlaylistDao = FakePlaylistDao(),
        simplifiedPlaylistDataToEntityMapper: SimplifiedPlaylistDataToEntityMapper =
            FakeSimplifiedPlaylistDataToEntityMapper()
    ) = PlaylistLocalDataSourceImpl(
        database = FakeAppDatabase(onGetPlaylistDao = { playlistDao }),
        simplifiedPlaylistDataToEntityMapper = simplifiedPlaylistDataToEntityMapper
    )
}
