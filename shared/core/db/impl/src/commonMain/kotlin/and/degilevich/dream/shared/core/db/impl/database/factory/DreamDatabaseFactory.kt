package and.degilevich.dream.shared.core.db.impl.database.factory

import and.degilevich.dream.shared.core.db.api.database.DreamDatabase

internal interface DreamDatabaseFactory {
    fun create(): DreamDatabase
}