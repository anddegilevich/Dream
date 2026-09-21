package and.degilevich.dream.shared.feature.playlist.component.list.impl.di

import and.degilevich.dream.shared.feature.playlist.component.list.api.component.PlaylistListComponentFactory
import and.degilevich.dream.shared.feature.playlist.component.list.impl.component.PlaylistListComponentFactoryImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun playlistListComponentModule() = module {
    factoryOf(::PlaylistListComponentFactoryImpl) bind PlaylistListComponentFactory::class
}
