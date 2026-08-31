package and.degilevich.dream.shared.core.db.api.dao

import and.degilevich.dream.shared.core.db.api.entity.AlbumEntity
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface AlbumDao {

    @Upsert
    suspend fun upsert(entity: AlbumEntity)

    @Upsert
    suspend fun upsertAll(entities: List<AlbumEntity>)

    @Query("DELETE FROM ${AlbumEntity.TABLE_NAME}")
    suspend fun deleteAll()
}