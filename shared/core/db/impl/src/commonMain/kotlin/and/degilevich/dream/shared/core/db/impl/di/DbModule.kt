package and.degilevich.dream.shared.core.db.impl.di

import and.degilevich.dream.shared.core.db.api.database.AppDatabase
import and.degilevich.dream.shared.core.db.impl.database.factory.AppDatabaseFactory
import and.degilevich.dream.shared.core.db.impl.database.factory.AppDatabaseFactoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun dbModule() = module {
    includes(dbPlatformModule())
    singleOf(::AppDatabaseFactoryImpl) bind AppDatabaseFactory::class
    single {
        val databaseFactory: AppDatabaseFactory = get()
        databaseFactory.create()
    } bind AppDatabase::class
}