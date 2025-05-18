package and.degilevich.dream.shared.core.db.impl.database.factory

import and.degilevich.dream.shared.core.db.api.database.AppDatabase
import and.degilevich.dream.shared.core.db.impl.database.builder.AppDatabaseBuilderFactory
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

internal class AppDatabaseFactoryImpl(
    private val databaseBuilderFactory: AppDatabaseBuilderFactory
) : AppDatabaseFactory {

    private val databaseBuilder by lazy { databaseBuilderFactory.create() }

    override fun create(): AppDatabase {
        return databaseBuilder
            .setDriver(driver = BundledSQLiteDriver())
            .setQueryCoroutineContext(context = Dispatchers.IO)
            .build()
    }
}