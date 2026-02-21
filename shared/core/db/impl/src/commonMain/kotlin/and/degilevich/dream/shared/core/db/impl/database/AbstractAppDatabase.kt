package and.degilevich.dream.shared.core.db.impl.database

import and.degilevich.dream.shared.core.db.api.database.AppDatabase
import and.degilevich.dream.shared.core.db.api.entity.AlbumEntity
import and.degilevich.dream.shared.core.db.api.entity.ArtistEntity
import and.degilevich.dream.shared.core.db.api.entity.TrackEntity
import and.degilevich.dream.shared.core.db.api.entity.crossRef.ArtistToAlbumCrossRefEntity
import and.degilevich.dream.shared.core.db.api.entity.crossRef.ArtistToTrackCrossRefEntity
import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        ArtistEntity::class,
        AlbumEntity::class,
        TrackEntity::class,

        ArtistToAlbumCrossRefEntity::class,
        ArtistToTrackCrossRefEntity::class
    ],
    version = AppDatabaseConst.DATABASE_VERSION,
    exportSchema = false
)
@ConstructedBy(AppDatabaseConstructor::class)
internal abstract class AbstractAppDatabase : RoomDatabase(), AppDatabase