package and.degilevich.dream.shared.feature.search.domain.impl.di

import and.degilevich.dream.shared.feature.search.domain.api.usecase.SearchUseCase
import and.degilevich.dream.shared.feature.search.domain.impl.usecase.SearchUseCaseImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun searchDomainModule() = module {
    factoryOf(::SearchUseCaseImpl) bind SearchUseCase::class
}