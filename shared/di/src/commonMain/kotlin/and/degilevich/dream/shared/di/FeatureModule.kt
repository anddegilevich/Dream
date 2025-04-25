package and.degilevich.dream.shared.di

import and.degilevich.dream.shared.feature.artist.core.impl.di.artistCoreModule
import and.degilevich.dream.shared.feature.artist.design.api.di.artistDesignModule
import org.koin.dsl.module

internal fun featureModule() = module {
    // Artist
    includes(artistCoreModule())
    includes(artistDesignModule())
}