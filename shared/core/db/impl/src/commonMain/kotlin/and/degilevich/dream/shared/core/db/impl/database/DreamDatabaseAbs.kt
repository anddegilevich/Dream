package and.degilevich.dream.shared.core.db.impl.database

import and.degilevich.dream.shared.core.db.api.database.DreamDatabase
import and.degilevich.dream.shared.core.db.api.feature.artist.entity.ArtistEntity
import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ArtistEntity::class],
    version = DreamDatabaseConst.DATABASE_VERSION,
    exportSchema = false
)
@ConstructedBy(DreamDatabaseConstructor::class)
internal abstract class DreamDatabaseAbs : RoomDatabase(), DreamDatabase