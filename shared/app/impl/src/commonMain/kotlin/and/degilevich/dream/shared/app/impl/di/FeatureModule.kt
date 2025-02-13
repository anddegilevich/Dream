package and.degilevich.dream.shared.app.impl.di

import and.degilevich.dream.shared.feature.artist.core.impl.di.artistCoreModule
import org.koin.dsl.module

internal fun featureModule() = module {
    includes(artistCoreModule())
}