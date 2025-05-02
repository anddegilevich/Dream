package and.degilevich.dream.shared.feature.artist.core.impl.source.local

import and.degilevich.dream.shared.core.db.api.feature.artist.dao.ArtistDao
import and.degilevich.dream.shared.template.source.local.LocalDataSourceTemplate
import and.degilevich.dream.shared.feature.artist.model.core.data.ArtistData
import and.degilevich.dream.shared.feature.artist.core.api.source.model.request.getArtists.GetArtistsParams
import and.degilevich.dream.shared.feature.artist.core.api.source.local.ArtistLocalDataSource
import and.degilevich.dream.shared.feature.artist.model.core.mappers.mapToData
import and.degilevich.dream.shared.feature.artist.model.core.mappers.mapToEntity
import and.degilevich.dream.shared.foundation.primitive.result.foldResultSuccess

internal class ArtistLocalDataSourceImpl : ArtistLocalDataSource, LocalDataSourceTemplate() {

    private val artistDao: ArtistDao by lazy { database.getArtistDao() }

    override suspend fun getArtist(id: String): Result<ArtistData> {
        return artistDao.getById(id = id).foldNullableEntity().foldResultSuccess { entity ->
            entity.mapToData()
        }
    }

    override suspend fun saveArtist(artist: ArtistData) {
        return artistDao.insert(entity = artist.mapToEntity())
    }

    override suspend fun saveArtists(artists: List<ArtistData>) {
        return artistDao.insertAll(
            entities = artists.map { artist ->
                artist.mapToEntity()
            }
        )
    }

    override suspend fun getArtists(params: GetArtistsParams): List<ArtistData> {
        return artistDao.getByIds(ids = params.ids).map { entity ->
            entity.mapToData()
        }
    }
}