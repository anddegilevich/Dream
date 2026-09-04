package and.degilevich.dream.shared.feature.search.component.search.impl.di

import and.degilevich.dream.shared.feature.search.component.search.api.component.SearchComponentFactory
import and.degilevich.dream.shared.feature.search.component.search.impl.component.SearchComponentFactoryImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun searchComponentModule() = module {
    factoryOf(::SearchComponentFactoryImpl) bind SearchComponentFactory::class
}
