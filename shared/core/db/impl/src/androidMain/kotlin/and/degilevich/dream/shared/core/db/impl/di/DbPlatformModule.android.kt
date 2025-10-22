package and.degilevich.dream.shared.core.db.impl.di

import and.degilevich.dream.shared.core.db.impl.database.builder.AppDatabaseBuilderFactory
import and.degilevich.dream.shared.core.db.impl.database.builder.AppDatabaseBuilderFactoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

internal actual fun dbPlatformModule() = module {
    singleOf(::AppDatabaseBuilderFactoryImpl) bind AppDatabaseBuilderFactory::class
}