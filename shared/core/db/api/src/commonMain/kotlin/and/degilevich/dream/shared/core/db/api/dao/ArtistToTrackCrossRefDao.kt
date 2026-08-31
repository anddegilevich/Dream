package and.degilevich.dream.shared.core.db.api.dao

import and.degilevich.dream.shared.core.db.api.entity.crossRef.ArtistToTrackCrossRefEntity
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface ArtistToTrackCrossRefDao {

    @Upsert
    suspend fun upsertAll(entities: List<ArtistToTrackCrossRefEntity>)

    @Query("DELETE FROM ${ArtistToTrackCrossRefEntity.TABLE_NAME}")
    suspend fun deleteAll()
}