package and.degilevich.dream.shared.core.db.impl.database.builder

import and.degilevich.dream.shared.core.db.impl.database.AppDatabaseAbs
import androidx.room.RoomDatabase

internal interface AppDatabaseBuilderFactory {
    fun create(): RoomDatabase.Builder<AppDatabaseAbs>
}