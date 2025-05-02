package and.degilevich.dream.shared.core.db.impl.database.factory

import and.degilevich.dream.shared.core.db.api.database.AppDatabase

internal interface AppDatabaseFactory {
    fun create(): AppDatabase
}