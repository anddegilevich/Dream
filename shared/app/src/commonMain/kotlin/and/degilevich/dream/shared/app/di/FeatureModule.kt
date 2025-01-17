package and.degilevich.dream.shared.app.di

import and.degilevich.dream.shared.feature.artist.source.impl.di.artistSourceModule
import org.koin.dsl.module

fun featureModule() = module {
    includes(artistSourceModule())
}