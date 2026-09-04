package and.degilevich.dream.shared.feature.playlist.component.details.impl.di

import and.degilevich.dream.shared.feature.playlist.component.details.api.component.PlaylistDetailsComponentFactory
import and.degilevich.dream.shared.feature.playlist.component.details.impl.component.PlaylistDetailsComponentFactoryImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun playlistDetailsComponentModule() = module {
    factoryOf(::PlaylistDetailsComponentFactoryImpl) bind PlaylistDetailsComponentFactory::class
}
