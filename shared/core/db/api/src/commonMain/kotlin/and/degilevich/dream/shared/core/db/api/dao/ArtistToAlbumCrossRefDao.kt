package and.degilevich.dream.shared.core.db.api.dao

import and.degilevich.dream.shared.core.db.api.entity.crossRef.ArtistToAlbumCrossRefEntity
import androidx.room.Dao
import androidx.room.Upsert

@Dao
interface ArtistToAlbumCrossRefDao {

    @Upsert
    suspend fun upsertAll(entities: List<ArtistToAlbumCrossRefEntity>)
}