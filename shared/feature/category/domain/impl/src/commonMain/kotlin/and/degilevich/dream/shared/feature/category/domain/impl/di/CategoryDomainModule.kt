package and.degilevich.dream.shared.feature.category.domain.impl.di

import and.degilevich.dream.shared.feature.category.domain.api.usecase.FetchCategoriesUseCase
import and.degilevich.dream.shared.feature.category.domain.api.usecase.FetchCategoryUseCase
import and.degilevich.dream.shared.feature.category.domain.impl.usecase.FetchCategoriesUseCaseImpl
import and.degilevich.dream.shared.feature.category.domain.impl.usecase.FetchCategoryUseCaseImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun categoryDomainModule() = module {
    factoryOf(::FetchCategoriesUseCaseImpl) bind FetchCategoriesUseCase::class
    factoryOf(::FetchCategoryUseCaseImpl) bind FetchCategoryUseCase::class
}