package and.degilevich.dream.shared.core.db.impl.database.factory

import and.degilevich.dream.shared.core.db.api.database.DreamDatabase
import and.degilevich.dream.shared.core.db.impl.database.builder.DreamDatabaseBuilderFactory
import and.degilevich.dream.shared.foundation.dispatcher.DefaultKMPDispatchers
import androidx.sqlite.driver.bundled.BundledSQLiteDriver

internal class DreamDatabaseFactoryImpl(
    private val databaseBuilderFactory: DreamDatabaseBuilderFactory
) : DreamDatabaseFactory {

    private val databaseBuilder by lazy { databaseBuilderFactory.create() }

    override fun create(): DreamDatabase {
        return databaseBuilder
            .fallbackToDestructiveMigration(
                dropAllTables = true
            )
            .setDriver(BundledSQLiteDriver())
            .setQueryCoroutineContext(DefaultKMPDispatchers.background)
            .build()
    }
}