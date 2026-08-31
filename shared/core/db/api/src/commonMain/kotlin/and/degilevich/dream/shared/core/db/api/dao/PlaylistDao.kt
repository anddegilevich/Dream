package and.degilevich.dream.shared.core.db.api.dao

import and.degilevich.dream.shared.core.db.api.entity.PlaylistEntity
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface PlaylistDao {

    @Upsert
    suspend fun upsert(entity: PlaylistEntity)

    @Upsert
    suspend fun upsertAll(entities: List<PlaylistEntity>)

    @Query("DELETE FROM ${PlaylistEntity.TABLE_NAME}")
    suspend fun deleteAll()
}
