package and.degilevich.dream.shared.di.feature

import and.degilevich.dream.shared.feature.category.domain.impl.di.categoryDomainModule
import and.degilevich.dream.shared.feature.category.source.impl.di.categorySourceModule
import org.koin.dsl.module

fun categoryModule() = module {
    includes(categorySourceModule())
    includes(categoryDomainModule())
}