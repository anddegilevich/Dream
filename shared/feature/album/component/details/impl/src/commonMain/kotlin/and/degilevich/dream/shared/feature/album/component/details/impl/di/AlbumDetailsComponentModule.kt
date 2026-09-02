package and.degilevich.dream.shared.feature.album.component.details.impl.di

import and.degilevich.dream.shared.feature.album.component.details.api.component.AlbumDetailsComponentFactory
import and.degilevich.dream.shared.feature.album.component.details.impl.component.AlbumDetailsComponentFactoryImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun albumDetailsComponentModule() = module {
    factoryOf(::AlbumDetailsComponentFactoryImpl) bind AlbumDetailsComponentFactory::class
}
