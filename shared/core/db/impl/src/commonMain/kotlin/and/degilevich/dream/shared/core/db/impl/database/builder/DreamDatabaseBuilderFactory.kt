package and.degilevich.dream.shared.core.db.impl.database.builder

import and.degilevich.dream.shared.core.db.impl.database.DreamDatabaseAbs
import androidx.room.RoomDatabase

internal interface DreamDatabaseBuilderFactory {
    fun create(): RoomDatabase.Builder<DreamDatabaseAbs>
}