package and.degilevich.dream.shared.core.db.api.dao

import and.degilevich.dream.shared.core.db.api.entity.TrackEntity
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface TrackDao {

    @Upsert
    suspend fun upsert(entity: TrackEntity)

    @Upsert
    suspend fun upsertAll(entities: List<TrackEntity>)

    @Query("DELETE FROM ${TrackEntity.TABLE_NAME}")
    suspend fun deleteAll()
}