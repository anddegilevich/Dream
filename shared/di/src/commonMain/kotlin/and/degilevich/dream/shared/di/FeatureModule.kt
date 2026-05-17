package and.degilevich.dream.shared.di

import and.degilevich.dream.shared.di.feature.albumModule
import and.degilevich.dream.shared.di.feature.artistModule
import and.degilevich.dream.shared.di.feature.imageModule
import and.degilevich.dream.shared.di.feature.searchModule
import and.degilevich.dream.shared.di.feature.trackModule
import org.koin.dsl.module

internal fun featureModule() = module {
    includes(imageModule())
    includes(artistModule())
    includes(albumModule())
    includes(trackModule())
    includes(searchModule())
}