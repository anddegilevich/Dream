package and.degilevich.dream.shared.feature.track.component.liked.impl.di

import and.degilevich.dream.shared.feature.track.component.liked.api.component.LikedTracksComponentFactory
import and.degilevich.dream.shared.feature.track.component.liked.impl.component.LikedTracksComponentFactoryImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun likedTracksComponentModule() = module {
    factoryOf(::LikedTracksComponentFactoryImpl) bind LikedTracksComponentFactory::class
}
