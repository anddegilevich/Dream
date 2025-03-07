package and.degilevich.dream.shared.feature.artist.core.impl.di

import org.koin.dsl.module

fun artistCoreModule() = module {
    includes(artistSourceModule())
    includes(artistLogicModule())
}