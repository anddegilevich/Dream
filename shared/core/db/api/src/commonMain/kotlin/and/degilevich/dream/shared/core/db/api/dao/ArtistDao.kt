package and.degilevich.dream.shared.core.db.api.dao

import and.degilevich.dream.shared.core.db.api.entity.ArtistEntity
import androidx.room.Dao
import androidx.room.Upsert

@Dao
interface ArtistDao {

    @Upsert
    suspend fun upsert(entity: ArtistEntity)

    @Upsert
    suspend fun upsertAll(entities: List<ArtistEntity>)
}