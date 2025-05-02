package and.degilevich.dream.shared.core.db.impl.di

import and.degilevich.dream.shared.core.db.impl.database.builder.AppDatabaseBuilderFactory
import and.degilevich.dream.shared.core.db.impl.database.builder.AppDatabaseBuilderFactoryImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

internal actual fun dbPlatformModule() = module {
    factoryOf(::AppDatabaseBuilderFactoryImpl) bind AppDatabaseBuilderFactory::class
}