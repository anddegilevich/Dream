package and.degilevich.dream.shared.feature.artist.data.impl.local

import and.degilevich.dream.shared.core.db.api.dao.ArtistDao
import and.degilevich.dream.shared.core.db.api.database.AppDatabase
import and.degilevich.dream.shared.feature.artist.data.mapper.api.local.ArtistDataToEntityMapper
import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith

internal class ArtistLocalDataSourceImpl(
    private val database: AppDatabase,
    private val artistDataToEntityMapper: ArtistDataToEntityMapper
) : ArtistLocalDataSource {

    private val artistDao: ArtistDao by lazy { database.getArtistDao() }

    override suspend fun saveArtists(artists: List<ArtistData>) {
        artistDao.upsertAll(artists.mapWith(artistDataToEntityMapper))
    }

    override suspend fun saveArtist(artist: ArtistData) {
        artistDao.upsert(artist.mapWith(artistDataToEntityMapper))
    }
}