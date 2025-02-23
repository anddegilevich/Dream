package and.degilevich.dream.shared.core.db.api.feature.artist.dao

import and.degilevich.dream.shared.core.db.api.feature.artist.entity.ArtistEntity
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ArtistDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: ArtistEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(entities: List<ArtistEntity>)

    @Query("SELECT * FROM ${ArtistEntity.TABLE_NAME}")
    suspend fun getAll(): List<ArtistEntity>

    @Query("SELECT * FROM ${ArtistEntity.TABLE_NAME} where ${ArtistEntity.ID} in (:ids)")
    suspend fun getByIds(ids: List<String>): List<ArtistEntity>

    @Query("SELECT * FROM ${ArtistEntity.TABLE_NAME} WHERE ${ArtistEntity.ID} == :id")
    suspend fun getById(id: String): ArtistEntity?

    @Query("SELECT * FROM ${ArtistEntity.TABLE_NAME} WHERE ${ArtistEntity.ID} == :id")
    fun getByIdAsFlow(id: String): Flow<ArtistEntity?>
}