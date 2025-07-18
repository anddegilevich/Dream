package and.degilevich.dream.shared.core.db.impl.database.builder

import and.degilevich.dream.shared.core.db.impl.database.AbstractAppDatabase
import and.degilevich.dream.shared.core.db.impl.database.AppDatabaseConst
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

internal actual class AppDatabaseBuilderFactoryImpl(
    private val context: Context
) : AppDatabaseBuilderFactory {

    override fun create(): RoomDatabase.Builder<AbstractAppDatabase> {
        val appContext = context.applicationContext
        val dbFile = appContext.getDatabasePath(AppDatabaseConst.DATABASE_FILE_NAME)
        return Room.databaseBuilder<AbstractAppDatabase>(
            context = appContext,
            name = dbFile.absolutePath
        )
    }
}