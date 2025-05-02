package and.degilevich.dream.shared.core.db.impl.database.factory

import and.degilevich.dream.shared.core.db.api.database.AppDatabase
import and.degilevich.dream.shared.core.db.impl.database.builder.AppDatabaseBuilderFactory
import and.degilevich.dream.shared.foundation.coroutine.dispatcher.DefaultKMPDispatchers
import androidx.sqlite.driver.bundled.BundledSQLiteDriver

internal class AppDatabaseFactoryImpl(
    private val databaseBuilderFactory: AppDatabaseBuilderFactory
) : AppDatabaseFactory {

    private val databaseBuilder by lazy { databaseBuilderFactory.create() }

    override fun create(): AppDatabase {
        return databaseBuilder
            .setDriver(driver = BundledSQLiteDriver())
            .setQueryCoroutineContext(context = DefaultKMPDispatchers.background)
            .build()
    }
}