package and.degilevich.dream.shared.feature.artist.core.impl.source.local

import and.degilevich.dream.shared.core.db.api.feature.artist.dao.ArtistDao
import and.degilevich.dream.shared.template.source.local.LocalDataSourceTemplate
import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData
import and.degilevich.dream.shared.feature.artist.core.api.source.model.request.getArtists.GetArtistsParams
import and.degilevich.dream.shared.feature.artist.core.api.source.local.ArtistLocalDataSource
import and.degilevich.dream.shared.feature.artist.model.core.api.mapper.ArtistDataToEntityMapper
import and.degilevich.dream.shared.feature.artist.model.core.api.mapper.ArtistEntityToDataMapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith
import and.degilevich.dream.shared.foundation.primitive.result.foldResultSuccess

internal class ArtistLocalDataSourceImpl(
    private val artistEntityToDataMapper: ArtistEntityToDataMapper,
    private val artistDataToEntityMapper: ArtistDataToEntityMapper
) : ArtistLocalDataSource, LocalDataSourceTemplate() {

    private val artistDao: ArtistDao by lazy { database.getArtistDao() }

    override suspend fun getArtist(id: String): Result<ArtistData> {
        return artistDao.getById(id = id).foldNullableEntity().foldResultSuccess { entity ->
            entity.mapWith(artistEntityToDataMapper)
        }
    }

    override suspend fun saveArtist(artist: ArtistData) {
        return artistDao.insert(entity = artist.mapWith(artistDataToEntityMapper))
    }

    override suspend fun saveArtists(artists: List<ArtistData>) {
        return artistDao.insertAll(
            entities = artists.map { artist ->
                artist.mapWith(artistDataToEntityMapper)
            }
        )
    }

    override suspend fun getArtists(params: GetArtistsParams): List<ArtistData> {
        return artistDao.getByIds(ids = params.ids).map { entity ->
            entity.mapWith(artistEntityToDataMapper)
        }
    }
}