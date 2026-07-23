package and.degilevich.dream.shared.di.feature

import and.degilevich.dream.shared.feature.search.component.search.impl.di.searchComponentModule
import and.degilevich.dream.shared.feature.search.data.impl.di.searchDataModule
import and.degilevich.dream.shared.feature.search.data.mapper.impl.di.searchDataMapperModule
import and.degilevich.dream.shared.feature.search.domain.impl.di.searchDomainModule
import and.degilevich.dream.shared.feature.search.ui.impl.di.searchUIModule
import org.koin.dsl.module

fun searchModule() = module {
    includes(searchDataMapperModule())
    includes(searchDataModule())
    includes(searchDomainModule())
    includes(searchUIModule())
    includes(searchComponentModule())
}