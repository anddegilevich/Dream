package and.degilevich.dream.shared.core.db.impl.di

import and.degilevich.dream.shared.core.db.api.database.DreamDatabase
import and.degilevich.dream.shared.core.db.impl.database.factory.DreamDatabaseFactory
import and.degilevich.dream.shared.core.db.impl.database.factory.DreamDatabaseFactoryImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun dbModule() = module {
    includes(dbPlatformModule())
    factoryOf(::DreamDatabaseFactoryImpl) bind DreamDatabaseFactory::class
    single {
        val databaseFactory: DreamDatabaseFactory = get()
        databaseFactory.create()
    } bind DreamDatabase::class
}