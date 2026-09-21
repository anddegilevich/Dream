package and.degilevich.dream.shared.feature.artist.component.details.impl.di

import and.degilevich.dream.shared.feature.artist.component.details.api.component.ArtistDetailsComponentFactory
import and.degilevich.dream.shared.feature.artist.component.details.impl.component.ArtistDetailsComponentFactoryImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun artistDetailsComponentModule() = module {
    factoryOf(::ArtistDetailsComponentFactoryImpl) bind ArtistDetailsComponentFactory::class
}
