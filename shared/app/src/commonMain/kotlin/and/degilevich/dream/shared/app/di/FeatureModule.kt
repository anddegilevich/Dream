package and.degilevich.dream.shared.app.di

import and.degilevich.dream.shared.feature.artist.core.impl.di.artistCoreModule
import org.koin.dsl.module

fun featureModule() = module {
    includes(artistCoreModule())
}