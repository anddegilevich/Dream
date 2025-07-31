package and.degilevich.dream.shared.di.feature

import and.degilevich.dream.shared.feature.search.design.impl.di.searchDesignModule
import and.degilevich.dream.shared.feature.search.domain.impl.di.searchDomainModule
import and.degilevich.dream.shared.feature.search.model.core.impl.di.searchModelCoreModule
import and.degilevich.dream.shared.feature.search.source.impl.di.searchSourceModule
import org.koin.dsl.module

fun searchModule() = module {
    includes(searchModelCoreModule())
    includes(searchSourceModule())
    includes(searchDomainModule())
    includes(searchDesignModule())
}