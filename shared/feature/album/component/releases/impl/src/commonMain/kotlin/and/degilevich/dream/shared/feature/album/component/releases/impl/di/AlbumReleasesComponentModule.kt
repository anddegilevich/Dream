package and.degilevich.dream.shared.feature.album.component.releases.impl.di

import and.degilevich.dream.shared.feature.album.component.releases.api.component.AlbumReleasesComponentFactory
import and.degilevich.dream.shared.feature.album.component.releases.impl.component.AlbumReleasesComponentFactoryImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun albumReleasesComponentModule() = module {
    factoryOf(::AlbumReleasesComponentFactoryImpl) bind AlbumReleasesComponentFactory::class
}
