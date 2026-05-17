package and.degilevich.dream.shared.di.feature

import and.degilevich.dream.shared.feature.search.data.mapper.impl.di.searchDataMapperModule
import and.degilevich.dream.shared.feature.search.ui.impl.di.searchUiModule
import and.degilevich.dream.shared.feature.search.domain.impl.di.searchDomainModule
import and.degilevich.dream.shared.feature.search.data.impl.di.searchDataModule
import org.koin.dsl.module

fun searchModule() = module {
    includes(searchDataMapperModule())
    includes(searchDataModule())
    includes(searchDomainModule())
    includes(searchUiModule())
}