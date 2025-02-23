//https://github.com/detekt/detekt/issues/7769
@file:Suppress("MatchingDeclarationName")

package and.degilevich.dream.shared.core.db.impl.database.builder

import and.degilevich.dream.shared.core.db.impl.database.DreamDatabaseAbs
import and.degilevich.dream.shared.core.db.impl.database.DreamDatabaseConst
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

internal actual class DreamDatabaseBuilderFactoryImpl(
    private val context: Context
) : DreamDatabaseBuilderFactory {

    override fun create(): RoomDatabase.Builder<DreamDatabaseAbs> {
        val appContext = context.applicationContext
        val dbFile = appContext.getDatabasePath(DreamDatabaseConst.DATABASE_FILE_NAME)
        return Room.databaseBuilder<DreamDatabaseAbs>(
            context = appContext,
            name = dbFile.absolutePath
        )
    }
}