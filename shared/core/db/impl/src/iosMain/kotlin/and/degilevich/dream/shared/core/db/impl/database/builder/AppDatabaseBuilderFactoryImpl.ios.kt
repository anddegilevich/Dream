package and.degilevich.dream.shared.core.db.impl.database.builder

import and.degilevich.dream.shared.core.db.impl.database.AppDatabaseAbs
import and.degilevich.dream.shared.core.db.impl.database.AppDatabaseConst
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSUserDomainMask

internal actual class AppDatabaseBuilderFactoryImpl : AppDatabaseBuilderFactory {
    override fun create(): RoomDatabase.Builder<AppDatabaseAbs> {
        val dbFilePath = buildString {
            append(documentDirectory())
            append("/")
            append(AppDatabaseConst.DATABASE_FILE_NAME)
        }
        return Room.databaseBuilder<AppDatabaseAbs>(
            name = dbFilePath,
        )
    }

    @OptIn(ExperimentalForeignApi::class)
    private fun documentDirectory(): String {
        val documentDirectory = NSFileManager.defaultManager.URLForDirectory(
            directory = NSDocumentDirectory,
            inDomain = NSUserDomainMask,
            appropriateForURL = null,
            create = false,
            error = null,
        )
        return requireNotNull(documentDirectory?.path)
    }
}