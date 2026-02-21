package and.degilevich.dream.shared.feature.artist.source.impl.local

import and.degilevich.dream.shared.core.db.api.dao.ArtistDao
import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData
import and.degilevich.dream.shared.feature.artist.source.api.local.ArtistLocalDataSource
import and.degilevich.dream.shared.feature.artist.source.api.local.mapper.ArtistDataToEntityMapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith
import and.degilevich.dream.shared.template.source.impl.local.BaseLocalDataSource

internal class ArtistLocalDataSourceImpl(
    private val artistDataToEntityMapper: ArtistDataToEntityMapper
) : ArtistLocalDataSource, BaseLocalDataSource() {

    private val artistDao: ArtistDao by lazy { database.getArtistDao() }

    override suspend fun saveArtists(artists: List<ArtistData>) {
        artistDao.upsertAll(artists.mapWith(artistDataToEntityMapper))
    }

    override suspend fun saveArtist(artist: ArtistData) {
        artistDao.upsert(artist.mapWith(artistDataToEntityMapper))
    }
}