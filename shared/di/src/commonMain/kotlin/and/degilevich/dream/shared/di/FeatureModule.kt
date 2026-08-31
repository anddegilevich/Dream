package and.degilevich.dream.shared.di

import and.degilevich.dream.shared.di.feature.albumModule
import and.degilevich.dream.shared.di.feature.artistModule
import and.degilevich.dream.shared.di.feature.authModule
import and.degilevich.dream.shared.di.feature.commonModule
import and.degilevich.dream.shared.di.feature.imageModule
import and.degilevich.dream.shared.di.feature.playlistModule
import and.degilevich.dream.shared.di.feature.searchModule
import and.degilevich.dream.shared.di.feature.trackModule
import and.degilevich.dream.shared.di.feature.userModule
import org.koin.dsl.module

internal fun featureModule() = module {
    includes(imageModule())
    includes(artistModule())
    includes(albumModule())
    includes(trackModule())
    includes(playlistModule())
    includes(searchModule())
    includes(userModule())
    includes(commonModule())
    includes(authModule())
}