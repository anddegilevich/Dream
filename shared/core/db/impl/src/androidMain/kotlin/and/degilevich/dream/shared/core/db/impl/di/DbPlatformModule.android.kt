package and.degilevich.dream.shared.core.db.impl.di

import and.degilevich.dream.shared.core.db.impl.database.builder.DreamDatabaseBuilderFactory
import and.degilevich.dream.shared.core.db.impl.database.builder.DreamDatabaseBuilderFactoryImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

internal actual fun dbPlatformModule() = module {
    factoryOf(::DreamDatabaseBuilderFactoryImpl) bind DreamDatabaseBuilderFactory::class
}