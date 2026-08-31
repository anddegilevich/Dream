package and.degilevich.dream.shared.feature.playlist.data.impl.local

import and.degilevich.dream.shared.core.db.api.dao.PlaylistDao
import and.degilevich.dream.shared.core.db.api.database.AppDatabase
import and.degilevich.dream.shared.feature.playlist.data.mapper.api.local.SimplifiedPlaylistDataToEntityMapper
import and.degilevich.dream.shared.feature.playlist.model.artifact.api.data.SimplifiedPlaylistData
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith

internal class PlaylistLocalDataSourceImpl(
    private val database: AppDatabase,
    private val simplifiedPlaylistDataToEntityMapper: SimplifiedPlaylistDataToEntityMapper
) : PlaylistLocalDataSource {

    private val playlistDao: PlaylistDao by lazy { database.getPlaylistDao() }

    override suspend fun savePlaylists(playlists: List<SimplifiedPlaylistData>) {
        playlistDao.upsertAll(playlists.mapWith(simplifiedPlaylistDataToEntityMapper))
    }
}
