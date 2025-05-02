package and.degilevich.dream.shared.di

import and.degilevich.dream.shared.di.feature.artistModule
import and.degilevich.dream.shared.di.feature.imageModule
import org.koin.dsl.module

internal fun featureModule() = module {
    includes(artistModule())
    includes(imageModule())
}