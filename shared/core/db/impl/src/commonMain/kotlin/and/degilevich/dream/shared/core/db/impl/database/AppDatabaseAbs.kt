package and.degilevich.dream.shared.core.db.impl.database

import and.degilevich.dream.shared.core.db.api.database.AppDatabase
import and.degilevich.dream.shared.core.db.api.feature.artist.entity.ArtistEntity
import and.degilevich.dream.shared.core.db.api.feature.artist.entity.ArtistFollowersEntity
import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        ArtistEntity::class,
        ArtistFollowersEntity::class
    ],
    version = AppDatabaseConst.DATABASE_VERSION,
    exportSchema = false
)
@ConstructedBy(AppDatabaseConstructor::class)
internal abstract class AppDatabaseAbs : RoomDatabase(), AppDatabase