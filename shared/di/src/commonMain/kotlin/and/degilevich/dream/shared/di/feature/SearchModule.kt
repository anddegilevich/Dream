package and.degilevich.dream.shared.di.feature

import and.degilevich.dream.shared.feature.search.source.impl.di.searchSourceModule
import org.koin.dsl.module

fun searchModule() = module {
    includes(searchSourceModule())
}